package com.sinensia.netflix.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityAdapter{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement((session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/title/create").authenticated()
                .antMatchers("/api/title/update").authenticated()
                .antMatchers("/api/title/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/actor/create").authenticated()
                .antMatchers("/api/actor/update").authenticated()
                .antMatchers("/api/actor/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/category/create").authenticated()
                .antMatchers("/api/category/update").authenticated()
                .antMatchers("/api/category/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/director/create").authenticated()
                .antMatchers("/api/director/update").authenticated()
                .antMatchers("/api/director/delete").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("{noop}user")
                .roles("USER")
                .build();
        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();



        return new InMemoryUserDetailsManager(user,admin);
    }
}