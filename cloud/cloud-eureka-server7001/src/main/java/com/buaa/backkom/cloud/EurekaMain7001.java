package com.buaa.backkom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: backkom
 * @Date: 2020/9/12 19:47
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001
{
    public static void main (String[] args)
    {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}