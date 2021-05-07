package org.joparo.sebs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class StepDef extends SebsApplicationTests {

    private Room room1;

    @LocalServerPort
    private int serverPort;

    @Given("Room {int} is available between {int}:{int} and {int}:{int} tomorrow")
    public void roomIsAvailableBetweenAndTomorrow(int arg0, int arg1, int arg2, int arg3, int arg4) {
        // sätta upp API:et
        room1 = repository.save(new Room("test"));
    }

    @When("Alice books Room 1 for tomorrow between 13:00 and 15:00")
    public void aliceMakesABooking() {
        // alice makes a booking
        RestTemplate rt = new RestTemplate();
        LocalTime kl13 = LocalTime.parse("13:00");
        LocalTime kl15 = LocalTime.parse("15:00");
        Booking res = rt.postForObject("http://localhost:" + serverPort + "/rooms/" + room1.getId() + "/bookings",
                new Booking(0, LocalDateTime.now().plusDays(1).with(kl13),
                        LocalDateTime.now().plusDays(1).with(kl15), "Alice"),
                Booking.class);
    }

    @Then("Room 1 is booked between 13:00 and 15:00 by Alice")
    public void roomBecomesBooked() {
        // room is booked

    }
}
