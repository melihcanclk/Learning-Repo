package com.melihcanclk.DepartmentApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    private static final String[] WHITELIST_URLS = {
            "/register",
            "/h2-console",
            "/h2-console/**",
            "/h2-console/**?**",
            "/verifyRegistration",
            "/verifyRegistration?token=*",
            "/resendVerification",
            "/resendVerification?token=*",
            "/resetPassword",
            "/resetPassword?token=*",
            "/savePassword",
            "/savePassword?token=*"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    // we cannot login without this bean
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(request -> {
                                    List<String> whitelistUrls = List.of(WHITELIST_URLS);
                                    return whitelistUrls.stream().anyMatch(url -> url.equals(request.getServletPath()));
                                }
                        ).permitAll()
                ).authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/api/**").authenticated()
                ).oauth2Login((oauth2Login) ->
                        oauth2Login.loginPage("/oauth2/authorization/custom-client-oidc")
                ).oauth2Client(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                // for h2 console, we need to disable frame options because h2 console uses frames
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }
}
