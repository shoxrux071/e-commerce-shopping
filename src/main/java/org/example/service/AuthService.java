package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.configs.security.UserDetails;
import org.example.domains.AuthUser;
import org.example.repository.AuthRepository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 15/10/22 01:48 (Saturday)
 * e-commerce-shopping/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        return new UserDetails(authUser);
    }
}

