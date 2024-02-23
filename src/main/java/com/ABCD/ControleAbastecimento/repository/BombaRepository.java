package com.ABCD.ControleAbastecimento.repository;

import com.ABCD.ControleAbastecimento.model.Bomba;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BombaRepository extends JpaRepository<Bomba, Long> {
    Optional<Bomba> findById(Long id);
}
