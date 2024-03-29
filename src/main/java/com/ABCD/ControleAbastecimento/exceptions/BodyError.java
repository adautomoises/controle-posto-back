package com.ABCD.ControleAbastecimento.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BodyError {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Fortaleza")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
