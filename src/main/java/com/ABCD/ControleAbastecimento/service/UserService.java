package com.ABCD.ControleAbastecimento.service;

import com.ABCD.ControleAbastecimento.dto.users.UserDTO;
import com.ABCD.ControleAbastecimento.model.User;
import com.ABCD.ControleAbastecimento.model.enums.UserRole;
import com.ABCD.ControleAbastecimento.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> listarFrentistas(){
        List<User> users = userRepository.findAllByRole(UserRole.ATTENDANT);

        List<UserDTO> usersDTO = users.stream()
                .map(user -> new UserDTO(user.getId(), user.getLogin(), user.getRole()))
                .collect(Collectors.toList());

        return usersDTO;
    }
}
