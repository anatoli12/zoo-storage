package com.tinqin.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tinqin.storage"})
@EntityScan(basePackages = {"com.tinqin.storage.persistence.model"})
@EnableJpaRepositories(basePackages = {"com.tinqin.storage.persistence.repository"})
@EnableFeignClients
public class ZooTradeStorageApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZooTradeStorageApplication.class, args);
  }
}
