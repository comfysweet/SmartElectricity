package com.payment.controller;


import com.payment.domain.PaymentInformation;
import com.payment.domain.PaymentResult;
import com.payment.domain.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/mockPayment")
    public @ResponseBody
    PaymentResult getMockPaymentResult() {
        return paymentService.getMockPaymentResult();
    }


}
