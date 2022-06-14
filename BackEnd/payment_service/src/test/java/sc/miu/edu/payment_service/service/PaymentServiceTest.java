package sc.miu.edu.payment_service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sc.miu.edu.payment_service.clientfeign.PaypalFeignClient;
import sc.miu.edu.payment_service.domain.AccountType;
import sc.miu.edu.payment_service.domain.PaymentInformation;
import sc.miu.edu.payment_service.dto.PaymentInformationResponse;
import sc.miu.edu.payment_service.dto.PaypalDto;
import sc.miu.edu.payment_service.dto.Status;
import sc.miu.edu.payment_service.repository.PaymentRepo;
import sc.miu.edu.payment_service.utils.GeneratorClass;

import java.time.LocalDateTime;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class PaymentServiceTest {
    @MockBean
    private PaypalFeignClient paypalFeignClient;
    @MockBean
    private GeneratorClass generatorClass;

    @MockBean
    private PaymentRepo paymentRepo;

    @Test
    public void whenVerifySavePaypalPayment() {
        PaypalDto paypalDto = PaypalDto.builder()
                .balance(10.0)
                .customerId(2)
                .emailAddress("giripriya@gmail.com")
                .secureKey("1111111")

                .build();

         paypalFeignClient.verifyPurchase(paypalDto);

//        if (response.getBody().getStatus() == Status.FAILURE) {
//            System.out.println("Response: " + response.getBody().getStatus());
//        };

        PaymentInformation paymentInformation = paymentRepo.save(PaymentInformation.builder()
                .transactionCode(generatorClass.transactionCodeGenerator())
                .accountType(AccountType.PAYPAL)
                .customerId(paypalDto.getCustomerId())
                .totalPayment(paypalDto.getBalance())
                .transactionDate(LocalDateTime.now())
                .build());


        System.out.println("testpayment" + paymentInformation);
        verify(paypalFeignClient, times(1)).verifyPurchase(paypalDto);
//        verify(paymentRepo, times(1)).save(paymentInformation);
        verify(generatorClass, times(1)).transactionCodeGenerator();
    }


}
