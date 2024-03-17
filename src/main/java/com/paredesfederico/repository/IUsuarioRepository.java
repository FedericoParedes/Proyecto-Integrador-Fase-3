package com.paredesfederico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paredesfederico.entidades.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	
	Optional<Usuario> findUsuarioByEmail(String email);
	
	
	
}
