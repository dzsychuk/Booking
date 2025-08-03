package com.solvdinc.booking.model;

public class Booking {

	private int guestId;
	private int propertyId;
	private String checkInDate;
	private String checkOutDate;

	public Booking() {
	}
	
	public Booking(int propertyId, int guestId, String checkInDate, String checkOutDate) {
		this.propertyId = propertyId;
		this.guestId = guestId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "Booking for property " + propertyId + " by guest " + guestId + " from " + checkInDate + " till "
				+ checkOutDate;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
