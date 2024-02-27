package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.model.Abastecimento;
import com.ABCD.ControleAbastecimento.model.Relatorio;
import com.ABCD.ControleAbastecimento.model.Tanque;
import com.ABCD.ControleAbastecimento.repository.AbastecimentoRepository;
import com.ABCD.ControleAbastecimento.repository.RelatorioRepository;

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
public class RelatorioService {

    @Autowired
    private AbastecimentoRepository repository;
    @Autowired
    private RelatorioRepository relatorioRepository;
    public String exportReport() throws FileNotFoundException, JRException {

        List<Abastecimento> abastecimentos = repository.findAll();
        List<Relatorio> relatorio = relatorioRepository.findAll();

        File file = ResourceUtils.getFile("classpath:supplies.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(relatorio);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Posto ABCD");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/resources/abastecimentos.pdf");

        return "";
    }

    public static Map<String, Object> createMapObjectToReport(Relatorio relatorio){
        Map<String, Object> map = new HashMap<>();

        map.put("tanque", relatorio.getTanque());
        map.put("bomba", relatorio.getBomba());
        map.put("combutivel", relatorio.getCombustivel());
        map.put("valor", relatorio.getValor());
        map.put("data", relatorio.getData());

        return map;
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
