package com.example.omnichannelticketsystem.controller;

import com.example.omnichannelticketsystem.domain.Ticket;
import com.example.omnichannelticketsystem.service.TicketService;
import com.example.omnichannelticketsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "tickets/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("priorities", Ticket.Priority.values());
        return "tickets/form";
    }

    @PostMapping
    public String create(Ticket ticket) {
        ticketService.createTicket(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ticket", ticketService.getTicketById(id));
        return "tickets/view";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ticket", ticketService.getTicketById(id));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("priorities", Ticket.Priority.values());
        model.addAttribute("statuses", Ticket.Status.values());
        return "tickets/form";
    }

    @PostMapping("/{id}")
    public String update(Ticket ticket) {
        ticketService.updateTicket(ticket);
        return "redirect:/tickets";
    }

    @PostMapping("/{id}/close")
    public String close(@PathVariable("id") Long id) {
        ticketService.closeTicket(id);
        return "redirect:/tickets";
    }
}
