package com.solvdinc.booking.model;

public class Review {

	private int id;
	private int propertyId;
	private int guestId;
	private int propertyRating;
	private String text;
	private String date;

	public Review() {
	}
	
	public Review(int propertyId, int guestId, String text, int propertyRating, String date) {
		this.propertyId = propertyId;
		this.guestId = guestId;
		this.text = text;
		this.propertyRating = propertyRating;
		this.date = date;
	}

	public String toString() {
		return text + " (" + propertyRating + "/5)";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPropertyRating() {
		return propertyRating;
	}

	public void setPropertyRating(int propertyRating) {
		this.propertyRating = propertyRating;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
