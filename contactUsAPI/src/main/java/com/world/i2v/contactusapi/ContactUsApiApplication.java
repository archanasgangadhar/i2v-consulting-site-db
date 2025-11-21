package com.world.i2v.contactusapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class ContactUsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactUsApiApplication.class, args);
    }

}
