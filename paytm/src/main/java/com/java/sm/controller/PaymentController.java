package com.java.sm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentService")
public class PaymentController {

	@GetMapping("/amazonPay")
	public String paymentProcessAmazonPay() {
		return "Payment service called Amazon Pay....";
	}

	@GetMapping("/payTM")
	public String paymentProcessPayTM() {
		return "Payment service called Pay TM....";
	}

}
