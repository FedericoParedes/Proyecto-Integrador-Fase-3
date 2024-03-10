package com.paredesfederico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paredesfederico.entidades.Pelicula;

import jakarta.transaction.Transactional;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

	List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
	
	Pelicula findPeliculaById(Integer id);
		
}
