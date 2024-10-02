package com.diegokurcbart.activitymanager.exception;
public class UserNotRegisteredException extends RuntimeException {
    public UserNotRegisteredException(String userName, String activityName) {
        super(String.format("User '%s' is not registered in activity '%s'.", userName, activityName));
    }
}
