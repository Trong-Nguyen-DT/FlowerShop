package com.example.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder().encode("user1Pass"))
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withUsername("user2")
//                .password(passwordEncoder().encode("user2Pass"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }

//    @Primary
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailService();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/login*", "/css/**", "/images/**", "/js/**")
                            .permitAll()
                            .requestMatchers("/", "/home/**", "product", "category", "/about/**", "/contact/**").permitAll()
                            .anyRequest()
                            .authenticated()
                )
                .formLogin(formLogin -> formLogin.loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")

                )
                .logout(logout -> logout.logoutUrl("/perform_logout")
                                .deleteCookies("JSESSIONID")
                )
        ;
        return http.build();
    }
}