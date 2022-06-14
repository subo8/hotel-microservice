package com.sa.finalproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.finalproject.model.Room;
import com.sa.finalproject.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomService.getRooms();
    }


    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable String roomId) {
        return roomService.findById(roomId);
    }

    @PostMapping("/")
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable String roomId) {
        roomService.deleteRoom(roomId);
    }

    @PutMapping("/")
    public Room updateRoomServiceLevel(@RequestBody String room) {
        ObjectMapper objectMapper = new ObjectMapper();

        Room room1 = null;
        try {
            room1 = objectMapper.readValue(room, Room.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return roomService.updateRoomServiceCommunication(room1);
    }
}
