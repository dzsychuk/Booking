package com.solvdinc.booking.model;

public final class Address {

	private int id;
	private String country;
	private String city;
	private String street;
	private String houseNumber;
	private String postalCode;

	public Address() {
	}

	public Address(String country, String city, String street, String houseNumber, String postalCode) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return id == other.id && (country != null && country.equals(other.country))
				&& (city != null && city.equals(other.city)) && (street != null && street.equals(other.street))
				&& (houseNumber != null && houseNumber.equals(other.houseNumber))
				&& (postalCode != null && postalCode.equals(other.postalCode));
	}

	@Override
	public String toString() {
		return street + " " + houseNumber + ", " + postalCode + ", " + city + ", " + country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
