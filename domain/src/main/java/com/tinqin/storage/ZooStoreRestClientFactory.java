package com.tinqin.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqin.restexport.ZooStoreRestExport;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ZooStoreRestClientFactory {
    private final ObjectMapper objectMapper;
    @Bean
    ZooStoreRestExport getRestExportClient(){
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(ZooStoreRestExport.class, "http://localhost:8080");
    }
}
