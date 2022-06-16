package cs.miu.edu.service;

import cs.miu.edu.domain.CreditCard;
//import cs.miu.edu.mapper.Mapper;
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

@Autowired
  private final CreditCardRepository creditCardRepository;


    @Autowired
    JwtUtils jwtUtils;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

//    public CreditCardService(CreditCardRepository creditCardRepository) {
//        this.creditCardRepository = creditCardRepository;
//    }

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


//
//    public CreditCardDto saveCreditCard(CreditCardDto creditCardDto) {
//       CreditCard creditCard= CreditCard.builder()
//               .balance(0.0)
//               .cardNumber("1234")
//               .ccv("123")
//               .firstName("Priya")
//               .lastName("giri").build();
//        creditCard.setExpiryDate(LocalDate.of(LocalDate.now().getYear()+1,LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
//        creditCard.setCardLimit(2000.0);
//        creditCardRepo.save(creditCard);
//        return creditCardDto;
//    }
//
//    public Status verifyPurchase(CreditCardDto creditCardDto) {
//       Optional<CreditCard> creditCard= creditCardRepo.getCreditCardByCardNoCardExpiryDateCcvCardLimit(creditCardDto.getCardNumber(), creditCardDto.getExpiryDate(), creditCardDto.getCcv());
//        if(creditCard.isEmpty()) {
//            System.out.println("Invalid card");
//            return Status.FAILURE;
//        }
//        LocalDate cardExpiryDate= creditCard.get().getExpiryDate();
//        LocalDate todayDate= LocalDate.now();
//        if(!cardExpiryDate.isAfter(todayDate)) {
//            System.out.println("Card has expired");
//            return  Status.FAILURE;
//        }
//        Double currentPurchaseBalalnce= creditCardDto.getBalance();
//         Double totalNewBalance=  currentPurchaseBalalnce+ creditCard.get().getBalance();
//         if(creditCard.get().getCardLimit() != null){
//             if(creditCard.get().getCardLimit()< totalNewBalance) {
//                 System.out.println("Limitation of card has been exceed");
//                 return  Status.FAILURE;
//             }
//         }
//
//         creditCard.get().setBalance(totalNewBalance);
//         creditCardRepo.save(creditCard.get());
//        return  Status.SUCCESS;
//
//    }



}
