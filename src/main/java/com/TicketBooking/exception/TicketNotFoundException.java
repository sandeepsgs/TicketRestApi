package com.TicketBooking.exception;

public class TicketNotFoundException extends Exception {


private long book_id;

public TicketNotFoundException(long id) {
        super(String.format("Ticket is not found with id : '%s'", id));
        }

}