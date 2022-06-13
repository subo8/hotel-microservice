package com.example.rateservice.payload.request;

public class RateRequest {

    private int roomId;
    private int userId;
    private int star;

    public RateRequest(int roomId, int userId, int star) {
        this.roomId = roomId;
        this.userId = userId;
        this.star = star;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
