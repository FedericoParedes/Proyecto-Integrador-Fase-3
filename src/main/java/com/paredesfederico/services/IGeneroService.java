package com.paredesfederico.services;

import java.util.List;

import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.ResumenPeliculaDTO;

public interface IGeneroService {

	
	List<ResumenPeliculaDTO> obtenerPorGenero (String genero);
	
	
	
}
