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
public class TanqueRequest {
    @NotNull
    private BigDecimal capacidade;
    @NotNull
    private Long combustivel_id;
}
