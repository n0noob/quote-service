package com.n0noob.quoteservice.configurations.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/quote-api/v1/authors/*").authenticated()
                .antMatchers(HttpMethod.POST, "/quote-api/v1/authors/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/quote-api/v1/authors/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/quote-api/v1/authors/*").hasRole("ADMIN")
                .antMatchers("/quote-api/v1/quotes/*").authenticated()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails alexUserDetails = User.builder()
                .username("alex")
                .password(passwordEncoder.encode("standardpassword"))
                .roles("STANDARD")
                .build();

        UserDetails adminUserDetails = User.builder()
                .username("n0noob")
                .password(passwordEncoder.encode("adminpassword"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(alexUserDetails, adminUserDetails);
    }

}
