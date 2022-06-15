package com.miu.edu.cs590.project.notification.service;

import com.miu.edu.cs590.project.notification.common.InformationTest;

public interface EmailService {
    void sendEmailWithImage(String emailInfo, InformationTest informationTest);
}
