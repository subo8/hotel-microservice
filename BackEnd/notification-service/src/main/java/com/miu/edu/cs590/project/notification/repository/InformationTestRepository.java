package com.miu.edu.cs590.project.notification.repository;

import com.miu.edu.cs590.project.notification.common.InformationTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationTestRepository extends MongoRepository<InformationTest, String> {

    List<InformationTest> findByEmail(String email);
    InformationTest findByCustomerName(String email);
    void deleteByEmail(String email);
}
