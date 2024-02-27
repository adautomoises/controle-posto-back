package com.ABCD.ControleAbastecimento.dto.abastecimento;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbastecimentoRequest {
    @NotNull
    private Long bomba_id;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private LocalDate data;
}
