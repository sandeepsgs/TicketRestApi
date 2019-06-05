package com.TicketBooking.controller;
import com.TicketBooking.exception.TicketNotFoundException;
import com.TicketBooking.model.Ticket;
import com.TicketBooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TicketController {
	@Autowired
    TicketRepository ticketRepository;
	 @GetMapping("/AllTickets")
	    public List<Ticket> getAllTickets() {
	        return ticketRepository.findAll();
	    }
 @PostMapping("/BuyTicket")
    public Ticket createTicekt(@Valid @RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }
 @GetMapping("/FindTickets/{id}")
 public Ticket getTicketById(@PathVariable(value = "id") Long ticketId) throws TicketNotFoundException {
     return ticketRepository.findById(ticketId)
             .orElseThrow(() -> new TicketNotFoundException(ticketId));
 }
 @PutMapping("/UpadteTickets/{id}")
 public Ticket updateTicket(@PathVariable(value = "id") Long ticketId,
                        @Valid @RequestBody Ticket ticketDetails) throws TicketNotFoundException {

Ticket ticket = ticketRepository.findById(ticketId)
             .orElseThrow(() -> new TicketNotFoundException(ticketId));

ticket.setFromlocation(ticketDetails.getFromlocation());
     ticket.setToLocation(ticketDetails.getToLocation());
     ticket.setFare(ticketDetails. getFare());

Ticket updatedTicket = ticketRepository.save(ticket);

return updatedTicket;
 }
 @DeleteMapping("/DeleteTickets/{id}")
 public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long ticketId) throws TicketNotFoundException {
     Ticket ticket = ticketRepository.findById(ticketId)
             .orElseThrow(() -> new TicketNotFoundException(ticketId));

ticketRepository.delete(ticket);

return ResponseEntity.ok().build();
 }
}
