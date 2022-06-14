package com.miu.edu.cs590.project.notification.service;

import com.miu.edu.cs590.project.notification.common.InformationTest;

import java.util.List;

public interface InformationTestService {

    List<InformationTest> getAllNotifications();
    List<InformationTest> getByEmail(String email);
    void saveInformationTest(InformationTest informationTest);
    InformationTest getByCustomerName(String customerName);
    void deleteByEmail(String email);
}
