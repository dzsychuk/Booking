package com.solvdinc.booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.solvdinc.booking.exceptions.*;
import com.solvdinc.booking.model.*;
import com.solvdinc.booking.util.*;

public class App {
    public static void main(String[] args) {
        try {
            List<Property> properties = new ArrayList<>();
            properties.add(new Property(1, "Luxury kawalerka", "Wynajmę mieszkanie", PropertyType.APARTMENT, 3,
                    new Address("Poland", "Warsaw", "Ul. Światowida", "63", "10-101"), new Price(3600.01, "PLN")));
            properties.add(new Property(2, "Komfortowe mieszkanie", "Czuję się jak w domu", PropertyType.HOUSE, 1,
                    new Address("Poland", "Warsaw", "Stary Bielany", "9", "10-102"), new Price(3800, "PLN")));
            properties.add(new Property(3, "Ciężki Lux", "Droga i bogata", PropertyType.ROOM, 2,
                    new Address("Poland", "Warsaw", "Pl. Unii Lubelskiej", "7", "10-303"), new Price(5999.99, "PLN")));

            Guest guest = new Guest(1, "Dima Sychuk", "dseachouk@solvd.com", "pass1234!");
            String targetDate = "2025-06-25";
            guest.setUserRating(4);
            guest.displayRating();
            System.out.println("\nGuest contact email: " + guest.getEmail());

            Search search = new Search(3000, 3900, "Warsaw", 1, PropertyType.APARTMENT);
            search.setFromDate(LocalDate.of(2025, 6, 25));
            search.setToDate(LocalDate.of(2025, 6, 28));

            List<Property> available = Property.searchProperties(properties, search, targetDate);

            System.out.println("\nSearching results for date " + targetDate + ":");
            available.forEach(System.out::println);

            if (!available.isEmpty()) {
                Property selected = available.get(0);
                try {
                    Booking booking = guest.book(selected, targetDate);
                    System.out.println("\nBooking successful: " + booking);

                    Review review = guest.leaveReview(selected, "Everything is good", 5);
                    System.out.println("\nReview submitted: " + review);

                } catch (PropertyNotAvailableException e) {
                    System.err.println("Booking failed: " + e.getMessage());
                }
            }

            Pricable pricable = (Pricable) properties.get(0);
            double base = pricable.getPrice();
            double taxed = new Price(base, "PLN").getTotalWithTax();
            System.out.println("\nPrice: " + base);
            System.out.println("Price + VAT: " + taxed);

            Payment payment = new Payment(taxed, "PLN", PaymentMethod.CREDIT_CARD);
            payment.processPayment();

            System.out.println("\nFinal state of all properties:");
            properties.forEach(System.out::println);

        } catch (InvalidDateRangeException e) {
            System.err.println("Invalid date range: " + e.getMessage());
        } catch (BookingException e) {
            System.err.println("Booking error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static User findUserById(List<User> users, int id) throws UserNotFoundException {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> UserNotFoundException.fromUserId(String.valueOf(id)));
    }
}

/*
 * public class App { public static void main(String[] args) throws
 * BookingConflictException { try { Property p1 = new Property(1,
 * "Luxury kawalerka", "Wynajmę mieszkanie", "apartment", 3, new
 * Address("Poland", "Warsaw", "Ul. Światowida", "63", "10-101"), new
 * Price(3600.01, "PLN"), false); Property p2 = new Property(2,
 * "Komfortowe mieszkanie", "Czuję się jak w domu", "house", 1, new
 * Address("Poland ", "Warsaw", "Stary Bielany", "9", "10-102"), new Price(3800,
 * "PLN"), false); Property p3 = new Property(3, "Ciężki Lux", "Droga i bogata",
 * "room", 2, new Address("Poland", "Warsaw", "7", "Pl. Unii Lubelskiej",
 * "10-303"), new Price(5999.99, "PLN"), false);
 * 
 * Property[] properties = { p1, p2, p3 };
 * 
 * Guest guest = new Guest(1, "Dima Sychuk", "dseachouk@solvd.com",
 * "pass1234!"); String targetDate = "2025-06-25"; guest.setUserRating(4);
 * guest.displayRating(); System.out.println("\n" + "Guest contact email: " +
 * guest.getEmail());
 * 
 * Search search = new Search(3000, 3900, "Warsaw", 1, PropertyType.APARTMENT);
 * search.setFromDate(LocalDate.of(2025, 6, 25));
 * search.setToDate(LocalDate.of(2025, 6, 28)); Property[] available =
 * Property.searchProperties(properties, search, targetDate);
 * 
 * System.out.println("\n" + "Searching results for date " + targetDate + ":");
 * for (Property p : available) { System.out.println(p); }
 * 
 * if (available.length > 0) { Property selected = available[0];
 * 
 * try { Booking booking = guest.book(selected, targetDate);
 * System.out.println("\n" + "Booking successful: " + booking);
 * 
 * Review review = guest.leaveReview(selected, "Everything is good", 5);
 * System.out.println("\n" + "Review submitted: " + review); } catch
 * (PropertyNotAvailableException e) { System.err.println("Booking failed: " +
 * e.getMessage()); }
 * 
 * }
 * 
 * Pricable pricable = (Pricable) p1; double base = pricable.getPrice(); double
 * taxed = new Price(base, "PLN").getTotalWithTax();
 * 
 * System.out.println("\n" + "Price: " + base);
 * System.out.println("Price + VAT: " + taxed);
 * 
 * Payment payment = new Payment(taxed, "PLN", PaymentMethod.CREDIT_CARD);
 * payment.processPayment();
 * 
 * System.out.println("\n" + "Final state of all properties:"); for (Property p
 * : properties) { System.out.println(p); }
 * 
 * } catch (InvalidDateRangeException e) {
 * System.err.println("Invalid date range: " + e.getMessage());
 * 
 * } catch (BookingException e) { System.err.println("Booking error: " +
 * e.getMessage());
 * 
 * } catch (Exception e) { System.err.println("Unexpected error: " +
 * e.getMessage()); e.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * public static User findUserById(User[] users, int id) throws
 * UserNotFoundException { for (User user : users) { if (user.getId() == id) {
 * return user; } } throw UserNotFoundException.fromUserId(String.valueOf(id));
 * }
 * 
 * }
 */
