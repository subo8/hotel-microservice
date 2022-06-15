package com.sa.finalproject.service;


import com.sa.finalproject.model.Room;
import com.sa.finalproject.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Room updateRoomServiceCommunication(Room room) {

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

    @Override
    public Room bookRoomAvailability(String roomId){

        Optional<Room> room =   roomRepository.findById(roomId);

        if(room.isEmpty())
            throw new IllegalArgumentException("Room not exist by id :"+roomId);
        Room coreRoom = room.get();
        if(!coreRoom.isAvailable())
            throw new IllegalStateException("Room ID: "+roomId+" is already booked. Not available and cannot be booked at this time.");

        coreRoom.setAvailable(false);
        coreRoom =  roomRepository.save(coreRoom);

        return coreRoom;
    }

    @Override
    public Room roomCheckout(String roomId){

        Optional<Room> room =   roomRepository.findById(roomId);
        if(room.isEmpty())
            throw new IllegalArgumentException("Room not exist by id :"+roomId);
        Room coreRoom = room.get();
        if(coreRoom.isAvailable())

            throw new IllegalStateException("Room ID: "+roomId+" is already free.");

        coreRoom.setAvailable(true);
        coreRoom =  roomRepository.save(coreRoom);

        return coreRoom;
    }

    @Override
    public List<Room> availableRooms() {
        List<Room> rooms = roomRepository.findAll();
        List<Room> availableRooms = new ArrayList<>();
        for(int i=0; i<rooms.size(); i++){
            if(rooms.get(i).isAvailable() == true){
                availableRooms.add(rooms.get(i));
            }
        }
        if(availableRooms.size()>0) return availableRooms;
        return new ArrayList<>();
    }

    @Override
    public List<Room> notAvailableRooms() {
        List<Room> rooms = roomRepository.findAll();
        List<Room> availableRooms = new ArrayList<>();
        for(int i=0; i<rooms.size(); i++){
            if(rooms.get(i).isAvailable() != true){
                availableRooms.add(rooms.get(i));
            }
        }
        if(availableRooms.size()>0) return availableRooms;
        return new ArrayList<>();
    }
}
