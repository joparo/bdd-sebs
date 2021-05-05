package org.joparo.sebs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class Repository {

    private final List<Room> rooms = new ArrayList<>();

    private long roomIdCounter =0;
    private long bookingIdCounter=0;

    public Room save(Room room) {
        room.setId(roomIdCounter++);
        rooms.add(room);
        return room;
    }

    public Room findRoom(long id) {
        return rooms.stream().filter(r -> r.getId() == id).findAny().orElseThrow(NoSuchElementException::new);
    }

    public List<Room> findAll() {
        return rooms;
    }

    public Booking save(Booking booking) {
        booking.setBookingId(bookingIdCounter++);
        return booking;
    }
}
