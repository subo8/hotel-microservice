package cs.miu.edu;

import cs.miu.edu.domain.CreditCard;
import cs.miu.edu.repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableDiscoveryClient
public class CreditcardServiceApplication implements CommandLineRunner {
    @Autowired
    private CreditCardRepo creditCardRepo;

    public static void main(String[] args) {
        SpringApplication.run(CreditcardServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        loadCreditCard();
    }

    public void loadCreditCard() {
        List<CreditCard> creditCards = Arrays.asList(CreditCard.builder()
                        .firstName("Priya")
                        .lastName("Giri")
                        .cardNumber("11111111")
                        .ccv("1111")
                        .balance(4000.0)
                        .expiryDate(LocalDate.of(2024, 04, 04)
                        ).build(),
                CreditCard.builder()
                        .firstName("Su")
                        .lastName("Yandar")
                        .cardNumber("22222222")
                        .ccv("2222")
                        .balance(4000.0)
                        .expiryDate(LocalDate.of(2024, 04, 04)
                        ).build(),
                CreditCard.builder()
                        .firstName("Samuel")
                        .lastName("Valiente")
                        .cardNumber("33333333")
                        .ccv("3333")
                        .balance(4000.0)
                        .expiryDate(LocalDate.of(2024, 04, 04)
                        ).build(),
                CreditCard.builder()
                        .firstName("Byambadorj")
                        .lastName("Batsukh")
                        .cardNumber("44444444")
                        .ccv("4444")
                        .balance(4000.0)
                        .expiryDate(LocalDate.of(2024, 04, 04)
                        ).build(),
                CreditCard.builder()
                        .firstName("Sopheary")
                        .lastName("Rin")
                        .cardNumber("55555555")
                        .ccv("5555")
                        .balance(4000.0)
                        .expiryDate(LocalDate.of(2024, 04, 04)
                        ).build(),
                CreditCard.builder()
                        .firstName("Godwin")
                        .lastName("Tuslme")
                        .cardNumber("66666666")
                        .ccv("6666")
                        .balance(4000.0)
                        .expiryDate(LocalDate.of(2024, 04, 04)
                        ).build(),
                CreditCard.builder()
                        .firstName("Khosbayar")
                        .lastName("Sandag")
                        .cardNumber("77777777")
                        .ccv("7777")
                        .balance(4000.0)
                        .expiryDate(LocalDate.of(2024, 04, 04)
                        ).build());
        creditCardRepo.saveAll(creditCards);
        System.out.println(creditCardRepo.findAll());
        System.out.println("All creditcard account has been saved");

    }
}
