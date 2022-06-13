package com.sa.finalproject.service;

import com.sa.finalproject.model.Room;
import java.util.List;

public interface RoomService {
    public abstract List<Room> getRooms();
    public abstract Room findById(Long roomId);
    public abstract Room createRoom(Room room);
    public abstract void deleteRoom(Long roomId);
    public abstract Room updateRoom(Long roomId,Room room);
    public abstract Room findByRoomNumber(Integer roomNumber);
}
