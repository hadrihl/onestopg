package com.example.onestopg.entity;

public class GooglePayProcessor implements PaymentProcessor {

	@Override
	public boolean process() {
		// Process Google Pay payment
		return true;
	}

}
