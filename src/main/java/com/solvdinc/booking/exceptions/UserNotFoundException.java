package com.solvdinc.booking.exceptions;

public class UserNotFoundException extends BookingException {
	private static final long serialVersionUID = 4L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public static UserNotFoundException fromUserId(String userId) {
		return new UserNotFoundException("User with ID '" + userId + "' was not found.");
	}
}
