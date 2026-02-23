package com.ctd.gmbd.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VertWebApp {

    public static void main(String[] args) {
        // This line launches the entire Spring framework
        SpringApplication.run(VertWebApp.class, args);
        
        System.out.println("SB Backend is running on http://localhost:8080");
    }
}