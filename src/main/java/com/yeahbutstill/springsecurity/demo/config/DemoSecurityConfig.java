package com.yeahbutstill.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("PELAKSANA", "BPR", "FU", "BASICROLES")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                        .antMatchers("/").hasRole("BASICROLES")
                        .antMatchers("/gssk/**").hasRole("BPR")
                        .antMatchers("/gamr/**").hasRole("PELAKSANA")
                        .and()
                        .formLogin()
                            .loginPage("/showMyLoginPage")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll()
                        .and()
                        .logout().permitAll()
                        .and()
                        .exceptionHandling().accessDeniedPage("/access-denied");
        return http.build();
    }

}
