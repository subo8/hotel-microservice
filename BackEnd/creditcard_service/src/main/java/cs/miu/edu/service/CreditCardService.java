package cs.miu.edu.service;

import cs.miu.edu.domain.CreditCard;
import cs.miu.edu.jwt.JwtUtils;
import cs.miu.edu.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class CreditCardService {


  private final CreditCardRepository creditCardRepository;

    @Autowired
    JwtUtils jwtUtils;



    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }




    public  CreditCard saveCreditCard(CreditCard creditCard, HttpServletRequest request) {
     //   CreditCard booking1 = new CreditCard();
        Cookie cookie = WebUtils.getCookie(request, "subo8");
        if (cookie != null) {
            String jwt = cookie.getValue();
            String username = jwtUtils.getUserNameFromJwtToken(jwt);
            creditCard.setUserName(username);
            return creditCardRepository.save(creditCard);
        }
        return null;
    }

    public List<CreditCard> getCreditCards(){
        return  creditCardRepository.findAll();
    }
    public CreditCard getCreditCards(String creditCardId){
        return  creditCardRepository.findById(creditCardId).get();
    }

    public  CreditCard updateCreditCard(CreditCard creditCard){
//        creditCardRepository.findById(creditCardId);
//        creditCard.setCreditCardId(creditCardId);
        return  creditCardRepository.save(creditCard);
    }

// @Autowired
//    private CreditCardRepo creditCardRepo;

    }




