package com.example.onestopg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.onestopg.entity.PaymentProcessor;
import com.example.onestopg.service.PaymentProcessorFactory;

@RestController
public class PaymentController {

	private final PaymentProcessorFactory paymentProcessorFactory = new PaymentProcessorFactory();
	
	@GetMapping("/payments/{mode}")
	public String processPayment(@PathVariable String mode) {
		PaymentProcessor paymentProcessor = paymentProcessorFactory.getPaymentProcessor(mode);
		
		if(paymentProcessor == null) {
			return "Invalid payment mode";
		}
		
		boolean success = paymentProcessor.process();
		
		if(success) {
			return "Payment processed successfully.";
		} else {
			return "Payment processing failed.";
		}
	}
}
