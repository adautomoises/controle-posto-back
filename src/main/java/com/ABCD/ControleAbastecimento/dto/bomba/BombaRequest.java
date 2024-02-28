package com.ABCD.ControleAbastecimento.dto.bomba;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BombaRequest {
    @NotNull
    private Long tanque_id;
}
