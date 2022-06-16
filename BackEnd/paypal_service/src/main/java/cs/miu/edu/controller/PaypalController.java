package cs.miu.edu.controller;


import cs.miu.edu.domain.Paypal;

import cs.miu.edu.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/paypals")
public class PaypalController {


    private  final PaypalService paypalService;

    public PaypalController(PaypalService paypalService){
        this.paypalService=paypalService;
    }



    @PostMapping
    public Paypal savePaypal(@RequestBody Paypal paypal, HttpServletRequest httpServletRequest) {
        return paypalService.savePaypal(paypal, httpServletRequest);
    }

    @GetMapping("/{paypalId}")
    public Paypal findPaypalById(@PathVariable String paypalId) {
        return paypalService.paypalById(paypalId);
    }

    @PutMapping("/{paypalId}")
    public Paypal updatePaypal(@PathVariable String paypalId, @RequestBody Paypal paypal) {
        return paypalService.updatePaypal(paypal,paypalId);
    }
}