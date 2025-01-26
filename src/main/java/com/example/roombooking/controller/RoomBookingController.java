package com.example.roombooking.controller;

import com.example.roombooking.service.RoomBookingService;
import com.example.roombooking.model.RoomBooking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@Controller
public class RoomBookingController {

    private final RoomBookingService roomBookingService;

    @Autowired
    public RoomBookingController(RoomBookingService roomBookingService) {
        this.roomBookingService = roomBookingService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("roomBooking", new RoomBooking());
        return "booking-form";
    }

    @PostMapping("/book")
    public String bookRoom(@Valid @ModelAttribute("roomBooking") RoomBooking roomBooking, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "booking-form";
        }

        roomBookingService.save(roomBooking); // Zapisujemy rezerwację
        model.addAttribute("successMessage", "Rezerwacja została pomyślnie zarejestrowana!");
        return "success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
}
