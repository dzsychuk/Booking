package com.solvdinc.booking.util;

import com.solvdinc.booking.model.Property;
import com.solvdinc.booking.model.Review;

// represents an entity that can be reviewed

public interface Reviewable {

	Review leaveReview(Property property, String text, int rating);

 
}
