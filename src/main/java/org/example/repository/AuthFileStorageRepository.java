package org.example.repository;

import org.example.domains.Uploads;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthFileStorageRepository extends JpaRepository<Uploads, Long> {
}
