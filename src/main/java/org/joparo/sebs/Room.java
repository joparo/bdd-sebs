package org.joparo.sebs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private long id;

    private final String name;

    List<Booking> bookings = new ArrayList<>();

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Room(@JsonProperty("name") String name) {
        this.name = name;
    }

    public Booking book(Booking booking) {
        if(bookings.stream().anyMatch(booking::collidesWith)) {
            throw new IllegalArgumentException("Booking overlaps existing booking");
        }
        bookings.add(booking);
        return booking;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
