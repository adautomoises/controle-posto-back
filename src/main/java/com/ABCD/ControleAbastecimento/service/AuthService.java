package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.exceptions.BadRequestException;
import com.ABCD.ControleAbastecimento.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByLogin(username);
        if(user == null){
            throw new BadRequestException("Usuário inválido!");
        }

        return userRepository.findByLogin(username);
    }
}
