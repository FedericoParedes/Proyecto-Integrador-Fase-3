package com.paredesfederico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paredesfederico.entidades.Pelicula;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

	List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
	
}
