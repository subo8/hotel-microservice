package com.sa.sample.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sa.sample.project.dto.ResponseEntityDTO;
import com.sa.sample.project.jwt.JwtUtils;
import com.sa.sample.project.model.Booking;
import com.sa.sample.project.service.BookingHotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/")
@RestController
public class BookingController {
     private final BookingHotelService bookingService;

     @Autowired
             JwtUtils jwtUtils;

    @PostMapping("/")
    public ResponseEntity<?> saveBooking(@RequestBody Booking booking, HttpServletRequest request ) throws JsonProcessingException {
//        Cookie cookie = WebUtils.getCookie(request, "subo8");
//        if (cookie !=null){
//            String jwt = cookie.getValue();
//            String username = jwtUtils.getUserNameFromJwtToken(jwt);
//            booking.setUserName(username);
//         //  bookingService.save(booking, request);
//           return bookingService.save(booking,request);
//        }else
       return new ResponseEntity<String>("Please Login", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/")
    private List<Booking> bookings() {
        return bookingService.findAll();
    }
    @GetMapping("/{bookingId}")
    private ResponseEntityDTO findBookingById(@PathVariable ("bookingId") String bookingId) {
        return bookingService.findById(bookingId);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<?> updateBooking(@PathVariable ("bookingId") String bookingId, @RequestBody Booking booking, HttpServletRequest request) throws JsonProcessingException {
        bookingService.findById(bookingId);
        booking.setBookingId(bookingId);
        return bookingService.save(booking,request);
    }

    @DeleteMapping("/{bookingId}")
    private void deleteBookingById(@PathVariable ("bookingId") String bookingId) {
        bookingService.deleteById(bookingId);
    }
}
