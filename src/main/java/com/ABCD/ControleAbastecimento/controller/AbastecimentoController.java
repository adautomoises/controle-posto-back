package com.ABCD.ControleAbastecimento.controller;

import com.ABCD.ControleAbastecimento.dto.abastecimento.AbastecimentoRequest;
import com.ABCD.ControleAbastecimento.model.Abastecimento;
import com.ABCD.ControleAbastecimento.service.AbastecimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/abastecimento")
@RequiredArgsConstructor
public class AbastecimentoController {
    private final AbastecimentoService abastecimentoService;

    @GetMapping
    public ResponseEntity<List<Abastecimento>> listarAbastecimentos(){
        return new ResponseEntity<>(abastecimentoService.listarAbastecimentos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Abastecimento> fazerAbastecimento(@RequestBody @Valid AbastecimentoRequest abastecimentoRequest){
        return new ResponseEntity<>(abastecimentoService.fazerAbastecimento(abastecimentoRequest), HttpStatus.CREATED);
    }
}
