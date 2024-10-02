package com.diegokurcbart.activitymanager.exception;

public class ActivityFullException extends RuntimeException {
    public ActivityFullException(String activityName) {
        super(String.format("The activity '%s' is full and cannot accept more users.", activityName));
    }
}
