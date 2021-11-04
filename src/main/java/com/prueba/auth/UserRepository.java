package com.prueba.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.auth.models.Login;

public interface UserRepository extends JpaRepository<Login, String> {

	Optional<Login> findByUserName(String userName);
	
}
