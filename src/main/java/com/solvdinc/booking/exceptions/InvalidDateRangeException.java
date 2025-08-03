package com.solvdinc.booking.exceptions;

import java.time.LocalDate;

public class InvalidDateRangeException extends BookingException {
	private static final long serialVersionUID = 3L;

	public InvalidDateRangeException(String message) {
		super(message);
	}

	public static InvalidDateRangeException from(LocalDate start, LocalDate end) {
		String msg = "Invalid date range: start date " + start + " is after end date " + end;
		return new InvalidDateRangeException(msg);
	}
}