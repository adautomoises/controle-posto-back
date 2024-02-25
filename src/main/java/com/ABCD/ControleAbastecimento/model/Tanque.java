package com.ABCD.ControleAbastecimento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Tanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private List<Bomba> bombas;

    private BigDecimal capacidade;
}
