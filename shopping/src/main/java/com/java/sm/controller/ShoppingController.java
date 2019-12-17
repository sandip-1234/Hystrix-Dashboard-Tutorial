package com.java.sm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author Sandeep Matolia
 *
 */
@RestController
public class ShoppingController {

	private static final Logger log = LoggerFactory.getLogger(ShoppingController.class);
	@Autowired
	private RestTemplate template;

	@HystrixCommand(groupKey = "Book Now", commandKey = "Book Now", fallbackMethod = "shoppingFallBack")
	@GetMapping("/shopPayTM")
	public String shopPayTM() {
		String emailServiceResponse = template.getForObject("http://localhost:8181/emailService/sendEmail", String.class);
		String paymentServiceResponse = template.getForObject("http://localhost:8282/paymentService/payTM", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	@GetMapping("/shopWithoutHystrix")
	public String shopWithoutHystrix() {
		String emailServiceResponse = template.getForObject("http://localhost:8181/emailService/sendEmail", String.class);
		String paymentServiceResponse = template.getForObject("http://localhost:8282/paymentService/payTM", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	@HystrixCommand(groupKey = "Amazon Pay", commandKey = "Amazon Pay", fallbackMethod = "shoppingFallBack")
	@GetMapping("/shopAmazonPay")
	public String shopAmazonPay() {
		String emailServiceResponse = template.getForObject("http://localhost:8181/emailService/sendEmail", String.class);
		String paymentServiceResponse = template.getForObject("http://localhost:8282/paymentService/payTM", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	public String shoppingFallBack() {
		log.info("Fall Back Method invoked");
		return "service gateway failed...";
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
