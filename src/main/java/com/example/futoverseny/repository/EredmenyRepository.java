package com.example.futoverseny.repository;

import com.example.futoverseny.model.Eredmeny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EredmenyRepository extends JpaRepository<Eredmeny, Long> {
}
