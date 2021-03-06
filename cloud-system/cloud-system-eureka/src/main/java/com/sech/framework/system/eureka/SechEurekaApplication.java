package com.sech.framework.system.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server 中心
 *
 * @author sech.io
 */
@EnableEurekaServer
@SpringBootApplication
public class SechEurekaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SechEurekaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SechEurekaApplication.class, args);
    }

}
