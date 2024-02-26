package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.model.Abastecimento;
import com.ABCD.ControleAbastecimento.repository.AbastecimentoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportService {

    @Autowired
    private AbastecimentoRepository repository;
    public String exportReport() throws FileNotFoundException, JRException {

        List<Abastecimento> abastecimentos = repository.findAll();

        File file = ResourceUtils.getFile("classpath:supplies.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(abastecimentos);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Posto ABCD");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/resources/abastecimentos.pdf");

        return "";
    }
}
