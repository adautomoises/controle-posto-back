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
    @JoinColumn(name="tanque_id")
    private Tanque tanque;

    private BigDecimal valor;
    private BigDecimal imposto;
    private LocalDate data;
}
