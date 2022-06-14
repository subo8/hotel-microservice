package cs.miu.edu.controller;

import cs.miu.edu.dto.BankAccountDto;
import cs.miu.edu.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankaccounts")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;



    @PutMapping("/verify-purchase")
    public ResponseEntity<?> verifyPayment(@RequestBody BankAccountDto bankAccountDto) {
        ResponseEntity<?> response = new ResponseEntity<>(bankAccountService.verifyPurchase(bankAccountDto), HttpStatus.OK);
        return response;
    }



}
