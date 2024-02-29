package com.ABCD.ControleAbastecimento.repository;

import com.ABCD.ControleAbastecimento.model.User;
import com.ABCD.ControleAbastecimento.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);

    List<User> findAllByRole(UserRole role);
}
