package com.npci.user_management_application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.user_management_application.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
