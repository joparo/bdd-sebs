package org.joparo.sebs;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms/{id}/bookings")
public class BookingController {

    private Repository repository;

    public BookingController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Booking> findBookingsForRoom(@PathVariable long id) {
        return this.repository.findRoom(id).bookings;
    }

    @PostMapping
    public Booking createBooking(@PathVariable long id, @RequestBody Booking booking) {
        this.repository.findRoom(id).book(booking);
        return this.repository.save(booking);
    }

}
