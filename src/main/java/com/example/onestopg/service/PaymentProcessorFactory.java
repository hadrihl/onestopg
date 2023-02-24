package com.example.onestopg.service;

import com.example.onestopg.entity.CreditCardProcessor;
import com.example.onestopg.entity.GooglePayProcessor;
import com.example.onestopg.entity.PaymentProcessor;

public class PaymentProcessorFactory {
	
	private final GooglePayProcessor gpayProcessor = new GooglePayProcessor();
	private final CreditCardProcessor cardProcessor = new CreditCardProcessor();
	
	public PaymentProcessor getPaymentProcessor(String mode) {
		if("gpay".equalsIgnoreCase(mode)) {
			return gpayProcessor;
		} else if("credit_card".equalsIgnoreCase(mode)) {
			return cardProcessor;
		}
		
		return null;
	}
}
