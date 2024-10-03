package com.diegokurcbart.activitymanager.exception;

public class ActivityFullException extends RuntimeException {
    public ActivityFullException(String activityName) {
        super(String.format("Activity '%s' is full.", activityName));
    }
}
