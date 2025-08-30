package com.example.omnichannelticketsystem.service;

import com.example.omnichannelticketsystem.domain.Ticket;
import com.example.omnichannelticketsystem.domain.User;
import com.example.omnichannelticketsystem.repository.TicketRepository;
import com.example.omnichannelticketsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public UserService(UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Map<String, Long> getTicketCloseCountByUser() {
        return userRepository.findAll().stream()
                .collect(Collectors.toMap(
                        User::getName,
                        user -> (long) ticketRepository.findByAssigneeAndStatus(user, Ticket.Status.CLOSED).size()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
