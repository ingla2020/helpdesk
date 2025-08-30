package com.example.omnichannelticketsystem.converter;

import com.example.omnichannelticketsystem.domain.User;
import com.example.omnichannelticketsystem.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToUserConverter implements Converter<String, User> {

    private final UserService userService;

    public StringToUserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            Long id = Long.parseLong(source);
            return userService.getUserById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
