package com.solvdinc.booking.exceptions;

public class BookingConflictException extends BookingException {
	private static final long serialVersionUID = 2L;

	public BookingConflictException(String message) {
		super(message);
	}

	public static BookingConflictException fromBookingId(String bookingId) {
		return new BookingConflictException("Booking conflict detected with booking ID: " + bookingId);
	}
}
