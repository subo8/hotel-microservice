package com.miu.edu.cs590.project.notification.model;

import com.miu.edu.cs590.project.notification.common.Booking;
import com.miu.edu.cs590.project.notification.common.ResponseEntityDTO;
import com.miu.edu.cs590.project.notification.common.Room;
import com.miu.edu.cs590.project.notification.dto.NotificationInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter {

    public static NotificationInfo convertToNotificationInfoFromResponseEntityDTO(ResponseEntityDTO responseEntityDTO) {

        NotificationInfo notificationInfo = new NotificationInfo();
        Booking booking = responseEntityDTO.getBooking();
        Room room = responseEntityDTO.getRoom();

        notificationInfo.setDateOfArrival(booking.getDateOfArrival());
        notificationInfo.setDateOfDeparture(booking.getDateOfDeparture());
        notificationInfo.setNumberOfRooms(booking.getNumberOfRooms());
        notificationInfo.setOtherReservations(booking.getOtherReservations());
        notificationInfo.setUserName(booking.getUserName());
        notificationInfo.setEmail(booking.getEmail());
        notificationInfo.setBookingId(booking.getBookingId());
        notificationInfo.setRoomId(booking.getRoomId());
        notificationInfo.setRoomNumber(room.getRoomNumber());
        notificationInfo.setType(room.getType());
        notificationInfo.setPrice(room.getPrice());
        notificationInfo.setBedType(room.getBedType());
        notificationInfo.setNumberOfBeds(room.getNumberOfBeds());
        notificationInfo.setMaxNumberOfGuests(room.getMaxNumberOfGuests());
        notificationInfo.setSmoking(room.isSmoking());
        notificationInfo.setDescription(room.getDescription());

        return notificationInfo;
    }

    public static NotificationInfoDTO convertToNotificationInfoDTOFromNotificationInfo(NotificationInfo notificationInfo) {

        NotificationInfoDTO notificationInfoDTO = new NotificationInfoDTO();

        notificationInfoDTO.setDateOfArrival(notificationInfo.getDateOfArrival());
        notificationInfoDTO.setDateOfDeparture(notificationInfo.getDateOfDeparture());
        notificationInfoDTO.setNumberOfRooms(notificationInfo.getNumberOfRooms());
        notificationInfoDTO.setOtherReservations(notificationInfo.getOtherReservations());
        notificationInfoDTO.setUserName(notificationInfo.getUserName());
        notificationInfoDTO.setRoomNumber(notificationInfo.getRoomNumber());
        notificationInfoDTO.setEmail(notificationInfo.getEmail());
        notificationInfoDTO.setType(notificationInfo.getType());
        notificationInfoDTO.setPrice(notificationInfo.getPrice());
        notificationInfoDTO.setBedType(notificationInfo.getBedType());
        notificationInfoDTO.setNumberOfBeds(notificationInfo.getNumberOfBeds());
        notificationInfoDTO.setMaxNumberOfGuests(notificationInfo.getMaxNumberOfGuests());
        notificationInfoDTO.setSmoking(notificationInfo.getSmoking());
        notificationInfoDTO.setDescription(notificationInfo.getDescription());

        return notificationInfoDTO;
    }

    public static NotificationInfo convertToNotificationInfoFromNotificationInfoDTO(NotificationInfoDTO notificationInfoDTO) {

        NotificationInfo notificationInfo = new NotificationInfo();

        notificationInfo.setDateOfArrival(notificationInfoDTO.getDateOfArrival());
        notificationInfo.setDateOfDeparture(notificationInfoDTO.getDateOfDeparture());
        notificationInfo.setNumberOfRooms(notificationInfoDTO.getNumberOfRooms());
        notificationInfo.setOtherReservations(notificationInfoDTO.getOtherReservations());
        notificationInfo.setUserName(notificationInfoDTO.getUserName());
        notificationInfo.setRoomNumber(notificationInfoDTO.getRoomNumber());
        notificationInfo.setType(notificationInfoDTO.getType());
        notificationInfo.setEmail(notificationInfoDTO.getEmail());
        notificationInfo.setPrice(notificationInfoDTO.getPrice());
        notificationInfo.setBedType(notificationInfoDTO.getBedType());
        notificationInfo.setNumberOfBeds(notificationInfoDTO.getNumberOfBeds());
        notificationInfo.setMaxNumberOfGuests(notificationInfoDTO.getMaxNumberOfGuests());
        notificationInfo.setSmoking(notificationInfoDTO.isSmoking());
        notificationInfo.setDescription(notificationInfoDTO.getDescription());

        return notificationInfo;
    }

    public static  List<NotificationInfoDTO> convertToNotificationInfoDTOListFromNotificationInfoList(List<NotificationInfo> notificationInfoList) {

        List<NotificationInfoDTO> notificationInfoDTOList = new ArrayList<>();

        for(NotificationInfo notifications : notificationInfoList) {
            notificationInfoDTOList.add(convertToNotificationInfoDTOFromNotificationInfo(notifications));
        }

        return notificationInfoDTOList;
    }

}
