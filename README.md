# Simple Easy Booking Service (SEBS)

A simple booking API for testing Behavior driven development (BDD) using Springboot and Cucumber.

Start the app:
```
gradle bootRun
```

Create a room (to add bookings for)

```
curl -H "Content-type: application/json" localhost:8080/rooms --data-raw '{ "name" : "Room 1"  }'
```

Create a booking

```
curl -H "Content-type: application/json" localhost:8080/rooms/0/bookings --data-raw '{ "roomId" : 1, "startDate" : "2021-05-05T09:00", "stopDate" : "2021-05-05T10:00", "bookedBy" : "joparo"}'
```
