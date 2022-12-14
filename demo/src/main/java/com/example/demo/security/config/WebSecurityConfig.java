package com.example.demo.security.config;

import com.example.demo.domain.model.UserAdditional;
import com.example.demo.security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;
    private RestAuthEntryPoint restAuthEntryPoint;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, RestAuthEntryPoint restAuthEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.restAuthEntryPoint = restAuthEntryPoint;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/archive").hasAnyRole( "ADMIN", "USER")
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/ratings").hasAnyRole( "ADMIN", "USER")
                    .anyRequest().permitAll()
                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(restAuthEntryPoint)
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .successHandler((request, response, authentication) -> {
                        response.setStatus(200);
                    })
                    .failureHandler((request, response, authentication) -> {

                        response.setStatus(401);
                    })
                .and()
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                  .invalidateHttpSession(true)
                  .deleteCookies("JSESSIONID")
                .and().httpBasic()
                .and().cors()
                .and().csrf().disable();

    }



}
