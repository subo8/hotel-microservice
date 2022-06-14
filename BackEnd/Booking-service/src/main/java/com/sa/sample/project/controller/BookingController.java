package com.sa.sample.project.controller;

import com.sa.sample.project.jwt.JwtUtils;
import com.sa.sample.project.model.Booking;
import com.sa.sample.project.service.BookingHotelService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/booking")
@RestController
public class BookingController {
     private final BookingHotelService bookingService;

     @Autowired
             JwtUtils jwtUtils;

    @PostMapping("/")
    public String saveBooking(@RequestBody Booking booking, HttpServletRequest request ) {
        Cookie cookie = WebUtils.getCookie(request, "subo8");
    //    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie !=null){
            String jwt = cookie.getValue();
            String username = jwtUtils.getUserNameFromJwtToken(jwt);
//        Claims claims = Jwts.parser().setSigningKey("SecretKey!").parseClaimsJws(jwt).getBody();
//        System.out.println(claims.getSubject());
//        String print2 = (String) claims.get("userId");
//        System.out.println(print2);
//        System.out.println(cookie.getValue());
            booking.setUserName(username);
           bookingService.save(booking);
           return "Booking saved successfully";
        }else
        return "Please login";
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
