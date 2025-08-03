package com.solvdinc.booking.model;

class Owner extends User {
	public Owner(int id, String name, String email, String password) {
		super(id, name, email, password);
	}

	public String nipNumber;

	@Override
	public void displayRole() {
		System.out.println("I am an Owner");
	}

	@Override
	public String toString() {
		return "Owner{" + super.toString() + "}";
	}

	@Override
	public void displayRating() {

	}

	public String getNipNumber() {
		return nipNumber;
	}

	public void setNipNumber(String nipNumber) {
		this.nipNumber = nipNumber;
	}

}
