package com.sa.sample.project.service;


import com.sa.sample.project.dto.UserDTO;
import com.sa.sample.project.jwt.JwtUtils;
import com.sa.sample.project.model.Booking;
import com.sa.sample.project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingHotelService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingHotelService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking save(Booking booking) {
   //     User retrivedUser = userRepository.findByEmail(email);
//        var rooms = bookHotel.getRooms().stream().map(room -> {
//            Room aRoom = (Room) roomService.findById(room.getRoomId());
//            aRoom.setBookHotel(bookHotel);
//            return aRoom;
//        }).toList();
//        bookHotel.setRooms(rooms);
//        // System.out.println("Hotel booking: " + bookHotel.getRooms());
//        // if(room!=null) bookHotel.getRooms().add(room);
//        bookHotel.getUserDetails().add(retrivedUser);
        //jwtUtils.getUserNameFromJwtToken(booking.setUserName())
//        UserDTO userDTO =
//        booking.setUserName(jwtUtils.getUserNameFromJwtToken(jwtUtils.getJwtFromCookies()));
        return bookingRepository.save(booking);
    }

    public Booking findById(String string) {
        return bookingRepository.findById(string).get();
    }
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void deleteById(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}
