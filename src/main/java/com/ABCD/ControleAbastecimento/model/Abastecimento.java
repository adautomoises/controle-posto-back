package com.ABCD.ControleAbastecimento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bomba_id")
    private Bomba bomba;

    private BigDecimal valor;
    private BigDecimal imposto;
    private BigDecimal litros;
    private LocalDate data;
}
