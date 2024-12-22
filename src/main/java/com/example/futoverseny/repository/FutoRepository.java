package com.example.futoverseny.repository;

import com.example.futoverseny.model.Futo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutoRepository extends JpaRepository<Futo, Long> {
}
