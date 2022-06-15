package com.example.rateservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rate")
public class Rate {
    @Id
    private String id;

    private String roomId;
    private String userId;
    private int star;

    public Rate(String id, String roomId, String userId, int star) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.star = star;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
