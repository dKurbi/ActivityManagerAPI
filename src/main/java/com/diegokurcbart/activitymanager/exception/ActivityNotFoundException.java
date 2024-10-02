package com.diegokurcbart.activitymanager.exception;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(Long activityId) {
        super("Activity with ID " + activityId + " doesn't exist");
    }
}
