package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Security configuration class to set up authentication and authorization for the application
@Configuration
@EnableWebSecurity
public class SecurityConfig {

        // Configure security settings for the application
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                                .csrf(csrf -> csrf.disable())

                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/", "/login", "/images/**", "/css/**", "/js/**",
                                                                "/service/**", "/getjson", "/getxml")
                                                .permitAll()
                                                .anyRequest().authenticated())

                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .loginProcessingUrl("/login")
                                                .failureUrl("/login?error")
                                                .defaultSuccessUrl("/orders/display", true)
                                                .permitAll())

                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login?logout")
                                                .permitAll());

                return http.build();
        }

        // Define an in-memory user for authentication purposes
        @Bean
        public UserDetailsService users() {
                UserDetails user = User.withUsername("test")
                                .password("{noop}test")
                                .roles("USER")
                                .build();

                return new InMemoryUserDetailsManager(user);
        }
}