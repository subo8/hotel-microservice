package com.sa.finalproject.service;

import com.sa.finalproject.model.Room;
import com.sa.finalproject.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();

    }

    @Override
    public Room findById(String roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("No room with this Id found"));
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);
    }
    @Override
    public Room updateRoom(String roomId, Room room) {
        roomRepository.findById(roomId);
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    @Override
    public Room findByRoomNumber(Integer roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }
}
