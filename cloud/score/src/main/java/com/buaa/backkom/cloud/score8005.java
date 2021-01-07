package com.buaa.backkom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class score8005
{
    public static void main (String[] args) {
        SpringApplication.run(score8005.class,args);
    }
}
