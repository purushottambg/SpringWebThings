package com.week2WebApplication.SpringWebThings.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper createMapper(){
        return new ModelMapper();
    }
}
