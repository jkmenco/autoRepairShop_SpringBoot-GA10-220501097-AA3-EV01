package com.autorepairshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
})
public class AutoRepairShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoRepairShopApplication.class, args);
    }
}
