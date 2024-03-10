package com.paredesfederico.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.ResumenPeliculaDTO;

public interface IPeliculaService {

	ResumenPeliculaDTO registrarPelicula (String movie, MultipartFile archivoImagen);
	
	List<PeliculaDTO> buscarPorTitulo(String titulo);
	
	List<PeliculaDTO> obtenerTodos();
	
	PeliculaDTO actualizarPelicula(Integer id, String movie, MultipartFile archivoImagen) throws JsonMappingException, JsonProcessingException, IOException;
	
	HashMap<String, Boolean> eliminarPeliculaPorId(Integer id);
	
	
	
	
	
	
	
	
}
