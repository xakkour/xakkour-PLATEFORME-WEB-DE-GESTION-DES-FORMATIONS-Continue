package com.pfe.myschool.service;

import com.pfe.myschool.model.User;

import com.pfe.myschool.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public User addNewUser(String username, String password, String email, String ConfirmPassword,String role) {

        User userByUsername = accountRepository.findUserByUsername(username);
        if (userByUsername!=null) throw new RuntimeException(" User Deja existe");
        User.builder().id(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE)
                .username(username)
                .email(email)
                .role(role)
                .password(password).isActive(true).build();



        return null;
    }
}
