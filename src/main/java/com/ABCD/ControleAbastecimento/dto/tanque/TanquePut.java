package com.ABCD.ControleAbastecimento.dto.tanque;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TanquePut {
    @NotNull
    private Long id;
    @NotNull
    private Long combustivel_id;
    @NotNull
    private BigDecimal capacidade;
}
