package com.paredesfederico.services;

import java.util.List;

import com.paredesfederico.dto.PeliculaDTO;

public interface IGeneroService {

	
	List<PeliculaDTO> obtenerPorGenero (String genero);
	
	
	
}
