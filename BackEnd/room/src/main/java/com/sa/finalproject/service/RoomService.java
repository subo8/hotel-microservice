package com.sa.finalproject.service;

import com.sa.finalproject.model.Room;
import java.util.List;

public interface RoomService {
    public abstract List<Room> getRooms();
    public abstract Room findById(String roomId);
    public abstract Room createRoom(Room room);
    public abstract void deleteRoom(String roomId);
    public abstract Room updateRoom(String roomId,Room room);
    public abstract Room findByRoomNumber(Integer roomNumber);
    public abstract Room bookRoomAvailability(String roomId);
    public abstract Room roomCheckout(String roomId);
}
