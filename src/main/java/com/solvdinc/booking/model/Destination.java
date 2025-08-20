	package com.solvdinc.booking.model;

	// TBD - not using atm

	public class Destination {

		private int id;
		private String title;
		private Address address;
		private DestinationType type;

		public Destination() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public DestinationType getType() {
			return type;
		}

		public void setType(DestinationType type) {
			this.type = type;
		}

	}
