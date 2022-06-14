package cs.miu.edu;

import cs.miu.edu.domain.AccountType;
import cs.miu.edu.domain.BankAccount;


import cs.miu.edu.repository.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableDiscoveryClient
public class BankAccountServiceApplication implements CommandLineRunner {
    @Autowired
    private BankAccountRepo bankAccountRepo;

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        loadBankAcountData();
    }

    public void loadBankAcountData(){
        List<BankAccount> bankAccounts=Arrays.asList(BankAccount.builder()
                        .routingNumber(1111)
                        .firstName("Priya")
                        .lastName("Giri")
                        .balance(4000.0)
                        .accountNumber("11111111")
                        .type(AccountType.CHECKING)
                        .emailAddress("giripriya@gmail.com")
                        .build(),
                BankAccount.builder()
                        .routingNumber(2222)
                        .firstName("Su")
                        .lastName("Yandar")
                        .balance(4000.0)
                        .type(AccountType.SAVING)
                        .accountNumber("22222222")
                        .emailAddress("yandarsu@gmail.com")
                        .build(),
                BankAccount.builder()
                        .routingNumber(3333)
                        .firstName("Samuel")
                        .lastName("Valiente")
                        .balance(4000.0)
                        .type(AccountType.SAVING)
                        .accountNumber("33333333")
                        .emailAddress("valientesaluel@gmail.com")
                        .build(),
                BankAccount.builder()
                        .routingNumber(4444)
                        .firstName("Byambadorj")
                        .lastName("Batsukh")
                        .balance(4000.0)
                        .type(AccountType.CHECKING)
                        .accountNumber("44444444")
                        .emailAddress("batsukhbyambadorj@gmail.com")
                        .build(),
                BankAccount.builder()
                        .routingNumber(5555)
                        .firstName("Sopheary")
                        .lastName("Rin")
                        .balance(4000.0)
                        .type(AccountType.SAVING)
                        .accountNumber("55555555")
                        .emailAddress("rinsopheary@gmail.com")
                        .build(),
                BankAccount.builder()
                        .routingNumber(6666)
                        .firstName("Godwin")
                        .lastName("Tuslme")
                        .balance(4000.0)
                        .type(AccountType.CHECKING)
                        .accountNumber("66666666")
                        .emailAddress("tuslmegodwin@gmail.com")
                        .build(),
                BankAccount.builder()
                        .routingNumber(7777)
                        .firstName("Khosbayar")
                        .lastName("Sandag")
                        .balance(4000.0)
                        .type(AccountType.CHECKING)
                        .accountNumber("77777777")
                        .emailAddress("sandagkhosbayar@gmail.com")
                        .build());
        bankAccountRepo.saveAll(bankAccounts);
        System.out.println("All bank account has been saved");

    }
}
