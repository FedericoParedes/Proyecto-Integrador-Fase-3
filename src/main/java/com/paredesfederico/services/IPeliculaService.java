package com.paredesfederico.services;

import org.springframework.web.multipart.MultipartFile;

import com.paredesfederico.dto.ResumenPeliculaDTO;

public interface IPeliculaService {

	ResumenPeliculaDTO registrarPelicula (String movie, MultipartFile archivoImagen);
	
	
}
