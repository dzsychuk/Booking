package com.solvdinc.booking.model;

public class Price {
	private double amount;
	private String currency;
	public static final double TAX_RATE = 0.08; // static usage tax rate

	public Price() {
	}
	
	public Price(double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public double getTotalWithTax() {
		return amount + (amount * TAX_RATE); // price with tax
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Price))
			return false;
		Price other = (Price) obj;
		return amount == other.amount && (currency != null && currency.equals(other.currency));
	}

	@Override
	public String toString() {
		return amount + " " + currency;
	}
}
