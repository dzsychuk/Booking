package com.solvdinc.booking.model;

import java.time.LocalDate;

public class Search {

	private String city;
	private LocalDate fromDate;
	private LocalDate toDate;
	private int maxGuestsNumber;
	private double maxPrice;
	private double minPrice;
	private PropertyType propertyType;

	public Search() {
	}
	
	public Search(double minPrice, double maxPrice, String city, int maxGuestsNumber, PropertyType propertyType) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.maxGuestsNumber = maxGuestsNumber;
		this.setCity(city);
		this.propertyType = propertyType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMaxGuestsNumber() {
		return maxGuestsNumber;
	}

	public void setMaxGuestsNumber(int maxGuestsNumber) {
		this.maxGuestsNumber = maxGuestsNumber;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

}
