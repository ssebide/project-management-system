package com.ssebide.response;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssebide.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentLinkResponse {

    private String payment_link_url;
    private String payment_link_id;

    @Autowired
    private UserService userService;

    
}
