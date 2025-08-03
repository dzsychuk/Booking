package com.solvdinc.booking.model;

import com.solvdinc.booking.exceptions.PropertyNotAvailableException;
import com.solvdinc.booking.util.Reviewable;

public class Guest extends User implements Reviewable {
	
	public Guest(int id, String name, String email, String password) {
		super(id, name, email, password);
	}

	
	
	public int guestRating;

	public final String getRole() {
		return "Guest";
	}

	public Booking book(Property property, String date) throws PropertyNotAvailableException {
		if (!property.isAvailable(date)) {
			throw new PropertyNotAvailableException("Property not available on " + date);
		}
		Booking booking = new Booking(property.getId(), this.getId(), date, date);
		property.setBooking(booking);
		return booking;
	}

	public Review leaveReview(Property property, String text, int rating) {
		Review review = new Review(property.getId(), this.getId(), text, rating, "");
		property.setReview(review);
		return review;
	}

	@Override
	public void displayRole() {
		System.out.println("I am a Guest");
	}

	@Override
	public String toString() {
		return "Guest{" + super.toString() + "}";
	}

	@Override
	public void displayRating() {
		System.out.println("Guest " + this.getName() + " has rating: " + guestRating + "/5");
	}

	public int getGuestRating() {
		return guestRating;
	}

	public void setUserRating(int guestRating) {
		this.guestRating = guestRating;
	}

}
