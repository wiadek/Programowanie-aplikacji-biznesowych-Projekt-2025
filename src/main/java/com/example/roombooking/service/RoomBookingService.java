package com.example.roombooking.service;

import com.example.roombooking.model.RoomBooking;
import com.example.roombooking.repository.RoomBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingService {

    @Autowired
    private RoomBookingRepository roomBookingRepository;

    public void save(RoomBooking roomBooking){
        roomBoookingRepository.save(roomBooking);
    }
}
