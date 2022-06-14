package com.miu.edu.cs590.project.notification.service;

import com.miu.edu.cs590.project.notification.common.InformationTest;
import com.miu.edu.cs590.project.notification.repository.InformationTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InformationTestServiceImpl implements InformationTestService {

    @Autowired
    InformationTestRepository informationTestRepository;

    @Override
    public List<InformationTest> getAllNotifications() {
        return informationTestRepository.findAll();
    }

    @Override
    public List<InformationTest> getByEmail(String email) {
        return informationTestRepository.findByEmail(email);
    }

    @Override
    public void saveInformationTest(InformationTest informationTest) {
        informationTestRepository.save(informationTest);
    }

    @Override
    public InformationTest getByCustomerName(String customerName) {
        return informationTestRepository.findByCustomerName(customerName);
    }

    @Override
    public void deleteByEmail(String email) {
        informationTestRepository.deleteByEmail(email);
    }
}
