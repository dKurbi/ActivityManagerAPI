package com.diegokurcbart.activitymanager.service;

import com.diegokurcbart.activitymanager.dto.ActivityDTO;
import com.diegokurcbart.activitymanager.dto.UserDTO;
import com.diegokurcbart.activitymanager.exception.ActivityNotFoundException;
import com.diegokurcbart.activitymanager.model.Activity;
import com.diegokurcbart.activitymanager.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    // Retrieve all activities and convert them to ActivityDTO
    public List<ActivityDTO> getAllActivities() {
        return activityRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Retrieve a specific activity by ID and convert to ActivityDTO
    public ActivityDTO getActivityById(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new ActivityNotFoundException(id)); // Throw custom exception if not found
        return toDTO(activity);
    }

    // Save a new activity by converting ActivityDTO to Activity entity
    public ActivityDTO saveActivity(ActivityDTO activityDTO) {
        Activity activity = toEntity(activityDTO);
        Activity savedActivity = activityRepository.save(activity);
        return toDTO(savedActivity);
    }

    // Delete an activity by ID
    public void deleteActivity(Long id) {
        // Ensure the user exists before attempting to delete
        if (!activityRepository.existsById(id)) {
            throw new ActivityNotFoundException(id);
        }
        activityRepository.deleteById(id);
    }


    public List<UserDTO> getUsersByActivity(Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(activityId));

        List<UserDTO> userDTOs = activity.getUsers().stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());

        return userDTOs;
    }

    //PRIVATE METHODS
    // Convert Activity entity to ActivityDTO
    private ActivityDTO toDTO(Activity activity) {
        return new ActivityDTO(activity); // Convert users to user IDs
    }

    // Convert ActivityDTO to Activity entity
    private Activity toEntity(ActivityDTO activityDTO) {
        return new Activity(
                activityDTO.getName(),
                activityDTO.getDescription(),
                activityDTO.getMaxCapacity()
        );
    }
}

