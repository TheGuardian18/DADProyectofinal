package com.yqq.acadlogro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AcadLogroApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcadLogroApplication.class, args);
    }

}
