package com.sa.sample.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.sample.project.dto.CreditCardDto;
import com.sa.sample.project.dto.ResponseEntityDTO;
import com.sa.sample.project.dto.Room;
import com.sa.sample.project.jwt.JwtUtils;
import com.sa.sample.project.model.Booking;
import com.sa.sample.project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BookingHotelService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JwtUtils jwtUtils;

    public BookingHotelService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public ResponseEntity<?> save(Booking booking, HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntityDTO responseEntityDTO = new ResponseEntityDTO();
//        String cookieFrontEnd = request.getHeader("Headers");
//        System.out.println("What is this "+ cookieFrontEnd);
        Booking booking1 = new Booking();
        Cookie cookie = WebUtils.getCookie(request, "subo8");
//        System.out.println("Do we get the cookie? " + cookie);
//        HttpHeaders headers = new HttpHeaders();
//        assert cookie != null;
//        headers.add("subo8", cookie.getValue());
//        HttpEntity<?> entity = new HttpEntity<>(headers);

        //  Byambad add start
        HttpHeaders headers = new HttpHeaders();
        headers.add("subo8", cookie.getValue());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        //  Byambad add end

        if (cookie!= null) {
         //   System.out.println(cookie.getValue());
         //   String jwt = cookie.getValue();
            String jwt = cookie.getValue();
            String username = jwtUtils.getUserNameFromJwtToken(jwt);
            booking.setUserName(username);
            ResponseEntity<Room> room = restTemplate.exchange("http://localhost:8088/room/{roomId}", HttpMethod.GET, entity, Room.class, booking.getRoomId());

            CreditCardDto creditCardDto = restTemplate.getForObject("http://localhost:9001/creditcards/{creditCardId}", CreditCardDto.class, booking.getCreditCardId());
            assert room != null;
            System.out.println("++++++++++++ Room Before" + room.getBody().isAvailable());
           // assert room != null;
            room.getBody().setAvailable(false);
            assert creditCardDto != null;
            if (booking.getAmount() > creditCardDto.getBalance() && room.getBody().isAvailable()){
                System.out.println("You have  insufficient amount");
                return null;
            }else
            creditCardDto.setBalance(creditCardDto.getBalance()-booking.getAmount());
            String roomString = objectMapper.writeValueAsString(room.getBody());
            String creditCardString = objectMapper.writeValueAsString(creditCardDto);
            restTemplate.put("http://localhost:8088/room/", roomString, String.class);
            restTemplate.put("http://localhost:9001/creditcards/", creditCardString, String.class);

            responseEntityDTO.setBooking(booking1);
            responseEntityDTO.setRoom(room.getBody());
            responseEntityDTO.setCreditCardDto(creditCardDto);
            System.out.println("++++++++++++ Room After" + room);
//            if (!room.isAvailable()) {
//           //     return new ResponseEntity<>("Room already booked", HttpStatus.NOT_ACCEPTABLE);
//                return null;
//            } else
                return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.CREATED);
        }else
        return new ResponseEntity<String>("Please Login", HttpStatus.FORBIDDEN);
    }


//        Room room = restTemplate.getForObject("http://localhost:8088/{roomId}" , Room.class,booking.getRoomId());
//        System.out.println("++++++++++++ Room Before" + room);
//        assert room != null;
//        room.setAvailable(false);
//        String roomString = objectMapper.writeValueAsString(room);
//       // System.out.println("++++++++++++ Room After" + room);
//        restTemplate.put("http://localhost:8088/" , roomString, String.class);
//        //UserAccount account = restTemplate.getForObject("http://ACCOUNT-SERVICE/account-internal/{accountId}",UserAccount.class,order1.getUserAccountId());
//
//        responseEntityDTO.setBooking(booking1);
//        responseEntityDTO.setRoom(room);
//        System.out.println("++++++++++++ Room After" + room);
//        if (!room.isAvailable()){
//            return   new ResponseEntity<String>("Room already booked", HttpStatus.NOT_ACCEPTABLE);
//        }else
//        return new ResponseEntity<Booking>(bookingRepository.save(booking), HttpStatus.CREATED);

//        Room room = restTemplate.getForObject("http://localhost:8088/room" , Room.class,booking.getRoomId());
//        System.out.println(room);
//        //UserAccount account = restTemplate.getForObject("http://ACCOUNT-SERVICE/account-internal/{accountId}",UserAccount.class,order1.getUserAccountId());
//        assert room != null;
//        room.setAvailable(false);
//
//        responseEntityDTO.setBooking(booking1);
//        responseEntityDTO.setRoom(room);
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
  //      return bookingRepository.save(booking);



    public ResponseEntityDTO findById(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        Room room = restTemplate.getForObject("http://localhost:8088/room/{roomId}" , Room.class,booking.getRoomId());
        CreditCardDto creditCardDto = restTemplate.getForObject("http://localhost:9001/{creditCardId}", CreditCardDto.class, booking.getCreditCardId());
        return new ResponseEntityDTO(booking,room, creditCardDto);

    }
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void deleteById(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}
