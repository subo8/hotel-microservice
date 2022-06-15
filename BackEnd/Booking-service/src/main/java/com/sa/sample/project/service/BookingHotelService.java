package com.sa.sample.project.service;

import com.sa.sample.project.dto.ResponseEntityDTO;
import com.sa.sample.project.dto.Room;
import com.sa.sample.project.model.Booking;
import com.sa.sample.project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class BookingHotelService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    RestTemplate restTemplate;

    public BookingHotelService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking save(Booking booking) {
        ResponseEntityDTO responseEntityDTO = new ResponseEntityDTO();
        Booking booking1 = new Booking();
        Room room = restTemplate.getForObject("http://localhost:8088/room" , Room.class,booking.getRoomId());
        System.out.println(room);
        //UserAccount account = restTemplate.getForObject("http://ACCOUNT-SERVICE/account-internal/{accountId}",UserAccount.class,order1.getUserAccountId());
        assert room != null;
        room.setAvailable(false);

        responseEntityDTO.setBooking(booking1);
        responseEntityDTO.setRoom(room);
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
