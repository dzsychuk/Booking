package com.solvdinc.booking.model;

import java.util.List;
import java.util.stream.Collectors;

import com.solvdinc.booking.exceptions.BookingException;
import com.solvdinc.booking.exceptions.InvalidDateRangeException;
import com.solvdinc.booking.util.Bookable;
import com.solvdinc.booking.util.Identifiable;
import com.solvdinc.booking.util.Locatable;
import com.solvdinc.booking.util.Pricable;

public class Property implements Bookable, Identifiable, Locatable, Pricable {
	private final int id;
	private String title;
	private String description;
	private Price price;
	private Address address;
	private Owner owner;
	private PropertyType type;
	private int maxGuests;
	private Booking booking;
	private Review review;
	private double rating;
	private boolean isBooked;

	public Property() {
		this.id = 0;
	}

	/*
	 * public Property(int id, String title, String description, String typeStr, int
	 * maxGuests, Address address, Price price, boolean isBooked) { this.id = id;
	 * this.title = title; this.description = description; this.type =
	 * PropertyType.valueOf(typeStr.toUpperCase()); this.maxGuests = maxGuests;
	 * this.address = address; this.price = price; this.isBooked = isBooked; }
	 */

	public Property(int id, String title, String description, PropertyType type, int maxGuests, Address address,
			Price price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.maxGuests = maxGuests;
		this.address = address;
		this.price = price;
		this.isBooked = false;
	}

	public boolean isAvailable(String date) {
		return !isBooked;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public static List<Property> searchProperties(List<Property> properties, Search search, String date)
			throws BookingException, InvalidDateRangeException {
		if (properties == null || search == null || date == null) {
			throw new BookingException("Search parameters cannot be null");
		}
		if (search.getMinPrice() > search.getMaxPrice()) {
			throw new BookingException("Minimum price cannot be higher than maximum price.");
		}
		if (search.getFromDate() != null && search.getToDate() != null
				&& search.getFromDate().isAfter(search.getToDate())) {
			throw InvalidDateRangeException.from(search.getFromDate(), search.getToDate());
		}

		return properties.stream().filter(p -> {
			double pr = p.getPrice();
			return pr >= search.getMinPrice() && pr <= search.getMaxPrice() && p.getAddress().contains(search.getCity())
					&& p.isAvailable(date);
		}).collect(Collectors.toList());
	}
	/*
	 * public static Property[] searchProperties(Property[] properties, Search
	 * search, String date) throws BookingException, InvalidDateRangeException {
	 * 
	 * if (properties == null || search == null || date == null) { throw new
	 * BookingException("Search parameters cannot be null"); }
	 * 
	 * if (search.getMinPrice() > search.getMaxPrice()) { throw new
	 * BookingException("Minimum price cannot be higher than maximum price."); }
	 * 
	 * if (search.getFromDate() != null && search.getToDate() != null &&
	 * search.getFromDate().isAfter(search.getToDate())) {
	 * 
	 * throw InvalidDateRangeException.from(search.getFromDate(),
	 * search.getToDate()); }
	 * 
	 * int count = 0; for (Property p : properties) { double price = p.getPrice();
	 * if (price >= search.getMinPrice() && price <= search.getMaxPrice() &&
	 * p.getAddress().contains(search.getCity()) && p.isAvailable(date)) { count++;
	 * } }
	 * 
	 * Property[] results = new Property[count]; int index = 0; for (Property p :
	 * properties) { double price = p.getPrice(); if (price >= search.getMinPrice()
	 * && price <= search.getMaxPrice() && p.getAddress().contains(search.getCity())
	 * && p.isAvailable(date)) { results[index++] = p; } } return results; }
	 */

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public double getPrice() {
		return this.price != null ? this.price.getAmount() : 0;
	}

	@Override
	public String getAddress() {
		return address != null ? address.toString() : "";
	}

	@Override
	public String toString() {
		return "Property ID: " + id + ", Title: " + title + ", Price: " + price + ", Address: " + address
				+ (booking != null ? "\n" + "Booked on: " + booking.getCheckInDate() : "")
				+ (review != null ? "\n" + "Review: " + review.getText() + " (" + review.getPropertyRating() + "/5)"
						: "");
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PropertyType getType() {
		return type;
	}

	public void setType(PropertyType type) {
		this.type = type;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

}
