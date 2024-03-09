package com.paredesfederico.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.mappers.PeliculaMapper;
import com.paredesfederico.entidades.Genero;
import com.paredesfederico.repository.IGeneroRepository;
import com.paredesfederico.services.IGeneroService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GeneroServiceImpl implements IGeneroService{

	private IGeneroRepository generoRepository;
	
	private PeliculaMapper peliculaMapper;
	
	
	
	
	@Override
	public List<PeliculaDTO> obtenerPorGenero(String genero) {
		// TODO Auto-generated method stub
		
		Genero generoBuscado = generoRepository.findByNombreGenero(genero);
		
		List<PeliculaDTO> peliculas = generoBuscado.getPeliculas().stream()
				.map(p->{
					PeliculaDTO peliculaDTO = peliculaMapper.peliculaToPeliculaDTO(p);
					return peliculaDTO;
				}).collect(Collectors.toList());
		
		return peliculas;
	}

}
