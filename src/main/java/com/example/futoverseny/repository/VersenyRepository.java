package com.example.futoverseny.repository;

import com.example.futoverseny.model.Verseny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersenyRepository extends JpaRepository<Verseny, Long> {
}
