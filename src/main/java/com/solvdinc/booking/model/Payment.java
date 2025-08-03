package com.solvdinc.booking.model;

public final class Payment {

	private double amount;
	private String currency;
	private PaymentMethod paymentMethod;
	private boolean successful;

	public Payment(double amount, String currency, PaymentMethod paymentMethod) {
		this.amount = amount;
		this.currency = currency;
		this.paymentMethod = paymentMethod;
	}

	public boolean processPayment() {
		this.successful = true;
		System.out.println("Processing payment of " + amount + " " + currency + " via " + paymentMethod);
		return successful;
	}

	public boolean isSuccessful() {
		return successful;
	}

	@Override
	public String toString() {
		return "Payment: " + amount + " " + currency + " via " + paymentMethod + (successful ? " succeeded" : " failed");
	}
}
