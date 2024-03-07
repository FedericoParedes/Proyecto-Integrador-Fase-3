package com.paredesfederico.services.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.ResumenPeliculaDTO;
import com.paredesfederico.dto.mappers.PeliculaMapper;
import com.paredesfederico.entidades.Pelicula;
import com.paredesfederico.repository.IPeliculaRepository;
import com.paredesfederico.services.IPeliculaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PeliculaServiceImpl implements IPeliculaService {

	private PeliculaMapper peliculaMapper;
	
	private IPeliculaRepository peliculaRepository;
	
	@Override
	public ResumenPeliculaDTO registrarPelicula(String movie, MultipartFile archivoImagen) {
		
		ResumenPeliculaDTO resumenPeliculaDTO = new ResumenPeliculaDTO();
		
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
			try {
				peliculaDTO = objectMapper.readValue(movie, PeliculaDTO.class);
				
				peliculaDTO.setImagenPelicula(archivoImagen.getBytes());
				
				Pelicula objetoPelicula = peliculaMapper.peliculaDTOtoPelicula(peliculaDTO);
				
				
				Pelicula peliculaRegistrada = peliculaRepository.save(objetoPelicula);
				
				resumenPeliculaDTO = peliculaMapper.peliculaToResumenPeliculaDTO(peliculaRegistrada);
				
				
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated catch block
            catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		// TODO Auto-generated method stub
		return resumenPeliculaDTO;
	}

}
