package com.melihcanclk.OauthServer.config;

import com.melihcanclk.OauthServer.services.CustomAuthanticatonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class DefaultSecurityConfig {

    @Autowired
    private CustomAuthanticatonProvider customAuthanticatonProvider;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
        ).formLogin((Customizer.withDefaults()));
        return httpSecurity.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  {
        auth.authenticationProvider(customAuthanticatonProvider);
    }
}
