package com.paredesfederico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paredesfederico.entidades.Genero;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer>{

	Genero findByNombreGenero (String nombreGenero);
	
	
}
