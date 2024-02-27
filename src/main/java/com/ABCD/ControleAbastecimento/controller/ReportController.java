package com.ABCD.ControleAbastecimento.controller;

import com.ABCD.ControleAbastecimento.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/relatorio")
@RequiredArgsConstructor
public class ReportController {
    @Autowired
    private RelatorioService service;

    @GetMapping
    public String generateReport() throws JRException, FileNotFoundException {
        return service.exportReport();
    }
}
