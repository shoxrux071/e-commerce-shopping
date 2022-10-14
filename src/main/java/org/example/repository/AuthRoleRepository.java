package org.example.repository;

import org.example.domains.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
    @Query("select t from AuthRole t where t.code = :code")

    AuthRole findByCode(@Param("code") String code);
}
