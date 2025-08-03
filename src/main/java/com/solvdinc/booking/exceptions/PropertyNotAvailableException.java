package com.solvdinc.booking.exceptions;

import java.time.LocalDate;

public class PropertyNotAvailableException extends BookingException {
   
	private static final long serialVersionUID = 1L;

	public PropertyNotAvailableException(String message) {
        super(message);
    }

    public PropertyNotAvailableException(String propertyId, LocalDate start, LocalDate end) {
        super("Property " + propertyId + " is not available between " + start + " and " + end);
    }
}