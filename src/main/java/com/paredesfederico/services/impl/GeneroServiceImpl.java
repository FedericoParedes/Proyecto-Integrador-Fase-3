package com.paredesfederico.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.paredesfederico.dto.ResumenPeliculaDTO;
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
	public List<ResumenPeliculaDTO> obtenerPorGenero(String genero) {
		// TODO Auto-generated method stub
		
		Genero generoBuscado = generoRepository.findByNombreGenero(genero);
		
		List<ResumenPeliculaDTO> peliculasResumidas = generoBuscado.getPeliculas().stream()
				.map(p->{
					ResumenPeliculaDTO peliculaResumida = peliculaMapper.peliculaToResumenPeliculaDTO(p);
					return peliculaResumida;
				}).collect(Collectors.toList());
		
		return peliculasResumidas;
	}

}
