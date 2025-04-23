package com.uade.tpo.electromarket.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.uade.tpo.electromarket.entity.Role;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtAuthFilter;
        private final AuthenticationProvider authenticationProvider;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(req -> req.requestMatchers("/api/v1/auth/**").permitAll()
                                                .requestMatchers("/error/**").permitAll()
                                                .requestMatchers(HttpMethod.GET,"/categorias/**").permitAll()
                                                .requestMatchers(HttpMethod.GET,"/categorias/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.POST,"/categorias/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.PUT,"/categorias/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.DELETE,"/categorias/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.GET,"/productos/**").permitAll()
                                                .requestMatchers(HttpMethod.GET,"/productos/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.POST,"/productos/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.PUT,"/productos/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.DELETE,"/productos/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.GET,"/usuarios/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.POST,"/usuarios/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.PUT,"/usuarios/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers(HttpMethod.DELETE,"/usuarios/**").hasAnyAuthority(Role.ADMIN.name())
                                                .requestMatchers("/pedidos/**").hasAnyAuthority(Role.USER.name())
                                                .requestMatchers("/pedidos/**").hasAnyAuthority(Role.ADMIN.name())
                                                .anyRequest()
                                                .authenticated())
                                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }
}
