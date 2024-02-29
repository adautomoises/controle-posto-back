package com.ABCD.ControleAbastecimento.repository;

import com.ABCD.ControleAbastecimento.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanqueRepository extends JpaRepository<Tanque, Long> {}
