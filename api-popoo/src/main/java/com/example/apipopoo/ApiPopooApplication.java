package com.example.apipopoo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {
        "com.example.apipopoo",
        "com.example.servicepopoo"
})
public class ApiPopooApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPopooApplication.class, args);

    }

}
