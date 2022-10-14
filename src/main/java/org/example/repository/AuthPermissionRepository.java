package org.example.repository;


import org.example.domains.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthPermissionRepository extends JpaRepository<AuthRole, Long> {
}
