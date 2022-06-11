package com.miu.edu.cs590.project.producer.service;

import com.miu.edu.cs590.project.producer.domain.InformationTest;

public interface KafkaSenderService {

    void receiveEvent(InformationTest informationTest);

}
