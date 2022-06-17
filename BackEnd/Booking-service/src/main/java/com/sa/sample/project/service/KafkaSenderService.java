package com.sa.sample.project.service;

import com.sa.sample.project.kafka.KafkaPackage;

public interface KafkaSenderService {

    void receiveEvent(KafkaPackage kafkaPackage);

}
