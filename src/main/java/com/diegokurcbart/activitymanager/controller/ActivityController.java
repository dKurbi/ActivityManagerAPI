package com.diegokurcbart.activitymanager.controller;

import com.diegokurcbart.activitymanager.dto.ActivityDTO;
import com.diegokurcbart.activitymanager.dto.UserDTO;
import com.diegokurcbart.activitymanager.exception.ActivityNotFoundException;
import com.diegokurcbart.activitymanager.service.ActivityService;
import com.diegokurcbart.activitymanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    // Endpoint to retrieve all activities
    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getAllActivities() {
        List<ActivityDTO> activities = activityService.getAllActivities();
        return ResponseEntity.ok(activities);  // 200 OK
    }

    // Endpoint to retrieve a specific activity by ID
    @GetMapping("/{id}")
    public ResponseEntity<ActivityDTO> getActivityById(@PathVariable Long id) {
        ActivityDTO activity = activityService.getActivityById(id);
        return ResponseEntity.ok(activity);  // 200 OK
    }

    // Endpoint to create a new activity
    @PostMapping
    public ResponseEntity<ActivityDTO> createActivity(@Valid @RequestBody ActivityDTO activityDTO) {
        ActivityDTO savedActivity = activityService.saveActivity(activityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);  // 201 Created
    }

    // Endpoint to delete an activity by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }


    // Endpoint to retrieve users of an activity
    @GetMapping("/{activityId}/users")
    public ResponseEntity<List<UserDTO>> getUsersByActivity(@PathVariable Long activityId) {
        List<UserDTO> users = activityService.getUsersByActivity(activityId);
        return ResponseEntity.ok(users);  // Return 200 OK with the list of users
    }
}
