package com.paredesfederico.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.paredesfederico.dto.PeliculaDTO;
import com.paredesfederico.dto.ResumenPeliculaDTO;
import com.paredesfederico.services.IGeneroService;
import com.paredesfederico.services.IPeliculaService;


@RestController
@RequestMapping("api/movies")
public class PeliculaController {

	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private IGeneroService generoService;
	
	@PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE,
			                                  MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<ResumenPeliculaDTO> registrarPelicula (@RequestPart("movie") String movie,
	                                                     @RequestPart("file") List<MultipartFile> files){
		
		ResumenPeliculaDTO resumenPeliculaDTO = peliculaService.registrarPelicula(movie, files.get(0));
		
		
		return new ResponseEntity<>(resumenPeliculaDTO, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/findbytitle/{titulo}")
	public ResponseEntity<List<ResumenPeliculaDTO>> buscarPorTitulo (@PathVariable String titulo){
		
		List<ResumenPeliculaDTO> peliculasResumidas = peliculaService.buscarPorTitulo(titulo);
		
		return ResponseEntity.ok(peliculasResumidas);	
	}
	
	@GetMapping("/findbygenre/{genero}")
	public ResponseEntity<List<ResumenPeliculaDTO>> buscarPorGenero (@PathVariable String genero){
		
		List<ResumenPeliculaDTO> peliculasResumidas = generoService.obtenerPorGenero(genero);	 		
		
       return  new ResponseEntity<>(peliculasResumidas, HttpStatus.ACCEPTED);		
	
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<ResumenPeliculaDTO>> obtenerTodasLasPeliculas(){
		
		List<ResumenPeliculaDTO> peliculasResumidas = peliculaService.obtenerTodos();
		
		return new ResponseEntity<>(peliculasResumidas, HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarPeliculaPorId(@PathVariable Integer id){
		
		HashMap<String, Boolean> response = peliculaService.eliminarPeliculaPorId(id);
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping(value = "/update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})
public ResponseEntity<PeliculaDTO> actualizarrPelicula (@PathVariable Integer id, @RequestPart("movie") String movie,
                       @RequestPart("file") List<MultipartFile> files) throws JsonMappingException, JsonProcessingException, IOException{
		
    PeliculaDTO peliculaDTO = peliculaService.actualizarPelicula(id, movie, files.get(0));


     return new ResponseEntity<>(peliculaDTO, HttpStatus.ACCEPTED);
}
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}