package com.codewithrufu.springboot.springfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
         @Bean
         public InMemoryUserDetailsManager userDetailsManager() {

             Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

             UserDetails user1 = createNewUser(passwordEncoder, "rufu", "123");
             UserDetails user2 = createNewUser(passwordEncoder, "rufus", "1234");
//             UserDetails user3 = createNewUser(passwordEncoder, "rufuss", "12345");
             return new InMemoryUserDetailsManager(user1,user2);
         }

    private static UserDetails createNewUser(Function<String, String> passwordEncoder, String username, String password) {
        UserDetails user =  User.builder()
               .passwordEncoder(passwordEncoder)
               .username(username)
               .password(password)
               .roles("USER","ADMIN")
               .build();
        return user;
    }

    @Bean
         public PasswordEncoder passwordEncoder() {
             return new BCryptPasswordEncoder();
         }

         //all urls are protected
        //a login page is displayed
        //CsRF disable
        //Frames
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
             http.authorizeHttpRequests(
                     authorize -> authorize.anyRequest().authenticated());
             http.formLogin(withDefaults());

             // After
             http.csrf(AbstractHttpConfigurer::disable);
             http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
             return http.build();
    }
}
