package com.ABCD.ControleAbastecimento.repository;

import com.ABCD.ControleAbastecimento.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
}
