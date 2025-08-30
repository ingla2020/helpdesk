package com.example.omnichannelticketsystem.repository;

import com.example.omnichannelticketsystem.domain.Ticket;
import com.example.omnichannelticketsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByAssigneeAndStatus(User assignee, Ticket.Status status);
}
