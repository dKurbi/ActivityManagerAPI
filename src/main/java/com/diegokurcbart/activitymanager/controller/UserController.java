package com.diegokurcbart.activitymanager.controller;

import com.diegokurcbart.activitymanager.dto.ActivityDTO;
import com.diegokurcbart.activitymanager.dto.UserDTO;
import com.diegokurcbart.activitymanager.exception.UserNotFoundException;
import com.diegokurcbart.activitymanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to retrieve all users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Endpoint to retrieve a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));  // Use the custom exception here
        return ResponseEntity.ok(user);  // 200 OK
    }

    // Endpoint to create a new user
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.status(201).body(savedUser);  // 201 Created
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }

    // Endpoint to add a user to an activity
    @PostMapping("/{userId}/activities/{activityId}")
    public ResponseEntity<String> addUserToActivity(@PathVariable Long userId, @PathVariable Long activityId) {
        userService.addUserToActivity(userId, activityId);
        String message = String.format("User %d added to activity %d successfully.", userId, activityId);
        return ResponseEntity.ok(message); // 200 OK
    }

    // Endpoint to remove a user to an activity
    @DeleteMapping("/{userId}/activities/{activityId}")
    public ResponseEntity<String> removeUserFromActivity(@PathVariable Long userId, @PathVariable Long activityId) {
        userService.removeUserFromActivity(userId, activityId);
        String message = String.format("User %d removed from activity %d successfully.", userId, activityId);
        return ResponseEntity.ok(message); // 200 OK
    }


    // Endpoint to list the activities that the user is joining
    @GetMapping("/{userId}/activities")
    public ResponseEntity<List<ActivityDTO>> getUserActivities(@PathVariable Long userId) {
        List<ActivityDTO> activities = userService.getUserActivities(userId);
        return ResponseEntity.ok(activities);  // 200 OK if successful
    }

    // Endpoint to update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserDTO userDTO) {

        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);  // 200 OK with the user updated
    }

}
