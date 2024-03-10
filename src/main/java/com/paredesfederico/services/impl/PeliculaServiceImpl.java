package com.paredesfederico.services.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.ResumenPeliculaDTO;
import com.paredesfederico.dto.mappers.PeliculaMapper;
import com.paredesfederico.entidades.Genero;
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

	@Override
	public List<PeliculaDTO> buscarPorTitulo(String titulo) {
		
		List<Pelicula> peliculas = peliculaRepository.findByTituloContainingIgnoreCase(titulo);
		
		List<PeliculaDTO> peliculasDTO = peliculas.stream()
				.map(p->{ PeliculaDTO peliculaDTO = peliculaMapper.peliculaToPeliculaDTO(p);
				  return peliculaDTO;
				}).collect(Collectors.toList());	
		// TODO Auto-generated method stub
		return peliculasDTO;
	}

	@Override
	public List<PeliculaDTO> obtenerTodos() {
		// TODO Auto-generated method stub
		List<Pelicula> peliculas = peliculaRepository.findAll();
		
		List<PeliculaDTO> peliculasDTO = peliculas.stream()
				.map(p->{
					PeliculaDTO peliculaDTO = peliculaMapper.peliculaToPeliculaDTO(p);
					return peliculaDTO;
					
				}).collect(Collectors.toList());
		
		
		return peliculasDTO;
	}

	@Override
	public PeliculaDTO actualizarPelicula(Integer id, String movie, MultipartFile archivoImagen)  {
		// TODO Auto-generated method stub
				
      Pelicula peliculaPorActualizar =  peliculaRepository.findPeliculaById(id);
		
				
        PeliculaDTO peliculaDTO = new PeliculaDTO();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
			try {
				peliculaDTO = objectMapper.readValue(movie, PeliculaDTO.class);
				
				peliculaDTO.setImagenPelicula(archivoImagen.getBytes());
				
			   Pelicula peliculaActualizada = peliculaMapper.peliculaDTOtoPelicula(peliculaDTO);
			   
			   peliculaPorActualizar.setId(id);
			   			   				
			   peliculaPorActualizar.setTitulo(peliculaActualizada.getTitulo());
			   
			   peliculaPorActualizar.setUrlWeb(peliculaActualizada.getUrlWeb());
			   
			   List<Genero> generos = peliculaActualizada.getGeneros();
			   
			   peliculaPorActualizar.setGeneros(generos);
			   
			   peliculaPorActualizar.getImagenPelicula().setId(id);;
			   
			   peliculaPorActualizar.getImagenPelicula().setNombreArchivo(peliculaActualizada.getImagenPelicula().getNombreArchivo());
			   
			   peliculaPorActualizar.getImagenPelicula().setImagen(peliculaActualizada.getImagenPelicula().getImagen());			   
			   
		   
			    peliculaRepository.save(peliculaPorActualizar);
			    
			    
			    
				
				
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
			
			return peliculaDTO;
		
	}

	@Override
	public HashMap<String, Boolean> eliminarPeliculaPorId(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Pelicula> peliculaAEliminar = peliculaRepository.findById(id);
		
		HashMap<String, Boolean> estadoPeliculaElminada = new HashMap<>();

		
		if(peliculaAEliminar.isPresent()) {
			
			peliculaRepository.deleteById(id);
			
			estadoPeliculaElminada.put("La pelicula ha sido eliminada", true);
		
		}else {
			
			estadoPeliculaElminada.put("La pelicula que desea eliminar no existe", false);
			
		}
		
		return estadoPeliculaElminada;
		
		
	}


	
}
