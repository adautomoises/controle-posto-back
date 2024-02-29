package com.ABCD.ControleAbastecimento.dto.users;

import com.ABCD.ControleAbastecimento.model.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String login;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
