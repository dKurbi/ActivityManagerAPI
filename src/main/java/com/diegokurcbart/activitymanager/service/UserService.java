package com.diegokurcbart.activitymanager.service;

import com.diegokurcbart.activitymanager.dto.ActivityDTO;
import com.diegokurcbart.activitymanager.dto.UserDTO;
import com.diegokurcbart.activitymanager.exception.*;
import com.diegokurcbart.activitymanager.model.Activity;
import com.diegokurcbart.activitymanager.model.User;
import com.diegokurcbart.activitymanager.repository.ActivityRepository;
import com.diegokurcbart.activitymanager.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    // Retrieve all users and convert them to UserDTO
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Retrieve a specific user by ID and convert to UserDTO
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(this::toDTO);
    }

    // Save a new user by converting UserDTO to User entity
    public UserDTO saveUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        try {
            User savedUser = userRepository.save(user);
            return toDTO(savedUser);
        } catch (DataIntegrityViolationException e) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        // Ensure the user exists before attempting to delete
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    // List of activities that the user is joining
    public List<ActivityDTO> getUserActivities(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));


        return user.getActivities().stream()
                .map(ActivityDTO::new)
                .collect(Collectors.toList());
    }

    // Method to add a user to an activity
    @Transactional
    public void addUserToActivity(Long userId, Long activityId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(activityId));

        if (activity.getUsers().size() >= activity.getMaxCapacity()) {
            throw new ActivityFullException(activity.getName());
        }

        boolean added = user.addActivity(activity);
        if (!added) {
            throw new UserAlreadyRegisteredException(user.getName(), activity.getName());
        }
    }
    // Method to remove a user from an activity
    @Transactional
    public void removeUserFromActivity(Long userId, Long activityId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(activityId));

        boolean removed = user.removeActivity(activity);
        if (!removed) {
            throw new UserNotRegisteredException(user.getName(), activity.getName());
        }
    }

    // Method to update user information
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getSurname() != null) {
            user.setSurname(userDTO.getSurname());
        }
        if (userDTO.getBirthDate() != null) {
            user.setBirthDate(userDTO.getBirthDate());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        User updatedUser = userRepository.save(user);
        return new UserDTO(updatedUser);
    }

    // PRIVATE METHODS

    // Convert User entity to UserDTO
    private UserDTO toDTO(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getName(),
                user.getSurname(),
                user.getBirthDate(),
                user.getEmail()
        );
    }

    // Convert UserDTO to User entity
    private User toEntity(UserDTO userDTO) {
        return new User(
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getBirthDate(),
                userDTO.getEmail()
        );
    }
}

