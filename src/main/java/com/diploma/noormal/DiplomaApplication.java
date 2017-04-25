package com.diploma.noormal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class DiplomaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DiplomaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DiplomaApplication.class, args);
    }
}
