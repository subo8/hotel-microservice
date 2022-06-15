package com.example.rateservice;

import com.example.rateservice.controller.RateController;
import com.example.rateservice.repository.RateRepository;
import com.example.rateservice.service.RateService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RateServiceApplicationTests {

	private RateService rateService;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private RateRepository rateRepository;

//	@Befor

	@Test
	void contextLoads() {
	}

}
