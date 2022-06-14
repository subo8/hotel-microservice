package com.sa.sample.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.sample.project.dto.ResponseEntityDTO;
import com.sa.sample.project.dto.Room;
import com.sa.sample.project.model.Booking;
import com.sa.sample.project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> save(Booking booking) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntityDTO responseEntityDTO = new ResponseEntityDTO();
        Booking booking1 = new Booking();
        Room room = restTemplate.getForObject("http://localhost:8088/room/{roomId}" , Room.class,booking.getRoomId());
        System.out.println("++++++++++++ Room Before" + room);
        assert room != null;
        room.setAvailable(false);
        String roomString = objectMapper.writeValueAsString(room);
       // System.out.println("++++++++++++ Room After" + room);
        restTemplate.put("http://localhost:8088/room/" , roomString, String.class);
        //UserAccount account = restTemplate.getForObject("http://ACCOUNT-SERVICE/account-internal/{accountId}",UserAccount.class,order1.getUserAccountId());

        responseEntityDTO.setBooking(booking1);
        responseEntityDTO.setRoom(room);
        System.out.println("++++++++++++ Room After" + room);
        if (!room.isAvailable()){
            return   new ResponseEntity<String>("Room already booked", HttpStatus.NOT_ACCEPTABLE);
        }else
        return new ResponseEntity<Booking>(bookingRepository.save(booking), HttpStatus.CREATED);
    }

    public ResponseEntityDTO findById(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        Room room = restTemplate.getForObject("http://localhost:8088/room/{roomId}" , Room.class,booking.getRoomId());
        return new ResponseEntityDTO(booking,room);

    }
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void deleteById(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}
