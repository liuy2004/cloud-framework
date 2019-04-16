package com.sech.framework.business.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;

/**
 * sso demo
 *
 * @author sech.io
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@EnableOAuth2Sso
@ComponentScan(basePackages = {"com.sech.framework.business.sso"})
public class FwSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwSsoApplication.class, args);
    }

}
