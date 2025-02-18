package com.ssebide.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.ssebide.modal.PlanType;
import com.ssebide.modal.User;
import com.ssebide.response.PaymentLinkResponse;
import com.ssebide.service.UserService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

    @Autowired
    private UserService userService;

    @PostMapping("/planType")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable PlanType planType, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        int amount = 799*100;
        if(planType.equals(PlanType.ANNUALLY)){
            amount= amount*12;
            amount=(int)(amount*0.7);
        }
        try {
            RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);

            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency", "INR");

            JSONObject customer = new JSONObject();
            customer.put("name", user.getFullName());
            customer.put("email", user.getEmail());
            paymentLinkResponse.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("email", true);
            paymentLinkResponse.put("notify", notify);

            paymentLinkResponse.put("callback_url", "http://localhost:5173/upgrade_plan/success?planType"+planType);

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkResponse);

            String paymentLinkId = payment.get("id");
            String paymentLinkUrl = payment.get("short_url");

            Payment
        } catch (Exception e) {
            
        }
    };

}
