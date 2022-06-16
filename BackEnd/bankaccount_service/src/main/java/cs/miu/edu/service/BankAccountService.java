package cs.miu.edu.service;

import cs.miu.edu.domain.BankAccount;


import cs.miu.edu.repository.BankAccountRepo;
import cs.miu.edu.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;


@Service
public class BankAccountService {



    private final BankAccountRepo bankAccountRepo;

    @Autowired
    JwtUtils jwtUtils;



    public BankAccountService(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }



    public BankAccount saveBankAccount(BankAccount bankAccount, HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "subo8");
        if (cookie != null) {
            String jwt = cookie.getValue();
            String username = jwtUtils.getUserNameFromJwtToken(jwt);
            bankAccount.setUserName(username);
            return bankAccountRepo.save(bankAccount);
        }
        return null;
    }

    public List<BankAccount> getCreditCards(){
        return  bankAccountRepo.findAll();
    }
    public BankAccount getBankAccountById(String creditCardId) {
        return bankAccountRepo.findById(creditCardId).get();
    }

    public BankAccount updateBankAccount(BankAccount bankAccount,String bankAccountId) {
      BankAccount bankAccount1= getBankAccountById(bankAccountId);
      if(bankAccount.getBalance() != null){
          bankAccount1.setBalance(bankAccount.getBalance());
      }
      return bankAccountRepo.save(bankAccount);
    }
}
