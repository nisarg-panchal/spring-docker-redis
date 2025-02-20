package com.nisarg.dockerdemo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableAdminServer
@Slf4j
@EntityScan(basePackages = "com.nisarg.dockerdemo.bean")
public class SpringDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerApplication.class, args);
    }

}
