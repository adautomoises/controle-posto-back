package com.ABCD.ControleAbastecimento.model;

import com.ABCD.ControleAbastecimento.model.enums.TipoCombustivel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Combustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipo;

    private BigDecimal valor;
}
