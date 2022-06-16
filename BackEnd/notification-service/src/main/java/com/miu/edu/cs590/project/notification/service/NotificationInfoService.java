package com.miu.edu.cs590.project.notification.service;

import com.miu.edu.cs590.project.notification.dto.NotificationInfoDTO;
import com.miu.edu.cs590.project.notification.model.InformationTest;
import com.miu.edu.cs590.project.notification.model.NotificationInfo;

import java.util.List;

public interface NotificationInfoService {

    List<NotificationInfoDTO> getAllNotifications();
    List<NotificationInfoDTO> getByEmail(String email);
    NotificationInfoDTO getByUserName(String userName);
    void deleteByEmail(String email);
    void saveNotificationInfo(NotificationInfo notificationInfo);
}
