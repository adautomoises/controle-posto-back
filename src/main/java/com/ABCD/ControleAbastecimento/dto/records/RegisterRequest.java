package com.ABCD.ControleAbastecimento.dto.records;

import com.ABCD.ControleAbastecimento.model.enums.UserRole;

public record RegisterRequest(String login, String password, UserRole role) {
}
