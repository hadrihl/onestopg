package com.example.onestopg.entity;

public class CreditCardProcessor implements PaymentProcessor {

	@Override
	public boolean process() {
		// Process Credit Card payment
		return true;
	}

}
