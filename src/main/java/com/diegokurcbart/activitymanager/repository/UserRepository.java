package com.diegokurcbart.activitymanager.repository;

import com.diegokurcbart.activitymanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
