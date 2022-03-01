package com.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mts.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
