package cs.miu.edu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.miu.edu.domain.CreditCard;
import cs.miu.edu.jwt.JwtUtils;
import cs.miu.edu.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

    @Autowired
    JwtUtils jwtUtils;

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }



@PostMapping
public  CreditCard saveCreditCard(@RequestBody CreditCard creditCard , HttpServletRequest request){

    Cookie cookie = WebUtils.getCookie(request, "subo8");
    if (cookie != null) {
        String jwt = cookie.getValue();
        String username = jwtUtils.getUserNameFromJwtToken(jwt);
        return creditCardService.saveCreditCard(creditCard, username);

    }
    return null;

}

@GetMapping("/{creditCardId}")
    public   CreditCard findCardById(@PathVariable String creditCardId){
        return  creditCardService.getCreditCards(creditCardId);
}

    @PutMapping("/{creditCardId}")
    public   CreditCard updateCreditCard(@PathVariable String creditCardId, @RequestBody CreditCard creditCard){
        return  creditCardService.updateCreditCard(creditCard);
    }

    @PutMapping("/")
    public CreditCard updateCreditCard(@RequestBody String creditCard) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        CreditCard room1 = new CreditCard();
        try {
            room1 = objectMapper.readValue(creditCard, CreditCard.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return creditCardService.updateCreditCard(room1);

    }

//@PostMapping("/verify-purchase")
//public ResponseEntity<?> check(@RequestBody CreditCardDto creditCardDto) {
//    ResponseStatus responseStatus =new ResponseStatus(creditCardService.verifyPurchase(creditCardDto));
//    ResponseEntity<?> response = new ResponseEntity<>(responseStatus, HttpStatus.OK);
//
//    return response;
//}


}
