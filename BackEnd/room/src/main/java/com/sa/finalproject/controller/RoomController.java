package com.sa.finalproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.finalproject.model.Room;
import com.sa.finalproject.security.jwt.JwtUtils;
import com.sa.finalproject.service.RoomService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.core.util.Json;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    //@Value("${subo8.app.jwtSecret}")
   // private String jwtSecret;

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    //get all room data for admin and user job role

    @GetMapping
    //@PreAuthorize("hasRole('USER')")
    public List<Room> getRooms(HttpServletRequest request) {

        return roomService.getRooms();
    }


    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable String roomId) {
        return roomService.findById(roomId);
    }

    @GetMapping("/no/{roomNumber}")
    public Room getRoomByRoomNumber(@PathVariable Integer roomNumber) {
        return roomService.findByRoomNumber(roomNumber);
    }


    @PostMapping("/")
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable String roomId) {
        roomService.deleteRoom(roomId);
    }

    @PutMapping("/{roomId}")
    public Room updateRoom(@PathVariable String roomId, @RequestBody Room room) {
        return roomService.updateRoom(roomId, room);

    }

    @GetMapping("/bookroom/{roomId}")
    public ResponseEntity<Object> bookRoomById(@PathVariable String roomId) {
        Room room = null;

        try {
            room = roomService.bookRoomAvailability(roomId);
        }catch (IllegalStateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("/releaseroom/{roomId}")
    public ResponseEntity<Object> releaseRoomById(@PathVariable String roomId) {
        Room room = null;

        try {
            room = roomService.releaseRoomAvailability(roomId);
        }catch (IllegalStateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

}
