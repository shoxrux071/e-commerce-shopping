package org.example.configs.security.encryption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 15/10/22 00:27 (Saturday)
 * e-commerce-shopping/IntelliJ IDEA
 */
@Configuration
public class Encoders {
    @Bean
public PasswordEncoder passwordEncoder(){
    return new  BCryptPasswordEncoder();
}
}