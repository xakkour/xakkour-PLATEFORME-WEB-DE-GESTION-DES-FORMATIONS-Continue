package com.pfe.myschool.service;

import com.pfe.myschool.model.User;
import com.pfe.myschool.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      final   User currentUser = accountRepository.findUserByUsername(username);
        if (currentUser==null)
        {throw new UsernameNotFoundException("User Not Found"+username);}

        return (UserDetails) currentUser;
    }
}
