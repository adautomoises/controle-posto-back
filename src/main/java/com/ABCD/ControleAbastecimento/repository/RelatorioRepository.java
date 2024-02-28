package com.ABCD.ControleAbastecimento.repository;

import com.ABCD.ControleAbastecimento.model.Relatorio;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
    @Query(value = "SELECT a.valor, a.data, a.bomba_id, c.tipo, t.id as tanque_id FROM abastecimento as a \n" +
            "INNER JOIN bomba as b ON b.id = a.bomba_id\n" +
            "INNER JOIN tanque as t ON t.id = b.tanque_id\n" +
            "INNER JOIN combustivel as c ON t.combustivel_id = c.id\n" +
            "ORDER BY a.data asc, c.tipo desc;", nativeQuery = true)
    List<Tuple> gerarRelatorio();
}
