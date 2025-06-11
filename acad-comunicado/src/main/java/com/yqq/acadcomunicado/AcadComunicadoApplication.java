package com.yqq.acadcomunicado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AcadComunicadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcadComunicadoApplication.class, args);
    }

}
