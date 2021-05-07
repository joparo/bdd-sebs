Feature: Bookings can be created and retrieved

  Scenario: User makes a booking of a room that is not booked
    Given Room 1 is available between 13:00 and 15:00 tomorrow
    When Alice books Room 1 for tomorrow between 13:00 and 15:00
    Then Room 1 is booked between 13:00 and 15:00 by Alice
    
  Scenario: User can retrieve all bookings for a given time span
    Given Room 1 is booked between 13:00 and 15:00 today, between 14:00 and 16:00 tomorrow, and between 16:00 and 17:00 the day after tomorrow
    When Alice retrieves a list of bookings for room 1 for today and tomorrow
    Then A list with two bookings is recieved.

  Scenario: User can not make a booking if the room is already booked for that time span
    Given Room 1 is booked between 13:00 and 15:00 tomorrow by Bob
    When Alice makes a booking between 11:00 and 14:00 tomorrow
    Then Alice receives a message that "The room is booked by Bob between 13:00 and 15:00"
