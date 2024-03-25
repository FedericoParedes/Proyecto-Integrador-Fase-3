package com.paredesfederico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paredesfederico.entidades.Rol;
import com.paredesfederico.enums.TipoRol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

	Optional<Rol> findByNombreRol(TipoRol nombreRol);
	
}
