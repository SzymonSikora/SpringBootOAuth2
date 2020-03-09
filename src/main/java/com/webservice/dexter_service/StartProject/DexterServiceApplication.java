package com.webservice.dexter_service.StartProject;


import com.webservice.dexter_service.Model.Entity.OAuthClient;
import com.webservice.dexter_service.Services.Implementations.OAuthServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.HashSet;

@SpringBootApplication
@ComponentScan(basePackages = {"com.webservice.dexter_service"})
@EnableJpaRepositories(basePackages = {"com.webservice.dexter_service.Repository"})
@EntityScan(basePackages = {"com.webservice.dexter_service.Model.Entity"})
@EnableAuthorizationServer
@EnableResourceServer
public class DexterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DexterServiceApplication.class, args);
        Logger logger = LoggerFactory.getLogger(DexterServiceApplication.class);
        logger.info("Server is started!");
    }
/*
    @Bean
    FilterRegistrationBean<JwtFilter> filterRequestWithAuthorizationBean() {
        FilterRegistrationBean<JwtFilter> filterRegistrationBean = new FilterRegistrationBean<JwtFilter>();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.setUrlPatterns(Collections.singleton(Enums.REQUESTS_PREFIXES.API_AUTH + "*"));
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegistrationBean;
    }*/
}
