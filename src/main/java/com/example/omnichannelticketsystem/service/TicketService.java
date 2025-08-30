package com.example.omnichannelticketsystem.service;

import com.example.omnichannelticketsystem.domain.Ticket;
import com.example.omnichannelticketsystem.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setStatus(Ticket.Status.OPEN);
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Ticket ticket) {
        ticket.setUpdatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public void closeTicket(Long id) {
        Ticket ticket = getTicketById(id);
        if (ticket != null) {
            ticket.setStatus(Ticket.Status.CLOSED);
            ticket.setClosedAt(LocalDateTime.now());
            ticketRepository.save(ticket);
        }
    }
}
