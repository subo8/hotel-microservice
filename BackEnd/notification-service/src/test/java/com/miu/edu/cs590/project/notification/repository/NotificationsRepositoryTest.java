package com.miu.edu.cs590.project.notification.repository;

import com.miu.edu.cs590.project.notification.model.InformationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
@DataMongoTest
public class NotificationsRepositoryTest {

    @Autowired
    private NotificationInfoRepository notificationInfoRepository;

    @Test
    public void whenFindByEmail_thenReturnInformationTest() {

        InformationTest informationTest = new InformationTest("Samuel", "675-3456-2456", "sbartolome@miu.edu", "Credit Card", "1000 North 4St, MIU", "Double", "$34.50");

//        notificationInfoRepository.save(informationTest);
//
//        InformationTest found = notificationInfoRepository.findByCustomerName(informationTest.getCustomerName());

//        assertThat(informationTest.getCustomerName()).isEqualTo(found.getCustomerName());
//        assertThat(informationTest.getCustomerPhoneNumber()).isEqualTo(found.getCustomerPhoneNumber());
//        assertThat(informationTest.getEmail()).isEqualTo(found.getEmail());
//        assertThat(informationTest.getTypeOfPayment()).isEqualTo(found.getTypeOfPayment());
//        assertThat(informationTest.getAddress()).isEqualTo(found.getAddress());
//        assertThat(informationTest.getRoomType()).isEqualTo(found.getRoomType());
//        assertThat(informationTest.getPrice()).isEqualTo(found.getPrice());

    }

}
