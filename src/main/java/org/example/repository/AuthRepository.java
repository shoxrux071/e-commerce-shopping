package org.example.repository;

import org.example.domains.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);
}
