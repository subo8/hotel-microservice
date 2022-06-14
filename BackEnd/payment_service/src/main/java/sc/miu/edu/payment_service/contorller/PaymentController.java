package sc.miu.edu.payment_service.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.miu.edu.payment_service.domain.PaymentInformation;
import sc.miu.edu.payment_service.dto.BankAccountDto;
import sc.miu.edu.payment_service.dto.CreditCardDto;
import sc.miu.edu.payment_service.dto.PaypalDto;
import sc.miu.edu.payment_service.repository.PaymentRepo;
import sc.miu.edu.payment_service.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/payments")
@EnableAutoConfiguration(exclude= DataSourceAutoConfiguration.class)

public class PaymentController {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/paypal")
    public ResponseEntity<?> savePaymentPaypal(@RequestBody PaypalDto paypalDto){
        ResponseEntity<?> response= new ResponseEntity<>(paymentService.verifyPaypalAndSavePayment(paypalDto), HttpStatus.OK);
        return  response;
    }

    @PostMapping("/creditcard")
    public ResponseEntity<?> savePaymentCreditCard(@RequestBody CreditCardDto creditCardDto){
        ResponseEntity<?> response= new ResponseEntity<>(paymentService.verifyCreditCardAndSavePayment(creditCardDto), HttpStatus.OK);
        return  response;
    }
    @PostMapping("/bankaccount")
    public ResponseEntity<?> savePaymentBankAccount(@RequestBody BankAccountDto bankAccountDto){
        ResponseEntity<?> response= new ResponseEntity<>(paymentService.verifyBankAccountAndSavePayment(bankAccountDto), HttpStatus.OK);
        return  response;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllPaymentInformation(){
        ResponseEntity<?> response= new ResponseEntity<>(paymentService.deleteAlldata(),HttpStatus.OK);
        return response;
    }


    @GetMapping
    public List<PaymentInformation> getPaymentInformation(){

        return paymentRepo.findAll();
    }

    @GetMapping("/{transactionCode}")
    public ResponseEntity<?> getPaymentInformatinFromTransactioncode(@PathVariable(value = "transactionCode") String transactionCode){
        ResponseEntity<?> response= new ResponseEntity<>(paymentService.getPaymentInformationByTransactionCode(transactionCode),HttpStatus.OK);
        return response;
    }
    @GetMapping("/latestPayment")
    public ResponseEntity<?> getLatestPaymentInformation(){
        ResponseEntity<?> response = new ResponseEntity<>(paymentRepo.findTopByOrderByTransactionDateDesc(),HttpStatus.OK);
        return response;
    }
}
