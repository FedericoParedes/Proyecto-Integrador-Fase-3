package com.paredesfederico.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.ResumenPeliculaDTO;

public interface IPeliculaService {

	ResumenPeliculaDTO registrarPelicula (String movie, MultipartFile archivoImagen);
	
	List<PeliculaDTO> buscarPorTitulo(String titulo);
	
}
