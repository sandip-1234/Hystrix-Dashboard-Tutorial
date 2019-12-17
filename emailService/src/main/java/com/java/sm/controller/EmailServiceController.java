package com.java.sm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Sandeep Matolia
 *
 */
@RestController
@RequestMapping("/emailService")
public class EmailServiceController {

	@GetMapping("/sendEmail")
	public String sendEmail() {
		return "Email service called....";
	}
}
