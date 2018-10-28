package com.payment.controller;


import com.payment.domain.PaymentInformation;
import com.payment.domain.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public @ResponseBody
    PaymentInformation getCost(@RequestParam("paymentPeriod") String paymentPeriod) {
        return paymentService.getPaymentInformation(paymentPeriod);
    }

}
