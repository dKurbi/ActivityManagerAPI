package com.diegokurcbart.activitymanager.exception;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String userName, String activityName) {
        super(String.format("User '%s' is already registered for activity '%s'.", userName, activityName));
    }
}
