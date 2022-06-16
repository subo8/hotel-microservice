package cs.miu.edu.service;

import cs.miu.edu.domain.Paypal;

import cs.miu.edu.repository.PaypalRepo;
import cs.miu.edu.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;



@Service
public class PaypalService {
    @Autowired
    private  final PaypalRepo paypalRepo;

    @Autowired
    JwtUtils jwtUtils;

  public PaypalService(PaypalRepo paypalRepo){
      this.paypalRepo=paypalRepo;
  }




    public Paypal savePaypal(Paypal paypal, HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "subo8");
        if (cookie != null) {
            String jwt = cookie.getValue();
            String username = jwtUtils.getUserNameFromJwtToken(jwt);
            paypal.setUserName(username);
            return paypalRepo.save(paypal);
        }
        return null;

    }
    public List<Paypal> getPaypals(){
        return  paypalRepo.findAll();
    }


    public Paypal paypalById(String paypalId) {
        return  paypalRepo.findById(paypalId).get();
    }

    public Paypal updatePaypal(Paypal paypal,String paypalId) {
        Paypal paypal1= paypalById(paypalId);
        if(paypal.getBalance()!=null);
        paypal1.setBalance(paypal.getBalance());
        return paypalRepo.save(paypal1);
    }
}
