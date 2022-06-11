package com.sa.sample.project.controller;

import com.sa.sample.project.model.Booking;
import com.sa.sample.project.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    @Autowired
     BookingService bookingService;

    @PostMapping("/")
    public Booking saveBooking(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }
    @PutMapping("/{bookingId}")
    public  Booking updateBooking(@PathVariable ("bookingId") Integer bookingId, @RequestBody Booking booking){
        bookingService.findById(bookingId);
        booking.setBookingId(bookingId);
        return bookingService.save(booking);
    }
    @GetMapping("/")
    private List<Booking> bookings() {
        return bookingService.findAll();
    }
    @GetMapping("/{bookingId}")
    private Booking findBookingById(@PathVariable ("bookingId") Integer bookingId) {
        return bookingService.findById(bookingId);
    }
    @DeleteMapping("/{bookingId}")
    private void deleteBookingById(@PathVariable ("bookingId") Integer bookingId) {
        bookingService.deleteById(bookingId);
    }
}
