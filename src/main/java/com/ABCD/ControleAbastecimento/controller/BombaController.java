package com.ABCD.ControleAbastecimento.controller;

import com.ABCD.ControleAbastecimento.dto.bomba.BombaPut;
import com.ABCD.ControleAbastecimento.dto.bomba.BombaRequest;
import com.ABCD.ControleAbastecimento.model.Bomba;
import com.ABCD.ControleAbastecimento.service.BombaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bombas")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class BombaController {
    private final BombaService bombaService;

    @GetMapping
    public ResponseEntity<List<Bomba>> listarBombas(){
        return new ResponseEntity<>(bombaService.listarBombas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bomba> adicionarBomba(@RequestBody @Valid BombaRequest bombaRequest){
        return new ResponseEntity<>(bombaService.adicionarBomba(bombaRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Bomba> atualizarBomba(@RequestBody @Valid BombaPut bombaPut){
        return new ResponseEntity<>(bombaService.atualizarBomba(bombaPut), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> removerBomba(Long id){
        return new ResponseEntity<>(bombaService.removerBomba(id), HttpStatus.NO_CONTENT);
    }
}
