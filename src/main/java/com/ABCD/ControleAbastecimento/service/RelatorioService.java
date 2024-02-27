package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.model.Abastecimento;
import com.ABCD.ControleAbastecimento.model.Relatorio;
import com.ABCD.ControleAbastecimento.model.Tanque;
import com.ABCD.ControleAbastecimento.repository.RelatorioRepository;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final RelatorioRepository relatorioRepository;
    public void exportReport() throws FileNotFoundException, JRException {

        List<Relatorio> relatorio = relatorioRepository.findAll();

        File file = ResourceUtils.getFile("classpath:supplies.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(relatorio);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Posto ABCD");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/resources/abastecimentos.pdf");
    }
    public Relatorio convertSuppliesToReport(Abastecimento abastecimento) {
        Relatorio relatorio = new Relatorio();

        Tanque tanque = abastecimento.getBomba().getTanque();

        relatorio.setTanque(tanque.getId().toString());
        relatorio.setBomba(abastecimento.getBomba().getId().toString());
        relatorio.setCombustivel(tanque.getCombustivel().getTipo().name());
        relatorio.setValor(abastecimento.getValor().toString());
        relatorio.setData(abastecimento.getData().toString());

        return relatorio;
    }
}
