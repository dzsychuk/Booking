package com.solvdinc.booking.util;

import com.solvdinc.booking.model.Booking;

public interface Bookable {
	boolean isAvailable(String date);

	void setBooking(Booking booking);
}
