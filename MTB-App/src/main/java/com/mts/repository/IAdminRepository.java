package com.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mts.model.User;

public interface IAdminRepository extends JpaRepository<User, Integer> {

}