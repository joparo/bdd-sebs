package org.joparo.sebs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Booking {

    private long bookingId;
    private final long roomId;
    private final LocalDateTime startDate;
    private final LocalDateTime stopDate;
    private final String bookedBy;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Booking(@JsonProperty("roomId")  long roomId, @JsonProperty("startDate")  LocalDateTime startDate,
                   @JsonProperty("stopDate")  LocalDateTime stopDate,
                   @JsonProperty("bookedBy")  String bookedBy) {
        this.startDate = startDate.truncatedTo(ChronoUnit.HOURS);
        this.stopDate = stopDate.truncatedTo(ChronoUnit.HOURS);
        if(this.stopDate.isBefore(startDate))
            throw new IllegalArgumentException("Startdate must be before stopdate");
        this.roomId = roomId;
        this.bookedBy = bookedBy;
    }

    public long getRoomId() {
        return roomId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getStopDate() {
        return stopDate;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public boolean collidesWith(Booking otherBooking) {
        return this.roomId == otherBooking.roomId &&
                this.startDate.isBefore(otherBooking.stopDate) &&
                this.stopDate.isAfter(otherBooking.startDate);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "roomId=" + roomId +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                ", bookedBy='" + bookedBy + '\'' +
                '}';
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }
}
