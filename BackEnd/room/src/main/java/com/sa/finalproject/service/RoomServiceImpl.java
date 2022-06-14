package com.sa.finalproject.service;

import com.sa.finalproject.model.Room;
import com.sa.finalproject.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Optional;

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
        Room roomDb =  roomRepository.findByRoomNumber(room.getRoomNumber());
        if(roomDb != null)
            throw new DuplicateFormatFlagsException("Room Number : "+room.getRoomNumber()+" is already exist. Try Another");

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

    public Room bookRoomAvailability(String roomId){

        Optional<Room> room =   roomRepository.findById(roomId);

        if(room.isEmpty())
            throw new IllegalArgumentException("Room not exist by id :"+roomId);
        Room coreRoom = room.get();
        if(coreRoom.isAvailable()==false)
            throw new IllegalStateException("Room ID: "+roomId+" is already booked. Not available and cannot be booked at this time.");

        coreRoom.setAvailable(false);
        coreRoom =  roomRepository.save(coreRoom);

        return coreRoom;
    }

    public Room roomCheckout(String roomId){
        Optional<Room> room =   roomRepository.findById(roomId);

        if(room.isEmpty())
            throw new IllegalArgumentException("Room not exist by id :"+roomId);
        Room coreRoom = room.get();
        if(coreRoom.isAvailable()==true)
            throw new IllegalStateException("Room ID: "+roomId+" is  free.");

        coreRoom.setAvailable(true);
        coreRoom =  roomRepository.save(coreRoom);

        return coreRoom;
    }


}
