package com.spring.devblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//remover esse excluda da segurança apos configurar o spring security
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class DevblogApplication {

    public static void main(String[] args) {

        SpringApplication.run(DevblogApplication.class, args);
    }

}
