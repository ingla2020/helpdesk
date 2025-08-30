package com.example.omnichannelticketsystem.config;

import com.example.omnichannelticketsystem.converter.StringToUserConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final StringToUserConverter stringToUserConverter;

    public WebConfig(StringToUserConverter stringToUserConverter) {
        this.stringToUserConverter = stringToUserConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToUserConverter);
    }
}
