package com.example.address_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfiguration {
    @Bean
    public ModelMapper mmap() {
        return new ModelMapper();
    }
}
