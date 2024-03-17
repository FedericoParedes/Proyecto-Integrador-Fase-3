package com.paredesfederico.peliculas;

import static org.assertj.core.api.Assertions.assertThat;

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
public class ConsultaPorTituloTest {

	@Autowired
	private IGeneroRepository generoRepository;
	
	@Autowired
	private IPeliculaRepository peliculaRepository;
	
    @Autowired
	private MapperFiles mapperFiles;
	
	
	@Test
	public void validarConsultaPorTitulo() throws IOException {
		
		String[] paths = {"./resources/TheLovelyBones.jpg","./resources/VanillaSky.jpg","./resources/Orphan.jpg",
				"./resources/ResidentEvil2.jpg","./resources/ResidentEvil4.jpg"};
		
		String[] urls = {"https://www.imdb.com/title/tt0380510/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_the%2520lovely",
				"https://www.imdb.com/title/tt0259711/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_vanilla%2520s",
				"https://www.imdb.com/title/tt1148204/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_orphan",
				"https://www.imdb.com/title/tt0318627/?ref_=fn_al_tt_4",
				"https://www.imdb.com/title/tt1220634/?ref_=fn_al_tt_2"};
		
		String[] fileNames = {"TheLovelyBones.jpg","VanillaSky.jpg","Orphan.jpg","ResidentEvil2.jpg","ResidentEvil4.jpg"};
		
		
		String[] genres = {"Drama","Fantasía","Misterio","Terror","Romance","Accion","Aventura","Historia",
				"Ciencia Ficción","Suspenso"};
		String[] titles = {"Desde Mi Cielo","Vanilla Sky","La Huerfana","Resident Evil 2","Resident Evil 4"};
		
		List<Genero> genreObjects = new ArrayList<>();
		
		for(int i=0;i<genres.length;i++) {
			
			Genero genero = new Genero();
			
			genero.setNombreGenero(genres[i]);
			
			Genero generoGuardado = generoRepository.save(genero);
			
			genreObjects.add(generoGuardado);
			
			
		}
		
		
		for(int i=0;i<titles.length;i++) {
			
			Pelicula pelicula = new Pelicula();
			
			List<Genero> generos = new ArrayList<>();

			
			pelicula.setTitulo(titles[i]);
			
			if(pelicula.getTitulo().startsWith("D")){
									
				generos.add(genreObjects.get(0));
				
				generos.add(genreObjects.get(1));
		
				pelicula.setGeneros(generos);
				
				
			}else if(pelicula.getTitulo().startsWith("V")) {
				
               generos.add(genreObjects.get(0));
               
               generos.add(genreObjects.get(1));

               generos.add(genreObjects.get(4));

				
				pelicula.setGeneros(generos);

				
				
			}else if(pelicula.getTitulo().startsWith("L")) {
					
				generos.add(genreObjects.get(2));
				
	            generos.add(genreObjects.get(3));
	            
	            generos.add(genreObjects.get(9));
	
				pelicula.setGeneros(generos);

				
			} else {
				
                generos.add(genreObjects.get(3));
				
	            generos.add(genreObjects.get(5));
	
				pelicula.setGeneros(generos);
						
			}
			
			pelicula.setUrlWeb(urls[i]);
			
			ImagenPelicula imagenPelicula = new ImagenPelicula();

			imagenPelicula.setNombreArchivo(fileNames[i]);
			
			imagenPelicula.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream(paths[i])));
			
			pelicula.setImagenPelicula(imagenPelicula);
			
			Pelicula peliculaGuardada = peliculaRepository.save(pelicula);
			
		}
		
		List<Pelicula> peliculasGuardadas = peliculaRepository.findAll();
		
		List<Pelicula> peliculasBuscadasPorTitulo = peliculaRepository.findByTituloContainingIgnoreCase("Resident");

        assertThat(peliculasGuardadas.size()).isEqualTo(5);
        
        assertThat(peliculasBuscadasPorTitulo.size()).isEqualTo(2);
        
        /*peliculaRepository.deleteAll();
        
        generoRepository.deleteAll();
        
        assertTrue(peliculaRepository.findAll().isEmpty() && generoRepository.findAll().isEmpty());*/
		
	}
	
	
	
	
	
	
	
	
}
