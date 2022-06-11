package com.sa.sample.project.service;

import com.sa.sample.project.model.Booking;
import com.sa.sample.project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public Booking save( Booking booking) {
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
        return bookingRepository.save(booking);
    }

    public Booking findById(Integer integer) {
        return bookingRepository.findById(integer).get();
    }

    public boolean existsById(Integer integer) {
        return bookingRepository.existsById(integer);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void deleteById(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}
