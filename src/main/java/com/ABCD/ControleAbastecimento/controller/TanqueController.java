package com.ABCD.ControleAbastecimento.controller;

import com.ABCD.ControleAbastecimento.dto.tanque.TanquePut;
import com.ABCD.ControleAbastecimento.dto.tanque.TanqueRequest;
import com.ABCD.ControleAbastecimento.model.Tanque;
import com.ABCD.ControleAbastecimento.service.TanqueService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tanques")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class TanqueController {

    private final TanqueService tanqueService;

    @GetMapping
    public ResponseEntity<List<Tanque>> listarTanques(){
        return new ResponseEntity<>(tanqueService.listarTanques(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tanque> adicionarTanque(@RequestBody @Valid TanqueRequest tanqueRequest){
        return new ResponseEntity<>(tanqueService.adicionarTanque(tanqueRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Tanque> atualizarTanque(@RequestBody @Valid TanquePut tanquePut){
        return new ResponseEntity<>(tanqueService.atualizarTanque(tanquePut), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> removerTanque(Long id){
        return new ResponseEntity<>(tanqueService.removerTanque(id), HttpStatus.NO_CONTENT);
    }
}
