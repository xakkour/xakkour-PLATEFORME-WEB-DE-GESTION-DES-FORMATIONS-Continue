package com.pfe.myschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String name);
    Optional<User> findByResetToken(String resetToken);
	Optional<User> findByEmail(String email);

}
