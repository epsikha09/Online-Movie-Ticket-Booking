package com.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mts.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
