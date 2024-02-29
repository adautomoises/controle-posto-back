package com.ABCD.ControleAbastecimento.repository;

import com.ABCD.ControleAbastecimento.model.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
}
