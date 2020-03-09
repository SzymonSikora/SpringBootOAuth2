package com.webservice.dexter_service.Security;

import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Common.Enums.IREQUESTS;
import com.webservice.dexter_service.Common.Enums.ITEXTS;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(Enums.TEXTS.RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers(Enums.REQUESTS.ADMIN + "/**").hasAnyAuthority("ADMIN")
                .antMatchers(Enums.REQUESTS.USER + "/**").hasAnyAuthority("USER")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
    /*
    anonymous().disable()
                .authorizeRequests()
                .antMatchers("/account/**").hasAnyAuthority("ADMIN")
                .antMatchers("/connection").access("#oauth2.hasAnyScope('read')")
                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
                .antMatchers("/users/**").hasAnyAuthority("ADMIN")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());*/
}
