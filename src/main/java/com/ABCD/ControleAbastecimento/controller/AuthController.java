package com.ABCD.ControleAbastecimento.controller;

import com.ABCD.ControleAbastecimento.dto.records.LoginRequest;
import com.ABCD.ControleAbastecimento.dto.records.LoginResponse;
import com.ABCD.ControleAbastecimento.dto.records.RegisterRequest;
import com.ABCD.ControleAbastecimento.infra.security.TokenService;
import com.ABCD.ControleAbastecimento.model.User;
import com.ABCD.ControleAbastecimento.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> Login(@RequestBody @Valid LoginRequest data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return new ResponseEntity<>(new LoginResponse(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public  ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest data){
        if(userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        userRepository.save(newUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
