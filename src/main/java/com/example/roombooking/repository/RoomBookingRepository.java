package com.example.roombooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.roombooking.model.RoomBooking;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Long> {
}
