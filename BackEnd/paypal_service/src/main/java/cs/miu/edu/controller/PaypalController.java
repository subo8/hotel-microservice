package cs.miu.edu.controller;

import cs.miu.edu.domain.Paypal;
import cs.miu.edu.dto.PaypalDto;
import cs.miu.edu.security.jwt.JwtUtils;
import cs.miu.edu.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/paypals")
public class PaypalController {

    @Autowired
    private PaypalService paypalService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity<?> savePaypal(@RequestBody PaypalDto paypalDto){
        ResponseEntity<?> response= new ResponseEntity<>(paypalService.savePaypal(paypalDto), HttpStatus.OK);
        return response;
    }

    @PutMapping("/gets")
    public ResponseEntity<?> getRequest(HttpServletRequest request, @RequestParam(value = "balance") Double balance ) {
        String jwt = jwtUtils.getJwtFromCookies(request);
        String userName = jwtUtils.getUserNameFromJwtToken(jwt);
        String userId = jwtUtils.getUserIdFromJwtToken(jwt);
        String userRole = jwtUtils.getUserRoleFromJwtToken(jwt);
        System.out.println(userName);
        System.out.println(userId);
        System.out.println(userRole);
//        return new ResponseEntity<>("Ok", HttpStatus.OK);
        ResponseEntity<?> response= new ResponseEntity<>(paypalService.verifyStatus(userName,balance),HttpStatus.OK);

        return response;
    }

    @PutMapping("verify-purchase")
    public ResponseEntity<?> verifyPurchase(@RequestBody PaypalDto paypalDto){
        ResponseEntity<?> response= new ResponseEntity<>(paypalService.verifyPurchase(paypalDto), HttpStatus.OK);
        return response;
    }


}
