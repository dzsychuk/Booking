package com.solvdinc.booking.model;

import java.util.List;

import com.solvdinc.booking.exceptions.UserNotFoundException;
import com.solvdinc.booking.util.Identifiable;

// interfaces are not using atm, tbd

public abstract class User implements Identifiable {
	public int id;
	public String name;
	public String email;
	public String password;

	public abstract void displayRole();

	public abstract void displayRating();

	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static User findUserById(List<User> users, int id) throws UserNotFoundException {
		return users.stream().filter(u -> u.getId() == id).findFirst()
				.orElseThrow(() -> UserNotFoundException.fromUserId(String.valueOf(id)));
	}

	/*
	 * public static User findUserById(User[] users, int id) throws
	 * UserNotFoundException { for (User u : users) { if (u.getId() == id) { return
	 * u; } } throw UserNotFoundException.fromUserId(String.valueOf(id)); }
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		User user = (User) obj;
		return id == user.id && email.equals(user.email);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
	}

	@Override
	public int hashCode() {
		return id * 31 + email.hashCode();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
