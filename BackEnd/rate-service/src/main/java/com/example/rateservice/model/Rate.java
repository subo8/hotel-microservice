package com.example.rateservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rate")
public class Rate {
    @Id
    private String id;


    private int roomId = 1;
    private int userId = 1;
    private int star = 1;

    public Rate(int roomId, int userId, int star) {
        this.roomId = roomId;
        this.userId = userId;
        this.star = star;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", roomId=" + roomId +
                ", userId=" + userId +
                ", star=" + star +
                '}';
    }
}
