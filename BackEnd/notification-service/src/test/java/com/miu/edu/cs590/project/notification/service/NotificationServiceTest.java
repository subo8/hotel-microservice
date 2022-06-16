package com.miu.edu.cs590.project.notification.service;

import com.miu.edu.cs590.project.notification.model.InformationTest;
import com.miu.edu.cs590.project.notification.repository.NotificationInfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class NotificationServiceTest {

    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {

        @Bean
        public NotificationInfoService informationTestService() {
            return new NotificationInfoServiceImpl();
        }
    }

    @Autowired
    private NotificationInfoService notificationInfoService;

    @MockBean
    private NotificationInfoRepository notificationInfoRepository;

    @Before
    public void setUp() {
        InformationTest informationTest = new InformationTest("Samuel", "675-3456-2456", "sbartolome@miu.edu", "Credit Card", "1000 North 4St, MIU", "Double", "$34.50");
//        Mockito.when(notificationInfoRepository.findByCustomerName(informationTest.getCustomerName())).thenReturn(informationTest);
    }

    @Test
    public void whenValidInformationTestCustomerNameThenInformationTestAccountShouldBeFound() {
//        InformationTest found = notificationInfoService.getByCustomerName("Samuel");

//        assertThat(found.getCustomerName()).isEqualTo("Samuel");
//        assertThat(found.getCustomerPhoneNumber()).isEqualTo("675-3456-2456");
//        assertThat(found.getEmail()).isEqualTo("sbartolome@miu.edu");
//        assertThat(found.getTypeOfPayment()).isEqualTo("Credit Card");
//        assertThat(found.getAddress()).isEqualTo("1000 North 4St, MIU");
//        assertThat(found.getRoomType()).isEqualTo("Double");
//        assertThat(found.getPrice()).isEqualTo("$34.50");
    }

}
