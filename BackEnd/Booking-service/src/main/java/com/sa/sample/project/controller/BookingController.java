package com.sa.sample.project.controller;

import com.sa.sample.project.model.Booking;
import com.sa.sample.project.service.BookingHotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/v1/booking")
@RestController
public class BookingController {
     private final BookingHotelService bookingService;

    @PostMapping("/")
    public Booking saveBooking(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }
    @PutMapping("/{bookingId}")
    public  Booking updateBooking(@PathVariable ("bookingId") String bookingId, @RequestBody Booking booking){
        bookingService.findById(bookingId);
        booking.setBookingId(bookingId);
        return bookingService.save(booking);
    }
    @GetMapping("/")
    private List<Booking> bookings() {
        return bookingService.findAll();
    }
    @GetMapping("/{bookingId}")
    private Booking findBookingById(@PathVariable ("bookingId") String bookingId) {
        return bookingService.findById(bookingId);
    }
    @DeleteMapping("/{bookingId}")
    private void deleteBookingById(@PathVariable ("bookingId") String bookingId) {
        bookingService.deleteById(bookingId);
    }
}
