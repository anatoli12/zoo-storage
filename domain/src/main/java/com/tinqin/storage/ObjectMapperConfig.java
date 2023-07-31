package com.tinqin.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper om = new ObjectMapper();

        om.findAndRegisterModules();

        return om;
    }
}
