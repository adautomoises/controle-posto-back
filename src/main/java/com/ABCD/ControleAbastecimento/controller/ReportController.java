package com.ABCD.ControleAbastecimento.controller;

import com.ABCD.ControleAbastecimento.service.RelatorioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/relatorio")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ReportController {
    private final RelatorioService service;
    @GetMapping
    public void generateReport() throws JRException, FileNotFoundException {
        service.exportReport();
    }
}
