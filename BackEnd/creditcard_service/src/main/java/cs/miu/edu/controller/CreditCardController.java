package cs.miu.edu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.miu.edu.domain.CreditCard;
import cs.miu.edu.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }



@PostMapping
@CrossOrigin("http://localhost:3000")
public  CreditCard saveCreditCard(@RequestBody CreditCard creditCard , HttpServletRequest httpServletRequest){
    return creditCardService.saveCreditCard(creditCard, httpServletRequest);
}

@GetMapping("/{creditCardId}")
@CrossOrigin("http://localhost:3000")
    public   CreditCard findCardById(@PathVariable String creditCardId){
        return  creditCardService.getCreditCards(creditCardId);
}
@GetMapping
@CrossOrigin("http://localhost:3000")
    public List<CreditCard> getCreditCards(){
        return creditCardService.getCreditCards();
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
