package com.ABCD.ControleAbastecimento.controller;

import com.ABCD.ControleAbastecimento.dto.users.UserDTO;
import com.ABCD.ControleAbastecimento.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;
    @GetMapping("/frentistas")
    public ResponseEntity<List<UserDTO>> listarFrentistas(){
        return new ResponseEntity<>(userService.listarFrentistas(), HttpStatus.OK);
    }
}
