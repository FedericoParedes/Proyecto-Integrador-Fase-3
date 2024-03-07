package com.paredesfederico.peliculas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paredesfederico.entidades.Genero;
import com.paredesfederico.entidades.ImagenPelicula;
import com.paredesfederico.entidades.Pelicula;
import com.paredesfederico.model.MapperFiles;
import com.paredesfederico.repository.IGeneroRepository;
import com.paredesfederico.repository.IPeliculaRepository;


@SpringBootTest
public class RegistroPeliculaTest {

	@Autowired
	private IPeliculaRepository peliculaRepository;
	
	@Autowired
	private IGeneroRepository generoRepository;
	
	@Autowired
	private MapperFiles mapperFiles;
	
	@Test
	public void validarRegistroPelicula () throws IOException {
		
		Genero genero = new Genero();
		
		genero.setNombreGenero("Drama");
		
		Genero genero1 = generoRepository.save(genero);
		
        genero = new Genero();
		
		genero.setNombreGenero("Fantasía");
		
		Genero genero2 = generoRepository.save(genero);

		Pelicula pelicula = new Pelicula();
		
		pelicula.setTitulo("Desde Mi Cielo");
		
		pelicula.setUrlWeb("https://www.imdb.com/title/tt0380510/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_the%2520lovel");
		
		List<Genero> generos = new ArrayList<>();
		
		generos.add(genero1);
		
		generos.add(genero2);
		
		pelicula.setGeneros(generos);
		
		
		ImagenPelicula imagenPelicula = new ImagenPelicula();
		
		imagenPelicula.setNombreArchivo("TheLovelyBones.jpg");
		
		imagenPelicula.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/TheLovelyBones.jpg")));
		
		
		pelicula.setImagenPelicula(imagenPelicula);
		
	    Pelicula peliculaGuardada = peliculaRepository.save(pelicula);
	    
	    List<Pelicula> peliculas = peliculaRepository.findAll();
	    
	    assertTrue(!peliculas.isEmpty() && peliculas.get(0).getId().equals(peliculaGuardada.getId()));
		
		peliculaRepository.deleteAll();
		
		generoRepository.deleteAll();
		
		assertTrue(peliculaRepository.findAll().isEmpty() && generoRepository.findAll().isEmpty());
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
