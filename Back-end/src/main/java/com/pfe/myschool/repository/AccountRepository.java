package com.pfe.myschool.repository;

import com.pfe.myschool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <User ,Long> {
User findUserByUsername(String username);

}
