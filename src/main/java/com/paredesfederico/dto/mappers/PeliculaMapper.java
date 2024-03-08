package com.paredesfederico.dto.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.ResumenPeliculaDTO;
import com.paredesfederico.entidades.Genero;
import com.paredesfederico.entidades.ImagenPelicula;
import com.paredesfederico.entidades.Pelicula;
import com.paredesfederico.repository.IGeneroRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PeliculaMapper {

      private IGeneroRepository generoRepository;

	
	//Mapper careado para convertir un objeto PeliculaDTO a Pelicula
	public Pelicula peliculaDTOtoPelicula(PeliculaDTO peliculaDTO) {
		
		//Creo una instancia de Pelicula llamada pelicula.
		Pelicula pelicula = new Pelicula();
		
		//Tomo el atributo titulo de peliculaDTO y se lo asigno a pelicula.
		pelicula.setTitulo(peliculaDTO.getTitulo());
		
		//Tomo el atributo urlWeb de peliculaDTO y se lo asigno a pelicula.
		pelicula.setUrlWeb(peliculaDTO.getUrlWeb());
		
		//Creo una instancia de ImagenPelicula llamada imagenPelicula.
		ImagenPelicula imagenPelicula = new ImagenPelicula();
		
		//Tomo el atributo nombreImagen de peliculaDTO y se lo asigno a imagenPelicula.
		imagenPelicula.setNombreArchivo(peliculaDTO.getNombreImagen());
		
		//Tomo el atributo imagenPelicula de peliculaDTO y se lo asigno a imagenPelicula.
		imagenPelicula.setImagen(peliculaDTO.getImagenPelicula());
		
		//Tomo el objeto imagenPelicula y se lo asigno a pelicula.
		pelicula.setImagenPelicula(imagenPelicula);
		
		//Creo un arraylist de generos llamado generos
		List<Genero> generos = new ArrayList<>();
		
		//Recoorro con un for el arraylist de generos que tiene como atributo peliculaDTO
		for(String g : peliculaDTO.getGeneros()) {
		/*Por cada elemento del array se realiza una busqueda de genero por nombre.
		 Si el nombre del genero buscado existe en la base de datos, se añade a la
		 lista de generos creada anteriormente.
		 */
		generos.add(generoRepository.findByNombreGenero(g));
		}
		
		//Tomo el arraylist de generos y se lo asigno a pelicula.
		
		pelicula.setGeneros(generos);
		
		//Devuelvo la pelicula
		
		return pelicula;
		
	}
	
	public ResumenPeliculaDTO peliculaToResumenPeliculaDTO(Pelicula pelicula) {
		
		ResumenPeliculaDTO resumenPeliculaDTO = new ResumenPeliculaDTO();
		
		resumenPeliculaDTO.setTitulo(pelicula.getTitulo());
		
		resumenPeliculaDTO.setUrlWeb(pelicula.getUrlWeb());
		
		resumenPeliculaDTO.setNombreImagen(pelicula.getImagenPelicula().getNombreArchivo());
		
		String generosString = pelicula.getGeneros().stream().map(
				g->g.getNombreGenero()).collect(Collectors.joining(" - "));
		
		resumenPeliculaDTO.setStringGeneros(generosString);
		
		return resumenPeliculaDTO;
		
	}
	
	
	public PeliculaDTO peliculaToPeliculaDTO (Pelicula pelicula) {
		
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		
		peliculaDTO.setTitulo(pelicula.getTitulo());
		
		peliculaDTO.setUrlWeb(pelicula.getUrlWeb());
		
		peliculaDTO.setNombreImagen(pelicula.getImagenPelicula().getNombreArchivo());
		
		List<String> stringGeneros = pelicula.getGeneros().stream()
				.map(p-> p.getNombreGenero()).collect(Collectors.toList());
		
		peliculaDTO.setGeneros(stringGeneros);
		
		peliculaDTO.setImagenPelicula(pelicula.getImagenPelicula().getImagen());
		
		return peliculaDTO;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
