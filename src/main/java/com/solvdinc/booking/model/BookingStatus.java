package com.solvdinc.booking.model;

public enum BookingStatus {

				PENDING, CONFIRMED, CANCELLED, COMPLETED;

	public String nextStep() {
		switch (this) {
		case PENDING:
			return "Await confirmation";
		case CONFIRMED:
			return "Await check-in";
		case CANCELLED:
			return "No action";
		case COMPLETED:
			return "Leave a review";
		default:
			throw new IllegalStateException(this.name());
		}
	}
}
