package cs.miu.edu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.miu.edu.domain.BankAccount;
import cs.miu.edu.dto.BankAccountDto;
import cs.miu.edu.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/bankaccounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }



    @PostMapping
    public BankAccount saveCreditCard(@RequestBody BankAccount bankAccount , HttpServletRequest httpServletRequest){
        return bankAccountService.saveBankAccount(bankAccount, httpServletRequest);
    }

    @GetMapping("/{creditCardId}")
    public   BankAccount findCardById(@PathVariable String creditCardId){
        return  bankAccountService.getBankAccountById(creditCardId);
    }

    @PutMapping("/{bankAccountId}")
    public   BankAccount updateCreditCard(@PathVariable String bankAccountId, @RequestBody BankAccount bankAccount){
        return  bankAccountService.updateBankAccount(bankAccount,bankAccountId);
    }

//    @PutMapping("/")
//    public BankAccount updateCreditCard(@RequestBody String BankAccountId) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        BankAccount room1 = new BankAccount();
//        try {
//            room1 = objectMapper.readValue(creditCard, BankAccount.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return creditCardService.updateCreditCard(room1);
//
//    }


}
