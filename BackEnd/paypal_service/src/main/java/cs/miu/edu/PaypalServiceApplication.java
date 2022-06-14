package cs.miu.edu;

import cs.miu.edu.domain.Paypal;
import cs.miu.edu.repository.PaypalRepo;
import cs.miu.edu.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableDiscoveryClient
public class PaypalServiceApplication implements CommandLineRunner {
    @Autowired
    private PaypalRepo paypalRepo;

    public static void main(String[] args) {
        SpringApplication.run(PaypalServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        loadPaypalData();
    }

    public void loadPaypalData() {
        List<Paypal> paypalList = Arrays.asList(Paypal.builder()
                        .firstName("Priya")
                        .lastName("Giri")
                        .emailAddress("giripriya@gmail.com")
                        .balance(8000.0)
                        .secureKey("1111")
                        .build(),
                Paypal.builder()
                        .firstName("Su")
                        .lastName("Yandar")
                        .emailAddress("yandarsu@gmail.com")
                        .balance(7000.0)
                        .secureKey("2222")
                        .build(),
                Paypal.builder()
                        .firstName("Samuel")
                        .lastName("Valiente")
                        .emailAddress("valientesaluel@gmail.com")
                        .balance(3000.0)
                        .secureKey("3333")
                        .build(),
                Paypal.builder()
                        .firstName("Byambadorj")
                        .lastName("Batsukh")
                        .emailAddress("batsukhbyambadorj@gmail.com")
                        .balance(4000.0)
                        .secureKey("4444")
                        .build(),
                Paypal.builder()
                        .firstName("Sopheary")
                        .lastName("Rin")
                        .emailAddress("rinsopheary@gmail.com")
                        .balance(8000.0)
                        .secureKey("5555")
                        .build()
                , Paypal.builder()
                        .firstName("Godwin")
                        .lastName("Tuslme")
                        .emailAddress("tuslmegodwin@gmail.com")
                        .balance(5044.0)
                        .secureKey("6666")
                        .build(),
                Paypal.builder()
                        .firstName("Khosbayar")
                        .lastName("Sandag")
                        .emailAddress("sandagkhosbayar@gmail.com")
                        .balance(8000.0)
                        .secureKey("7777")
                        .build());
        paypalRepo.saveAll(paypalList);
        System.out.println("All paypal account has been saved");
    }
}
