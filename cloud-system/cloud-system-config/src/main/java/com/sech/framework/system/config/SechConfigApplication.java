package com.sech.framework.system.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config Server 配置中心
 *
 * @author sech.io
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class SechConfigApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SechConfigApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SechConfigApplication.class, args);
    }

}
