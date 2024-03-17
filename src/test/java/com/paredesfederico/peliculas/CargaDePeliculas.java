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
public class CargaDePeliculas {
     
	@Autowired
	private IPeliculaRepository peliculaRepository;
	
	@Autowired
	private IGeneroRepository generoRepository;
	
	@Autowired
	private MapperFiles mapperFiles;
	
	
	@Test
	public void cargarPeliculas () throws IOException {
		
		List<Genero> generos = new ArrayList<>();
		
		String[] nombresGeneros = {"Accion","Aventura","Ciencia Ficcion","Comedia","Drama","Terror","Fantasia",
				"Crimen","Misterio","Animacion","Suspenso","Biografia","Romance","Historia","Belico"};
		
		for(int i=0;i<15;i++) {
			
			Genero genero = new Genero();
			
			genero.setNombreGenero(nombresGeneros[i]);
			
			generos.add(genero);
			
		}
		
		for(Genero g : generos) {
			generoRepository.save(g);
		}
		
		assertThat(generoRepository.findAll().size()).isEqualTo(15);
		
		//---------------------------------------------------------------------------------------------------------
		
		List<Genero> generosGuardados = generoRepository.findAll();
				
		List<Pelicula> peliculasAGuardar = new ArrayList<>();
		
		Pelicula pelicula1 = new Pelicula();
		
		pelicula1.setTitulo("Al Filo Del Mañana");
		
		pelicula1.setUrlWeb("https://www.imdb.com/title/tt1631867/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_al%2520filo%2520del%2520ma%25C3%25B1ana");
		
		ImagenPelicula imagenPelicula = new ImagenPelicula();
		
		imagenPelicula.setNombreArchivo("AlFiloDelMañana.jpg");
		
		imagenPelicula.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/AlFiloDelMañana.jpg")));
		
		pelicula1.setImagenPelicula(imagenPelicula);
		
	    List<Genero> generosPelicula1 = new ArrayList<>();
	    
	    generosPelicula1.add(generosGuardados.get(0));
	    
	    generosPelicula1.add(generosGuardados.get(1));
	    
	    generosPelicula1.add(generosGuardados.get(2));
	    
	    pelicula1.setGeneros(generosPelicula1);
	    
	    peliculasAGuardar.add(pelicula1);
	    
	    
        Pelicula pelicula2 = new Pelicula();
		
		pelicula2.setTitulo("Amigos Intocables");
		
		pelicula2.setUrlWeb("https://www.imdb.com/title/tt1675434/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_amigos%2520intocables");
		
		ImagenPelicula imagenPelicula2 = new ImagenPelicula();
		
		imagenPelicula2.setNombreArchivo("AmigosIntocables.jpg");
		
		imagenPelicula2.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/AmigosIntocables.jpg")));
		
		pelicula2.setImagenPelicula(imagenPelicula2);
		
	    List<Genero> generosPelicula2 = new ArrayList<>();
	    
	    generosPelicula2.add(generosGuardados.get(3));
	    
	    generosPelicula2.add(generosGuardados.get(4));
	    	    
	    pelicula2.setGeneros(generosPelicula2);
	    
	    peliculasAGuardar.add(pelicula2);
	    
 Pelicula pelicula3 = new Pelicula();
		
		pelicula3.setTitulo("¿A Quien Ama Gilbert Grape?");
		
		pelicula3.setUrlWeb("https://www.imdb.com/title/tt0108550/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_a%2520quien%2520ama%2520gilbert%2520grape");
		
		ImagenPelicula imagenPelicula3 = new ImagenPelicula();
		
		imagenPelicula3.setNombreArchivo("AQuienAmaGilbertGrape.jpg");
		
		imagenPelicula3.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/AQuienAmaGilbertGrape.jpg")));
		
		pelicula3.setImagenPelicula(imagenPelicula3);
		
	    List<Genero> generosPelicula3 = new ArrayList<>();
	    
	    generosPelicula3.add(generosGuardados.get(4));
	    	    	    
	    pelicula3.setGeneros(generosPelicula3);
	    
	    peliculasAGuardar.add(pelicula3);
	    
       Pelicula pelicula4 = new Pelicula();
		
		pelicula4.setTitulo("Arrastrame Al Infierno");
		
		pelicula4.setUrlWeb("https://www.imdb.com/title/tt1127180/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_arrastrame%2520al%2520infierno");
		
		ImagenPelicula imagenPelicula4 = new ImagenPelicula();
		
		imagenPelicula4.setNombreArchivo("ArrastrameAlInfierno.jpg");
		
		imagenPelicula4.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ArrastrameAlInfierno.jpg")));
		
		pelicula4.setImagenPelicula(imagenPelicula4);
		
	    List<Genero> generosPelicula4 = new ArrayList<>();
	    	    
	    generosPelicula4.add(generosGuardados.get(5));
	    	    
	    pelicula4.setGeneros(generosPelicula4);
	    
	    peliculasAGuardar.add(pelicula4);
	    
        Pelicula pelicula5 = new Pelicula();
		
		pelicula5.setTitulo("Avatar");
		
		pelicula5.setUrlWeb("https://www.imdb.com/title/tt0499549/?ref_=fn_al_tt_3");
		
		ImagenPelicula imagenPelicula5 = new ImagenPelicula();
		
		imagenPelicula5.setNombreArchivo("Avatar.jpg");
		
		imagenPelicula5.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Avatar.jpg")));
		
		pelicula5.setImagenPelicula(imagenPelicula5);
		
	    List<Genero> generosPelicula5 = new ArrayList<>();
	    
	    generosPelicula5.add(generosGuardados.get(0));
	    
	    generosPelicula5.add(generosGuardados.get(1));
	    
	    generosPelicula5.add(generosGuardados.get(6));
    	    
	    pelicula5.setGeneros(generosPelicula5);
	    
	    peliculasAGuardar.add(pelicula5);
	    
        Pelicula pelicula6 = new Pelicula();
		
		pelicula6.setTitulo("Bajo Amenaza");
		
		pelicula6.setUrlWeb("https://www.imdb.com/title/tt0340163/?ref_=nv_sr_srsg_3_tt_8_nm_0_q_bajo%2520amenaza");
		
		ImagenPelicula imagenPelicula6 = new ImagenPelicula();
		
		imagenPelicula6.setNombreArchivo("BajoAmenaza.jpg");
		
		imagenPelicula6.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/BajoAmenaza.jpg")));
		
		pelicula6.setImagenPelicula(imagenPelicula6);
		
	    List<Genero> generosPelicula6 = new ArrayList<>();
	    
	    generosPelicula6.add(generosGuardados.get(0));
	    
	    generosPelicula6.add(generosGuardados.get(4));
	    
	    generosPelicula6.add(generosGuardados.get(7));
    	    
	    pelicula6.setGeneros(generosPelicula6);
	    
	    peliculasAGuardar.add(pelicula6);
	    
       Pelicula pelicula7 = new Pelicula();
		
		pelicula7.setTitulo("Blade Runner");
		
		pelicula7.setUrlWeb("https://www.imdb.com/title/tt1856101/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_blade%2520runner");
		
		ImagenPelicula imagenPelicula7 = new ImagenPelicula();
		
		imagenPelicula7.setNombreArchivo("BladeRunner.jpg");
		
		imagenPelicula7.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/BladeRunner.jpg")));
		
		pelicula7.setImagenPelicula(imagenPelicula7);
		
	    List<Genero> generosPelicula7 = new ArrayList<>();
	    
	    generosPelicula7.add(generosGuardados.get(0));
	    
	    generosPelicula7.add(generosGuardados.get(4));
	    
	    generosPelicula7.add(generosGuardados.get(8));
	    	    
	    pelicula7.setGeneros(generosPelicula7);
	    
	    peliculasAGuardar.add(pelicula7);
     
 Pelicula pelicula8 = new Pelicula();
		
		pelicula8.setTitulo("Buscando A Nemo");
		
		pelicula8.setUrlWeb("https://www.imdb.com/title/tt0266543/?ref_=nv_sr_srsg_0_tt_5_nm_0_q_buscando%2520a%2520nemo");
		
		ImagenPelicula imagenPelicula8 = new ImagenPelicula();
		
		imagenPelicula8.setNombreArchivo("BuscandoANemo.jpeg");
		
		imagenPelicula8.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/BuscandoANemo.jpeg")));
		
		pelicula8.setImagenPelicula(imagenPelicula8);
		
	    List<Genero> generosPelicula8 = new ArrayList<>();
	    
	    generosPelicula8.add(generosGuardados.get(9));
	    
	    generosPelicula8.add(generosGuardados.get(1));
	    
	    generosPelicula8.add(generosGuardados.get(3));
	    	    
	    pelicula8.setGeneros(generosPelicula8);
	    
	    peliculasAGuardar.add(pelicula8);
  	    
 Pelicula pelicula9 = new Pelicula();
		
		pelicula9.setTitulo("Busqueda Implacable");
		
		pelicula9.setUrlWeb("https://www.imdb.com/title/tt0936501/?ref_=nv_sr_srsg_0_tt_5_nm_0_q_buscqueda%2520implacable");
		
		ImagenPelicula imagenPelicula9 = new ImagenPelicula();
		
		imagenPelicula9.setNombreArchivo("BusquedaImplacable.jpg");
		
		imagenPelicula9.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/BusquedaImplacable.jpg")));
		
		pelicula9.setImagenPelicula(imagenPelicula9);
		
	    List<Genero> generosPelicula9 = new ArrayList<>();
	    
	    generosPelicula9.add(generosGuardados.get(0));
	    
	    generosPelicula9.add(generosGuardados.get(7));
	    
	    generosPelicula9.add(generosGuardados.get(10));
	    	    
	    pelicula9.setGeneros(generosPelicula9);
	    
	    peliculasAGuardar.add(pelicula9);
	    
 Pelicula pelicula10 = new Pelicula();
		
		pelicula10.setTitulo("Capitan Phillips");
		
		pelicula10.setUrlWeb("https://www.imdb.com/title/tt1535109/?ref_=nv_sr_srsg_0_tt_4_nm_4_q_capitan%2520phillips");
		
		ImagenPelicula imagenPelicula10 = new ImagenPelicula();
		
		imagenPelicula10.setNombreArchivo("CapitanPhillips.jpg");
		
		imagenPelicula10.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/CapitanPhillips.jpg")));
		
		pelicula10.setImagenPelicula(imagenPelicula10);
		
	    List<Genero> generosPelicula10 = new ArrayList<>();
	    
	    generosPelicula10.add(generosGuardados.get(0));
	    
	    generosPelicula10.add(generosGuardados.get(11));
	    
	    generosPelicula10.add(generosGuardados.get(7));
	    	    
	    pelicula10.setGeneros(generosPelicula10);
	    
	    peliculasAGuardar.add(pelicula10);
   
        Pelicula pelicula11 = new Pelicula();
		
		pelicula11.setTitulo("Carrie");
		
		pelicula11.setUrlWeb("https://www.imdb.com/title/tt1939659/?ref_=fn_al_tt_2");
		
		ImagenPelicula imagenPelicula11 = new ImagenPelicula();
		
		imagenPelicula11.setNombreArchivo("Carrie2remaster.jpg");
		
		imagenPelicula11.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Carrie2remaster.jpg")));
		
		pelicula11.setImagenPelicula(imagenPelicula11);
		
	    List<Genero> generosPelicula11 = new ArrayList<>();
	    
	    generosPelicula11.add(generosGuardados.get(4));
	    
	    generosPelicula11.add(generosGuardados.get(5));
	    
	    generosPelicula11.add(generosGuardados.get(10));
	    	    
	    pelicula11.setGeneros(generosPelicula11);
	    
	    peliculasAGuardar.add(pelicula11);
	    
     Pelicula pelicula12 = new Pelicula();
		
		pelicula12.setTitulo("Los Angeles de Charlie");
		
		pelicula12.setUrlWeb("https://www.imdb.com/title/tt0160127/?ref_=nv_sr_srsg_3_tt_4_nm_4_q_los%2520angeles%2520de%2520charlie");
		
		ImagenPelicula imagenPelicula12 = new ImagenPelicula();
		
		imagenPelicula12.setNombreArchivo("Charlie'sAngels.jpg");
		
		imagenPelicula12.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Charlie'sAngels.jpg")));
		
		pelicula12.setImagenPelicula(imagenPelicula12);
		
	    List<Genero> generosPelicula12 = new ArrayList<>();
	    
	    generosPelicula12.add(generosGuardados.get(0));
	    
	    generosPelicula12.add(generosGuardados.get(1));
	    
	    generosPelicula12.add(generosGuardados.get(3));
	        	    
	    pelicula12.setGeneros(generosPelicula12);
	    
	    peliculasAGuardar.add(pelicula12);
   
 Pelicula pelicula13 = new Pelicula();
		
		pelicula13.setTitulo("Chicas Pesadas");
		
		pelicula13.setUrlWeb("https://www.imdb.com/title/tt0377092/?ref_=nv_sr_srsg_3_tt_4_nm_0_q_chicas%2520pesadas");
		
		ImagenPelicula imagenPelicula13 = new ImagenPelicula();
		
		imagenPelicula13.setNombreArchivo("ChicasPesadas.jpg");
		
		imagenPelicula13.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ChicasPesadas.jpg")));
		
		pelicula13.setImagenPelicula(imagenPelicula13);
		
	    List<Genero> generosPelicula13 = new ArrayList<>();
	    
	    generosPelicula13.add(generosGuardados.get(3));
	    	    	    
	    pelicula13.setGeneros(generosPelicula13);
	    
	    peliculasAGuardar.add(pelicula13);
	    
 Pelicula pelicula14 = new Pelicula();
		
		pelicula14.setTitulo("Cincuenta Sombras De Grey");
		
		pelicula14.setUrlWeb("https://www.imdb.com/title/tt2322441/?ref_=nv_sr_srsg_0_tt_5_nm_0_q_cincuenta%2520sombras");
		
		ImagenPelicula imagenPelicula14 = new ImagenPelicula();
		
		imagenPelicula14.setNombreArchivo("CincuentaSombrasDeGrey.jpg");
		
		imagenPelicula14.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/CincuentaSombrasDeGrey.jpg")));
		
		pelicula14.setImagenPelicula(imagenPelicula14);
		
	    List<Genero> generosPelicula14 = new ArrayList<>();
	    
	    generosPelicula14.add(generosGuardados.get(4));
	    
	    generosPelicula14.add(generosGuardados.get(12));
	    
	    generosPelicula14.add(generosGuardados.get(10));
	    	    
	    pelicula14.setGeneros(generosPelicula14);
	    
	    peliculasAGuardar.add(pelicula14);
	    
 Pelicula pelicula15 = new Pelicula();
		
		pelicula15.setTitulo("Click");
		
		pelicula15.setUrlWeb("https://www.imdb.com/title/tt0389860/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_click");
		
		ImagenPelicula imagenPelicula15 = new ImagenPelicula();
		
		imagenPelicula15.setNombreArchivo("Click.jpg");
		
		imagenPelicula15.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Click.jpg")));
		
		pelicula15.setImagenPelicula(imagenPelicula15);
		
	    List<Genero> generosPelicula15 = new ArrayList<>();
	    
	    generosPelicula15.add(generosGuardados.get(3));
	    
	    generosPelicula15.add(generosGuardados.get(4));
	    
	    generosPelicula15.add(generosGuardados.get(6));
	    	    
	    pelicula15.setGeneros(generosPelicula15);
	    
	    peliculasAGuardar.add(pelicula15);
    
 Pelicula pelicula16 = new Pelicula();
		
		pelicula16.setTitulo("Closer");
		
		pelicula16.setUrlWeb("https://www.imdb.com/title/tt0376541/?ref_=nv_sr_srsg_1_tt_7_nm_0_q_closer");
		
		ImagenPelicula imagenPelicula16 = new ImagenPelicula();
		
		imagenPelicula16.setNombreArchivo("Closer.jpg");
		
		imagenPelicula16.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Closer.jpg")));
		
		pelicula16.setImagenPelicula(imagenPelicula16);
		
	    List<Genero> generosPelicula16 = new ArrayList<>();
	    
	    generosPelicula16.add(generosGuardados.get(4));
	    
	    generosPelicula16.add(generosGuardados.get(12));
	    	    
	    pelicula16.setGeneros(generosPelicula16);
	    
	    peliculasAGuardar.add(pelicula16);

 Pelicula pelicula17 = new Pelicula();
		
		pelicula17.setTitulo("Colonia Dignidad");
		
		pelicula17.setUrlWeb("https://www.imdb.com/title/tt4005402/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_colonia");
		
		ImagenPelicula imagenPelicula17 = new ImagenPelicula();
		
		imagenPelicula17.setNombreArchivo("ColoniaDignidad.jpg");
		
		imagenPelicula17.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ColoniaDignidad.jpg")));
		
		pelicula17.setImagenPelicula(imagenPelicula17);
		
	    List<Genero> generosPelicula17 = new ArrayList<>();
	    
	    generosPelicula17.add(generosGuardados.get(11));
	    
	    generosPelicula17.add(generosGuardados.get(4));
	    
	    generosPelicula17.add(generosGuardados.get(13));
	    	    
	    pelicula17.setGeneros(generosPelicula17);
	    
	    peliculasAGuardar.add(pelicula17);

	    
 Pelicula pelicula18 = new Pelicula();
		
		pelicula18.setTitulo("Como Si Fuera La Primera Vez");
		
		pelicula18.setUrlWeb("https://www.imdb.com/title/tt0343660/?ref_=nv_sr_srsg_2_tt_2_nm_0_q_como%2520si%2520fuera%2520la%2520primera%2520vex");
		
		ImagenPelicula imagenPelicula18 = new ImagenPelicula();
		
		imagenPelicula18.setNombreArchivo("ComoSiFueraLaPrimeraVez.jpg");
		
		imagenPelicula18.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ComoSiFueraLaPrimeraVez.jpg")));
		
		pelicula18.setImagenPelicula(imagenPelicula18);
		
	    List<Genero> generosPelicula18 = new ArrayList<>();
	    
	    generosPelicula18.add(generosGuardados.get(3));
	    
	    generosPelicula18.add(generosGuardados.get(4));
	    
	    generosPelicula18.add(generosGuardados.get(12));
	    	    
	    pelicula18.setGeneros(generosPelicula18);
	    
	    peliculasAGuardar.add(pelicula18);

	   
 Pelicula pelicula19 = new Pelicula();
		
		pelicula19.setTitulo("Crepusculo");
		
		pelicula19.setUrlWeb("https://www.imdb.com/title/tt1099212/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_crepusculo");
		
		ImagenPelicula imagenPelicula19 = new ImagenPelicula();
		
		imagenPelicula19.setNombreArchivo("Crepusculo.jpg");
		
		imagenPelicula19.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Crepusculo.jpg")));
		
		pelicula19.setImagenPelicula(imagenPelicula19);
		
	    List<Genero> generosPelicula19 = new ArrayList<>();
	    
	    generosPelicula19.add(generosGuardados.get(4));
	    
	    generosPelicula19.add(generosGuardados.get(6));
	    
	    generosPelicula19.add(generosGuardados.get(12));
	    	    
	    pelicula19.setGeneros(generosPelicula19);
	    
	    peliculasAGuardar.add(pelicula19);
	
	    
 Pelicula pelicula20 = new Pelicula();
		
		pelicula20.setTitulo("De La Cuna A La Tumba");
		
		pelicula20.setUrlWeb("https://www.imdb.com/title/tt0306685/?ref_=fn_al_tt_1");
		
		ImagenPelicula imagenPelicula20 = new ImagenPelicula();
		
		imagenPelicula20.setNombreArchivo("DeLaCunaALaTumba.jpg");
		
		imagenPelicula20.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/DeLaCunaALaTumba.jpg")));
		
		pelicula20.setImagenPelicula(imagenPelicula20);
		
	    List<Genero> generosPelicula20 = new ArrayList<>();
	    
	    generosPelicula20.add(generosGuardados.get(0));
	    
	    generosPelicula20.add(generosGuardados.get(7));
	    
	    generosPelicula20.add(generosGuardados.get(4));
	    	    
	    pelicula20.setGeneros(generosPelicula20);
	    
	    peliculasAGuardar.add(pelicula20);
	    
        Pelicula pelicula21 = new Pelicula();
		
		pelicula21.setTitulo("Destino Final 2");
		
		pelicula21.setUrlWeb("https://www.imdb.com/title/tt0195714/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_destino%2520final%25202");
		
		ImagenPelicula imagenPelicula21 = new ImagenPelicula();
		
		imagenPelicula21.setNombreArchivo("DestinoFina2.jpg");
		
		imagenPelicula21.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/DestinoFinal2.jpg")));
		
		pelicula21.setImagenPelicula(imagenPelicula21);
		
	    List<Genero> generosPelicula21 = new ArrayList<>();
	    
	    generosPelicula21.add(generosGuardados.get(5));
	    
	    generosPelicula21.add(generosGuardados.get(10));
	    	    
	    pelicula21.setGeneros(generosPelicula21);
	    
	    peliculasAGuardar.add(pelicula21);
   
 Pelicula pelicula22 = new Pelicula();
		
		pelicula22.setTitulo("Dia De Entrenamiento");
		
		pelicula22.setUrlWeb("https://www.imdb.com/title/tt0139654/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_dia%2520de%2520entrenamineto");
		
		ImagenPelicula imagenPelicula22 = new ImagenPelicula();
		
		imagenPelicula22.setNombreArchivo("DiaDeEntrenamiento.jpg");
		
		imagenPelicula22.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/DiaDeEntrenamiento.jpg")));
		
		pelicula22.setImagenPelicula(imagenPelicula22);
		
	    List<Genero> generosPelicula22 = new ArrayList<>();
	    
	    generosPelicula22.add(generosGuardados.get(7));
	    
	    generosPelicula22.add(generosGuardados.get(4));
	    
	    generosPelicula22.add(generosGuardados.get(10));
	    	    
	    pelicula22.setGeneros(generosPelicula22);
	    
	    peliculasAGuardar.add(pelicula22);
    
 Pelicula pelicula23 = new Pelicula();
		
		pelicula23.setTitulo("Dune");
		
		pelicula23.setUrlWeb("https://www.imdb.com/title/tt1160419/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_dune");
		
		ImagenPelicula imagenPelicula23 = new ImagenPelicula();
		
		imagenPelicula23.setNombreArchivo("Dune.jpg");
		
		imagenPelicula23.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Dune.jpg")));
		
		pelicula23.setImagenPelicula(imagenPelicula23);
		
	    List<Genero> generosPelicula23 = new ArrayList<>();
	    
	    generosPelicula23.add(generosGuardados.get(0));
	    
	    generosPelicula23.add(generosGuardados.get(1));
	    
	    generosPelicula23.add(generosGuardados.get(4));
	    	    
	    pelicula23.setGeneros(generosPelicula23);
	    
	    peliculasAGuardar.add(pelicula23);
	    
 Pelicula pelicula24 = new Pelicula();
		
		pelicula24.setTitulo("El Codigo Enigma");
		
		pelicula24.setUrlWeb("https://www.imdb.com/title/tt2084970/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_el%2520codigo%2520enigma");
		
		ImagenPelicula imagenPelicula24 = new ImagenPelicula();
		
		imagenPelicula24.setNombreArchivo("ElCodigoEnigma.jpg");
		
		imagenPelicula24.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElCodigoEnigma.jpg")));
		
		pelicula24.setImagenPelicula(imagenPelicula24);
		
	    List<Genero> generosPelicula24 = new ArrayList<>();
	    
	    generosPelicula24.add(generosGuardados.get(11));
	    
	    generosPelicula24.add(generosGuardados.get(4));
	    
	    generosPelicula24.add(generosGuardados.get(10));
	    	    
	    pelicula24.setGeneros(generosPelicula24);
	    
	    peliculasAGuardar.add(pelicula24);
	    
 Pelicula pelicula25 = new Pelicula();
		
		pelicula25.setTitulo("El Coleccionista");
		
		pelicula25.setUrlWeb("https://www.imdb.com/title/tt0844479/?ref_=nv_sr_srsg_1_tt_8_nm_0_q_el%2520coleccionista");
		
		ImagenPelicula imagenPelicula25 = new ImagenPelicula();
		
		imagenPelicula25.setNombreArchivo("ElColeccionista.jpg");
		
		imagenPelicula25.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElColeccionista.jpg")));
		
		pelicula25.setImagenPelicula(imagenPelicula25);
		
	    List<Genero> generosPelicula25 = new ArrayList<>();
	    
	    generosPelicula25.add(generosGuardados.get(5));
	    
	    generosPelicula25.add(generosGuardados.get(10));
	    	    
	    pelicula25.setGeneros(generosPelicula25);
	    
	    peliculasAGuardar.add(pelicula25);
	    
 Pelicula pelicula26 = new Pelicula();
		
		pelicula26.setTitulo("El Curioso Caso De Benjamin Button");
		
		pelicula26.setUrlWeb("https://www.imdb.com/title/tt0421715/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_el%2520curioso%2520caso%2520de%2520benjamin");
		
		ImagenPelicula imagenPelicula26 = new ImagenPelicula();
		
		imagenPelicula26.setNombreArchivo("ElCuriosoCasoDeBenjaminButton.jpg");
		
		imagenPelicula26.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElCuriosoCasoDeBenjaminButton.jpg")));
		
		pelicula26.setImagenPelicula(imagenPelicula26);
		
	    List<Genero> generosPelicula26 = new ArrayList<>();
	    
	    generosPelicula26.add(generosGuardados.get(4));
	    
	    generosPelicula26.add(generosGuardados.get(6));
	    
	    generosPelicula26.add(generosGuardados.get(12));
	    	    
	    pelicula26.setGeneros(generosPelicula26);
	    
	    peliculasAGuardar.add(pelicula26);
	   
 Pelicula pelicula27 = new Pelicula();
		
		pelicula27.setTitulo("El Dia Despues De Mañana");
		
		pelicula27.setUrlWeb("https://www.imdb.com/title/tt0319262/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520dia%2520despues%2520de%2520ma%25C3%25B1ana");
		
		ImagenPelicula imagenPelicula27 = new ImagenPelicula();
		
		imagenPelicula27.setNombreArchivo("ElDiaDespuesDeMañana.jpeg");
		
		imagenPelicula27.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElDiaDespuesDeMañana.jpeg")));
		
		pelicula27.setImagenPelicula(imagenPelicula27);
		
	    List<Genero> generosPelicula27 = new ArrayList<>();
	    
	    generosPelicula27.add(generosGuardados.get(0));
	    
	    generosPelicula27.add(generosGuardados.get(1));
	    
	    generosPelicula27.add(generosGuardados.get(2));
	    	    
	    pelicula27.setGeneros(generosPelicula27);
	    
	    peliculasAGuardar.add(pelicula27);
	   
 Pelicula pelicula28 = new Pelicula();
		
		pelicula28.setTitulo("El Dia Que La Tierra Se Detuvo");
		
		pelicula28.setUrlWeb("https://www.imdb.com/title/tt0970416/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520dia%2520que%2520la%2520tierra%2520se%2520detu");
		
		ImagenPelicula imagenPelicula28 = new ImagenPelicula();
		
		imagenPelicula28.setNombreArchivo("ElDiaQueLaTierraSeDetuvo.jpg");
		
		imagenPelicula28.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElDiaQueLaTierraSeDetuvo.jpg")));
		
		pelicula28.setImagenPelicula(imagenPelicula28);
		
	    List<Genero> generosPelicula28 = new ArrayList<>();
	    
	    generosPelicula28.add(generosGuardados.get(1));
	    
	    generosPelicula28.add(generosGuardados.get(4));
	    
	    generosPelicula28.add(generosGuardados.get(2));
	    	    
	    pelicula28.setGeneros(generosPelicula28);
	    
	    peliculasAGuardar.add(pelicula28);
	   
 Pelicula pelicula29 = new Pelicula();
		
		pelicula29.setTitulo("El Espanta Tiburones");
		
		pelicula29.setUrlWeb("https://www.imdb.com/title/tt0307453/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_el%2520espanta%2520tiburones");
		
		ImagenPelicula imagenPelicula29 = new ImagenPelicula();
		
		imagenPelicula29.setNombreArchivo("ElEspantaTiburones.jpg");
		
		imagenPelicula29.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElEspantaTiburones.jpg")));
		
		pelicula29.setImagenPelicula(imagenPelicula29);
		
	    List<Genero> generosPelicula29 = new ArrayList<>();
	    
	    generosPelicula29.add(generosGuardados.get(9));
	    
	    generosPelicula29.add(generosGuardados.get(1));
	    
	    generosPelicula29.add(generosGuardados.get(3));
	    	    
	    pelicula29.setGeneros(generosPelicula29);
	    
	    peliculasAGuardar.add(pelicula29);
	    
 Pelicula pelicula30 = new Pelicula();
		
		pelicula30.setTitulo("El Hombre Araña 2");
		
		pelicula30.setUrlWeb("https://www.imdb.com/title/tt0316654/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520hombre%2520ara%25C3%25B1a%25202");
		
		ImagenPelicula imagenPelicula30 = new ImagenPelicula();
		
		imagenPelicula30.setNombreArchivo("ElHombreAraña2.jpg");
		
		imagenPelicula30.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElHombreAraña2.jpg")));
		
		pelicula30.setImagenPelicula(imagenPelicula30);
		
	    List<Genero> generosPelicula30 = new ArrayList<>();
	    
	    generosPelicula30.add(generosGuardados.get(0));
	    
	    generosPelicula30.add(generosGuardados.get(1));
	    
	    generosPelicula30.add(generosGuardados.get(2));
	    	    
	    pelicula30.setGeneros(generosPelicula30);
	    
	    peliculasAGuardar.add(pelicula30);
	    
 Pelicula pelicula31 = new Pelicula();
		
		pelicula31.setTitulo("El Justiciero");
		
		pelicula31.setUrlWeb("https://www.imdb.com/title/tt0455944/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520justiciero");
		
		ImagenPelicula imagenPelicula31 = new ImagenPelicula();
		
		imagenPelicula31.setNombreArchivo("ElJusticiero.jpg");
		
		imagenPelicula31.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElJusticiero.jpg")));
		
		pelicula31.setImagenPelicula(imagenPelicula31);
		
	    List<Genero> generosPelicula31 = new ArrayList<>();
	    
	    generosPelicula31.add(generosGuardados.get(0));
	    
	    generosPelicula31.add(generosGuardados.get(7));
	    
	    generosPelicula31.add(generosGuardados.get(10));
	    	    
	    pelicula31.setGeneros(generosPelicula31);
	    
	    peliculasAGuardar.add(pelicula31);
    
 Pelicula pelicula32 = new Pelicula();
		
		pelicula32.setTitulo("El Origen Del Planeta De Los Simios");
		
		pelicula32.setUrlWeb("https://www.imdb.com/title/tt1318514/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520origen%2520del%2520planeta%2520de%2520los");
		
		ImagenPelicula imagenPelicula32 = new ImagenPelicula();
		
		imagenPelicula32.setNombreArchivo("ElOrigenDelPlanetaDeLosSimios.jpg");
		
		imagenPelicula32.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElOrigenDelPlanetaDeLosSimios.jpg")));
		
		pelicula32.setImagenPelicula(imagenPelicula32);
		
	    List<Genero> generosPelicula32 = new ArrayList<>();
	    
	    generosPelicula32.add(generosGuardados.get(0));
	    
	    generosPelicula32.add(generosGuardados.get(4));
	    
	    generosPelicula32.add(generosGuardados.get(2));
	    	    
	    pelicula32.setGeneros(generosPelicula32);
	    
	    peliculasAGuardar.add(pelicula32);
    
 Pelicula pelicula33 = new Pelicula();
		
		pelicula33.setTitulo("El Perfecto Asesino");
		
		pelicula33.setUrlWeb("https://www.imdb.com/title/tt0110413/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520prefecto%2520a");
		
		ImagenPelicula imagenPelicula33 = new ImagenPelicula();
		
		imagenPelicula33.setNombreArchivo("ElPerfectoAsesino.jpg");
		
		imagenPelicula33.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElPerfectoAsesino.jpg")));
		
		pelicula33.setImagenPelicula(imagenPelicula33);
		
	    List<Genero> generosPelicula33 = new ArrayList<>();
	    
	    generosPelicula33.add(generosGuardados.get(0));
	    
	    generosPelicula33.add(generosGuardados.get(7));
	    
	    generosPelicula33.add(generosGuardados.get(4));
	       	    
	    pelicula33.setGeneros(generosPelicula33);
	    
	    peliculasAGuardar.add(pelicula33);
	    
 Pelicula pelicula34 = new Pelicula();
		
		pelicula34.setTitulo("El Precio Del Mañana");
		
		pelicula34.setUrlWeb("https://www.imdb.com/title/tt1637688/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520precio%2520del%2520ma%25C3%25B1ana");
		
		ImagenPelicula imagenPelicula34 = new ImagenPelicula();
		
		imagenPelicula34.setNombreArchivo("ElPrecioDelMañana.jpg");
		
		imagenPelicula34.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElPrecioDelMañana.jpg")));
		
		pelicula34.setImagenPelicula(imagenPelicula34);
		
	    List<Genero> generosPelicula34 = new ArrayList<>();
	    
	    generosPelicula34.add(generosGuardados.get(0));
	    
	    generosPelicula34.add(generosGuardados.get(2));
	    
	    generosPelicula34.add(generosGuardados.get(10));
	    	    
	    pelicula34.setGeneros(generosPelicula34);
	    
	    peliculasAGuardar.add(pelicula34);
    
 Pelicula pelicula35 = new Pelicula();
		
		pelicula35.setTitulo("El Quinto Elemento");
		
		pelicula35.setUrlWeb("https://www.imdb.com/title/tt0119116/?ref_=nv_sr_srsg_0_tt_2_nm_0_q_el%2520quinto%2520elemento");
		
		ImagenPelicula imagenPelicula35 = new ImagenPelicula();
		
		imagenPelicula35.setNombreArchivo("ElQuintoElemento.jpg");
		
		imagenPelicula35.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElQuintoElemento.jpg")));
		
		pelicula35.setImagenPelicula(imagenPelicula35);
		
	    List<Genero> generosPelicula35 = new ArrayList<>();
	    
	    generosPelicula35.add(generosGuardados.get(0));
	    
	    generosPelicula35.add(generosGuardados.get(1));
	    
	    generosPelicula35.add(generosGuardados.get(2));
	    	    
	    pelicula35.setGeneros(generosPelicula35);
	    
	    peliculasAGuardar.add(pelicula35);
	    
 Pelicula pelicula36 = new Pelicula();
		
		pelicula36.setTitulo("El Señor De Los Anillos");
		
		pelicula36.setUrlWeb("https://www.imdb.com/title/tt0120737/?ref_=fn_al_tt_2");
		
		ImagenPelicula imagenPelicula36 = new ImagenPelicula();
		
		imagenPelicula36.setNombreArchivo("ElSeñorDeLosAnillos.jpg");
		
		imagenPelicula36.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElSeñorDeLosAnillos.jpg")));
		
		pelicula36.setImagenPelicula(imagenPelicula36);
		
	    List<Genero> generosPelicula36 = new ArrayList<>();
	    
	    generosPelicula36.add(generosGuardados.get(0));
	    
	    generosPelicula36.add(generosGuardados.get(1));
	    
	    generosPelicula36.add(generosGuardados.get(4));
	    	    
	    pelicula36.setGeneros(generosPelicula36);
	    
	    peliculasAGuardar.add(pelicula36);
  
 Pelicula pelicula37 = new Pelicula();
		
		pelicula37.setTitulo("El Transportador");
		
		pelicula37.setUrlWeb("https://www.imdb.com/title/tt0293662/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_el%2520transporta");
		
		ImagenPelicula imagenPelicula37 = new ImagenPelicula();
		
		imagenPelicula37.setNombreArchivo("ElTransportador.jpg");
		
		imagenPelicula37.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ElTransportador.jpg")));
		
		pelicula37.setImagenPelicula(imagenPelicula37);
		
	    List<Genero> generosPelicula37 = new ArrayList<>();
	    
	    generosPelicula37.add(generosGuardados.get(0));
	    
	    generosPelicula37.add(generosGuardados.get(7));
	    
	    generosPelicula37.add(generosGuardados.get(10));
	    	    
	    pelicula37.setGeneros(generosPelicula37);
	    
	    peliculasAGuardar.add(pelicula37);
	    
 Pelicula pelicula38 = new Pelicula();
		
		pelicula38.setTitulo("En Busca De La Felicidad");
		
		pelicula38.setUrlWeb("https://www.imdb.com/title/tt0454921/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_en%2520busca%2520de%2520la%2520feli");
		
		ImagenPelicula imagenPelicula38 = new ImagenPelicula();
		
		imagenPelicula38.setNombreArchivo("EnBuscaDeLaFelicidad.jpg");
		
		imagenPelicula38.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/EnBuscaDeLaFelicidad.jpg")));
		
		pelicula38.setImagenPelicula(imagenPelicula38);
		
	    List<Genero> generosPelicula38 = new ArrayList<>();
	    
	    generosPelicula38.add(generosGuardados.get(4));
	    
	    generosPelicula38.add(generosGuardados.get(11));
	    	    
	    pelicula38.setGeneros(generosPelicula38);
	    
	    peliculasAGuardar.add(pelicula38);
	    
 Pelicula pelicula39 = new Pelicula();
		
		pelicula39.setTitulo("Plan De Vuelo");
		
		pelicula39.setUrlWeb("https://www.imdb.com/title/tt0408790/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_plan%2520de%2520v");
		
		ImagenPelicula imagenPelicula39 = new ImagenPelicula();
		
		imagenPelicula39.setNombreArchivo("Flightplan.jpg");
		
		imagenPelicula39.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Flightplan.jpg")));
		
		pelicula39.setImagenPelicula(imagenPelicula39);
		
	    List<Genero> generosPelicula39 = new ArrayList<>();
	    
	    generosPelicula39.add(generosGuardados.get(4));
	    
	    generosPelicula39.add(generosGuardados.get(8));
	    
	    generosPelicula39.add(generosGuardados.get(10));
	    	    
	    pelicula39.setGeneros(generosPelicula39);
	    
	    peliculasAGuardar.add(pelicula39);
    
 Pelicula pelicula40 = new Pelicula();
		
		pelicula40.setTitulo("Gladiador");
		
		pelicula40.setUrlWeb("https://www.imdb.com/title/tt0172495/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_gladiador");
		
		ImagenPelicula imagenPelicula40 = new ImagenPelicula();
		
		imagenPelicula40.setNombreArchivo("Gladiador.jpg");
		
		imagenPelicula40.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Gladiador.jpg")));
		
		pelicula40.setImagenPelicula(imagenPelicula40);
		
	    List<Genero> generosPelicula40 = new ArrayList<>();
	    
	    generosPelicula40.add(generosGuardados.get(0));
	    
	    generosPelicula40.add(generosGuardados.get(1));
	    
	    generosPelicula40.add(generosGuardados.get(4));
	    	    
	    pelicula40.setGeneros(generosPelicula40);
	    
	    peliculasAGuardar.add(pelicula40);

	 
 Pelicula pelicula41 = new Pelicula();
		
		pelicula41.setTitulo("Harry Potter Y La Camara Secreta");
		
		pelicula41.setUrlWeb("https://www.imdb.com/title/tt0295297/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_harry%2520potter%2520y%2520la%2520camara%2520secreta");
		
		ImagenPelicula imagenPelicula41 = new ImagenPelicula();
		
		imagenPelicula41.setNombreArchivo("HarryPotterYLaCamaraSecreta.jpg");
		
		imagenPelicula41.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/HarryPotterYLaCamaraSecreta.jpg")));
		
		pelicula41.setImagenPelicula(imagenPelicula41);
		
	    List<Genero> generosPelicula41 = new ArrayList<>();
	    
	    generosPelicula41.add(generosGuardados.get(1));
	    
	    generosPelicula41.add(generosGuardados.get(6));
	    	    
	    pelicula41.setGeneros(generosPelicula41);
	    
	    peliculasAGuardar.add(pelicula41);
    
 Pelicula pelicula42 = new Pelicula();
		
		pelicula42.setTitulo("Harry Potter Y La Piedra Filosofal");
		
		pelicula42.setUrlWeb("https://www.imdb.com/title/tt0241527/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_harry%2520p");
		
		ImagenPelicula imagenPelicula42 = new ImagenPelicula();
		
		imagenPelicula42.setNombreArchivo("HarryPotterYLaPiedraFilosofal.jpg");
		
		imagenPelicula42.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/HarryPotterYLaPiedraFilosofal.jpg")));
		
		pelicula42.setImagenPelicula(imagenPelicula42);
		
	    List<Genero> generosPelicula42 = new ArrayList<>();
	    
	    generosPelicula42.add(generosGuardados.get(1));
	    
	    generosPelicula42.add(generosGuardados.get(6));
	    	    
	    pelicula42.setGeneros(generosPelicula42);
	    
	    peliculasAGuardar.add(pelicula42);
	    
 Pelicula pelicula43 = new Pelicula();
		
		pelicula43.setTitulo("Hombre En Llamas");
		
		pelicula43.setUrlWeb("https://www.imdb.com/title/tt0328107/?ref_=nv_sr_srsg_0_tt_4_nm_0_q_hombre%2520en%2520llamas");
		
		ImagenPelicula imagenPelicula43 = new ImagenPelicula();
		
		imagenPelicula43.setNombreArchivo("HombreEnLlamas.jpg");
		
		imagenPelicula43.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/HombreEnLlamas.jpg")));
		
		pelicula43.setImagenPelicula(imagenPelicula43);
		
	    List<Genero> generosPelicula43 = new ArrayList<>();
	    
	    generosPelicula43.add(generosGuardados.get(0));
	    
	    generosPelicula43.add(generosGuardados.get(7));
	    
	    generosPelicula43.add(generosGuardados.get(4));
	    	    
	    pelicula43.setGeneros(generosPelicula43);
	    
	    peliculasAGuardar.add(pelicula43);
    
 Pelicula pelicula44 = new Pelicula();
		
		pelicula44.setTitulo("Imparable");
		
		pelicula44.setUrlWeb("https://www.imdb.com/title/tt0477080/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_imparable");
		
		ImagenPelicula imagenPelicula44 = new ImagenPelicula();
		
		imagenPelicula44.setNombreArchivo("Imparable.jpg");
		
		imagenPelicula44.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Imparable.jpg")));
		
		pelicula44.setImagenPelicula(imagenPelicula44);
		
	    List<Genero> generosPelicula44 = new ArrayList<>();
	    
	    generosPelicula44.add(generosGuardados.get(0));
	    
	    generosPelicula44.add(generosGuardados.get(10));
	    	    
	    pelicula44.setGeneros(generosPelicula44);
	    
	    peliculasAGuardar.add(pelicula44);
	    
 Pelicula pelicula45 = new Pelicula();
		
		pelicula45.setTitulo("Inframundo");
		
		pelicula45.setUrlWeb("https://www.imdb.com/title/tt0320691/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_inframundo");
		
		ImagenPelicula imagenPelicula45 = new ImagenPelicula();
		
		imagenPelicula45.setNombreArchivo("Inframundo.jpg");
		
		imagenPelicula45.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Inframundo.jpg")));
		
		pelicula45.setImagenPelicula(imagenPelicula45);
		
	    List<Genero> generosPelicula45 = new ArrayList<>();
	    
	    generosPelicula45.add(generosGuardados.get(0));
	    
	    generosPelicula45.add(generosGuardados.get(6));
	    
	    generosPelicula45.add(generosGuardados.get(10));
	    	    
	    pelicula45.setGeneros(generosPelicula45);
	    
	    peliculasAGuardar.add(pelicula45);
	    
 Pelicula pelicula46 = new Pelicula();           
		
		pelicula46.setTitulo("Jeepers Creepers");
		
		pelicula46.setUrlWeb("https://www.imdb.com/title/tt0263488/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_jeepers%2520cre");
		
		ImagenPelicula imagenPelicula46 = new ImagenPelicula();
		
		imagenPelicula46.setNombreArchivo("JeepersCreepers.jpg");
		
		imagenPelicula46.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/JeepersCreepers.jpg")));
		
		pelicula46.setImagenPelicula(imagenPelicula46);
		
	    List<Genero> generosPelicula46 = new ArrayList<>();
	    
	    generosPelicula46.add(generosGuardados.get(5));
	    
	    generosPelicula46.add(generosGuardados.get(8));
	    	    
	    pelicula46.setGeneros(generosPelicula46);
	    
	    peliculasAGuardar.add(pelicula46);
	    
 Pelicula pelicula47 = new Pelicula();       
		
		pelicula47.setTitulo("Juana De Arco");
		
		pelicula47.setUrlWeb("https://www.imdb.com/title/tt0151137/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_juana%2520de%2520arc");
		
		ImagenPelicula imagenPelicula47 = new ImagenPelicula();
		
		imagenPelicula47.setNombreArchivo("JuanaDeArco.jpg");
		
		imagenPelicula47.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/JuanaDeArco.jpg")));
		
		pelicula47.setImagenPelicula(imagenPelicula47);
		
	    List<Genero> generosPelicula47 = new ArrayList<>();
	    
	    generosPelicula47.add(generosGuardados.get(1));
	    
	    generosPelicula47.add(generosGuardados.get(11));
	    
	    generosPelicula47.add(generosGuardados.get(4));
	    	    
	    pelicula47.setGeneros(generosPelicula47);
	    
	    peliculasAGuardar.add(pelicula47);
	    
 Pelicula pelicula48 = new Pelicula();  
		
		pelicula48.setTitulo("Juego De Gemelas");
		
		pelicula48.setUrlWeb("https://www.imdb.com/title/tt0120783/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_juego%2520de%2520gemelas");
		
		ImagenPelicula imagenPelicula48 = new ImagenPelicula();
		
		imagenPelicula48.setNombreArchivo("JuegoDeGemelas.jpg");
		
		imagenPelicula48.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/JuegoDeGemelas.jpg")));
		
		pelicula48.setImagenPelicula(imagenPelicula48);
		
	    List<Genero> generosPelicula48 = new ArrayList<>();
	    
	    generosPelicula48.add(generosGuardados.get(1));
	    
	    generosPelicula48.add(generosGuardados.get(3));
	    
	    generosPelicula48.add(generosGuardados.get(4));
	    	    
	    pelicula48.setGeneros(generosPelicula48);
	    
	    peliculasAGuardar.add(pelicula48);
    
 Pelicula pelicula49 = new Pelicula();            
		
		pelicula49.setTitulo("Juegos Sexuales");
		
		pelicula49.setUrlWeb("https://www.imdb.com/title/tt0139134/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_juegos%2520sexula");
		
		ImagenPelicula imagenPelicula49 = new ImagenPelicula();
		
		imagenPelicula49.setNombreArchivo("JuegosSexuales.jpg");
		
		imagenPelicula49.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/JuegosSexuales.jpg")));
		
		pelicula49.setImagenPelicula(imagenPelicula49);
		
	    List<Genero> generosPelicula49 = new ArrayList<>();
	    
	    generosPelicula49.add(generosGuardados.get(4));
	    
	    generosPelicula49.add(generosGuardados.get(12));
	    	    
	    pelicula49.setGeneros(generosPelicula49);
	    
	    peliculasAGuardar.add(pelicula49);
    
 Pelicula pelicula50 = new Pelicula();
		
		pelicula50.setTitulo("Jumanji");
		
		pelicula50.setUrlWeb("https://www.imdb.com/title/tt0113497/?ref_=nv_sr_srsg_1_tt_6_nm_1_q_jumanji");
		
		ImagenPelicula imagenPelicula50 = new ImagenPelicula();
		
		imagenPelicula50.setNombreArchivo("Jumanji.jpg");
		
		imagenPelicula50.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Jumanji.jpg")));
		
		pelicula50.setImagenPelicula(imagenPelicula50);
		
	    List<Genero> generosPelicula50 = new ArrayList<>();
	    
	    generosPelicula50.add(generosGuardados.get(1));
	    
	    generosPelicula50.add(generosGuardados.get(3));
	    	    
	    pelicula50.setGeneros(generosPelicula50);
	    
	    peliculasAGuardar.add(pelicula50);
	    
	    for(Pelicula p : peliculasAGuardar){
	    	
	    	peliculaRepository.save(p);
	    }
	    
    
 Pelicula pelicula51 = new Pelicula();
		
		pelicula51.setTitulo("Jurassic Park");
		
		pelicula51.setUrlWeb("https://www.imdb.com/title/tt0107290/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_jurasic%2520park");
		
		ImagenPelicula imagenPelicula51 = new ImagenPelicula();
		
		imagenPelicula51.setNombreArchivo("JurassicPark.jpg");
		
		imagenPelicula51.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/JurassicPark.jpg")));
		
		pelicula51.setImagenPelicula(imagenPelicula51);
		
	    List<Genero> generosPelicula51 = new ArrayList<>();
	    
	    generosPelicula51.add(generosGuardados.get(0));
	    
	    generosPelicula51.add(generosGuardados.get(1));
	    
	    generosPelicula51.add(generosGuardados.get(2));
	    	    
	    pelicula51.setGeneros(generosPelicula51);
	    
	    peliculasAGuardar.add(pelicula51);
	    
 Pelicula pelicula52 = new Pelicula();
		
		pelicula52.setTitulo("Kill Bill Volumen 1");
		
		pelicula52.setUrlWeb("https://www.imdb.com/title/tt0266697/?ref_=nv_sr_srsg_1_tt_7_nm_0_q_kill%2520bill%2520");
		
		ImagenPelicula imagenPelicula52 = new ImagenPelicula();
		
		imagenPelicula52.setNombreArchivo("KillBillVol1.jpg");
		
		imagenPelicula52.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/KillBillVol1.jpg")));
		
		pelicula52.setImagenPelicula(imagenPelicula52);
		
	    List<Genero> generosPelicula52 = new ArrayList<>();
	    
	    generosPelicula52.add(generosGuardados.get(0));
	    
	    generosPelicula52.add(generosGuardados.get(7));
	    
	    generosPelicula52.add(generosGuardados.get(10));
	    	    
	    pelicula52.setGeneros(generosPelicula52);
	    
	    peliculasAGuardar.add(pelicula52);
	    
 Pelicula pelicula53 = new Pelicula();
		
		pelicula53.setTitulo("Kill Bill Volumen 2");
		
		pelicula53.setUrlWeb("https://www.imdb.com/title/tt0378194/?ref_=nv_sr_srsg_4_tt_7_nm_0_q_kill%2520bill%2520");
		
		ImagenPelicula imagenPelicula53 = new ImagenPelicula();
		
		imagenPelicula53.setNombreArchivo("KillBillVol2.jpg");
		
		imagenPelicula53.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/KillBillVol2.jpg")));
		
		pelicula53.setImagenPelicula(imagenPelicula53);
		
	    List<Genero> generosPelicula53 = new ArrayList<>();
	    
	    generosPelicula53.add(generosGuardados.get(0));
	    
	    generosPelicula53.add(generosGuardados.get(7));
	    
	    generosPelicula53.add(generosGuardados.get(10));
	    	    
	    pelicula53.setGeneros(generosPelicula53);
	    
	    peliculasAGuardar.add(pelicula53);
	    
 Pelicula pelicula54 = new Pelicula();
		
		pelicula54.setTitulo("King Kong");
		
		pelicula54.setUrlWeb("https://www.imdb.com/title/tt0360717/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_king%2520kong");
		
		ImagenPelicula imagenPelicula54 = new ImagenPelicula();
		
		imagenPelicula54.setNombreArchivo("KingKong.jpg");
		
		imagenPelicula54.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/KingKong.jpg")));
		
		pelicula54.setImagenPelicula(imagenPelicula54);
		
	    List<Genero> generosPelicula54 = new ArrayList<>();
	    
	    generosPelicula54.add(generosGuardados.get(0));
	    
	    generosPelicula54.add(generosGuardados.get(1));
	    
	    generosPelicula54.add(generosGuardados.get(12));
	    	    
	    pelicula54.setGeneros(generosPelicula54);
	    
	    peliculasAGuardar.add(pelicula54);
    
 Pelicula pelicula55 = new Pelicula();
		
		pelicula55.setTitulo("La Casa De Cera");
		
		pelicula55.setUrlWeb("https://www.imdb.com/title/tt0397065/?ref_=nv_sr_srsg_3_tt_8_nm_0_q_la%2520casa%2520de%2520cera");
		
		ImagenPelicula imagenPelicula55 = new ImagenPelicula();
		
		imagenPelicula55.setNombreArchivo("LaCasaDeCera.jpg");
		
		imagenPelicula55.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaCasaDeCera.jpg")));
		
		pelicula55.setImagenPelicula(imagenPelicula55);
		
	    List<Genero> generosPelicula55 = new ArrayList<>();
	    
	    generosPelicula55.add(generosGuardados.get(5));
	    
	    generosPelicula55.add(generosGuardados.get(10));
	    	    
	    pelicula55.setGeneros(generosPelicula55);
	    
	    peliculasAGuardar.add(pelicula55);
	    
 Pelicula pelicula56 = new Pelicula();
		
		pelicula56.setTitulo("La Cosa Mas Dulce");
		
		pelicula56.setUrlWeb("https://www.imdb.com/title/tt0253867/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_la%2520cosa%2520mas%2520dulce");
		
		ImagenPelicula imagenPelicula56 = new ImagenPelicula();
		
		imagenPelicula56.setNombreArchivo("LaCosaMasDulce.jpg");
		
		imagenPelicula56.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaCosaMasDulce.jpg")));
		
		pelicula56.setImagenPelicula(imagenPelicula56);
		
	    List<Genero> generosPelicula56 = new ArrayList<>();
	    
	    generosPelicula56.add(generosGuardados.get(3));
	    
	    generosPelicula56.add(generosGuardados.get(12));
	    	    
	    pelicula56.setGeneros(generosPelicula56);
	    
	    peliculasAGuardar.add(pelicula56);
	    
 Pelicula pelicula57 = new Pelicula();
		
		pelicula57.setTitulo("La Era Del Hielo");
		
		pelicula57.setUrlWeb("https://www.imdb.com/title/tt0268380/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_la%2520era%2520del%2520hielo");
		
		ImagenPelicula imagenPelicula57 = new ImagenPelicula();
		
		imagenPelicula57.setNombreArchivo("LaEraDelHielo.jpg");
		
		imagenPelicula57.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaEraDelHielo.jpg")));
		
		pelicula57.setImagenPelicula(imagenPelicula57);
		
	    List<Genero> generosPelicula57 = new ArrayList<>();
	    
	    generosPelicula57.add(generosGuardados.get(9));
	    
	    generosPelicula57.add(generosGuardados.get(1));
	    
	    generosPelicula57.add(generosGuardados.get(3));
	    	    
	    pelicula57.setGeneros(generosPelicula57);
	    
	    peliculasAGuardar.add(pelicula57);
	    
 Pelicula pelicula58 = new Pelicula();
		
		pelicula58.setTitulo("La Guerra De Los Mundos");
		
		pelicula58.setUrlWeb("https://www.imdb.com/title/tt0407304/?ref_=nv_sr_srsg_2_tt_7_nm_1_q_la%2520guerra%2520de%2520los%2520mundos");
		
		ImagenPelicula imagenPelicula58 = new ImagenPelicula();
		
		imagenPelicula58.setNombreArchivo("LaGuerraDeLosMundos.jpg");
		
		imagenPelicula58.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaGuerraDeLosMundos.jpg")));
		
		pelicula58.setImagenPelicula(imagenPelicula58);
		
	    List<Genero> generosPelicula58 = new ArrayList<>();
	    
	    generosPelicula58.add(generosGuardados.get(0));
	    
	    generosPelicula58.add(generosGuardados.get(1));
	    
	    generosPelicula58.add(generosGuardados.get(2));
	    	    
	    pelicula58.setGeneros(generosPelicula58);
	    
	    peliculasAGuardar.add(pelicula58);
	    
 Pelicula pelicula59 = new Pelicula();
		
		pelicula59.setTitulo("La Llamada");
		
		pelicula59.setUrlWeb("https://www.imdb.com/title/tt0298130/?ref_=nv_sr_srsg_4_tt_6_nm_0_q_la%2520llamada");
		
		ImagenPelicula imagenPelicula59 = new ImagenPelicula();
		
		imagenPelicula59.setNombreArchivo("LaLlamada.jpg");
		
		imagenPelicula59.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaLlamada.jpeg")));
		
		pelicula59.setImagenPelicula(imagenPelicula59);
		
	    List<Genero> generosPelicula59 = new ArrayList<>();
	    
	    generosPelicula59.add(generosGuardados.get(5));
	    
	    generosPelicula59.add(generosGuardados.get(8));
	    	    
	    pelicula59.setGeneros(generosPelicula59);
	    
	    peliculasAGuardar.add(pelicula59);
	    
 Pelicula pelicula60 = new Pelicula();
		
		pelicula60.setTitulo("La Llegada");
		
		pelicula60.setUrlWeb("https://www.imdb.com/title/tt2543164/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_la%2520llegada");
		
		ImagenPelicula imagenPelicula60 = new ImagenPelicula();
		
		imagenPelicula60.setNombreArchivo("LaLlegada.jpg");
		
		imagenPelicula60.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaLlegada.jpg")));
		
		pelicula60.setImagenPelicula(imagenPelicula60);
		
	    List<Genero> generosPelicula60 = new ArrayList<>();
	    
	    generosPelicula60.add(generosGuardados.get(4));
	    
	    generosPelicula60.add(generosGuardados.get(8));
	    
	    generosPelicula60.add(generosGuardados.get(2));
	    	    
	    pelicula60.setGeneros(generosPelicula60);
	    
	    peliculasAGuardar.add(pelicula60);
	    
 Pelicula pelicula61 = new Pelicula();          
		
		pelicula61.setTitulo("La Vigilante Del Futuro");
		
		pelicula61.setUrlWeb("https://www.imdb.com/title/tt1219827/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_la%2520vigilante%2520del%2520futuro");
		
		ImagenPelicula imagenPelicula61 = new ImagenPelicula();
		
		imagenPelicula61.setNombreArchivo("LaVigilanteDelFuturo.jpg");
		
		imagenPelicula61.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaVigilanteDelFuturo.jpg")));
		
		pelicula61.setImagenPelicula(imagenPelicula61);
		
	    List<Genero> generosPelicula61 = new ArrayList<>();
	    
	    generosPelicula61.add(generosGuardados.get(0));
	    
	    generosPelicula61.add(generosGuardados.get(7));
	    
	    generosPelicula61.add(generosGuardados.get(4));
	    	    
	    pelicula61.setGeneros(generosPelicula61);
	    
	    peliculasAGuardar.add(pelicula61);
	

 Pelicula pelicula62 = new Pelicula();
		
		pelicula62.setTitulo("Loco Por Mary");
		
		pelicula62.setUrlWeb("https://www.imdb.com/title/tt0129387/?ref_=nv_sr_srsg_0_tt_3_nm_0_q_loco%2520por%2520mary");
		
		ImagenPelicula imagenPelicula62 = new ImagenPelicula();
		
		imagenPelicula62.setNombreArchivo("LocoPorMary.jpg");
		
		imagenPelicula62.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LocoPorMary.jpg")));
		
		pelicula62.setImagenPelicula(imagenPelicula62);
		
	    List<Genero> generosPelicula62 = new ArrayList<>();
	    
	    generosPelicula62.add(generosGuardados.get(3));
	    
	    generosPelicula62.add(generosGuardados.get(12));
	    	    
	    pelicula62.setGeneros(generosPelicula62);
	    
	    peliculasAGuardar.add(pelicula62);
	    
 Pelicula pelicula63 = new Pelicula();
		
		pelicula63.setTitulo("Los Juegos Del Hambre");
		
		pelicula63.setUrlWeb("https://www.imdb.com/title/tt1392170/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_los%2520juegos%2520del%2520hambre");
		
		ImagenPelicula imagenPelicula63 = new ImagenPelicula();
		
		imagenPelicula63.setNombreArchivo("LosJuegosDelHambre.jpg");
		
		imagenPelicula63.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LosJuegosDelHambre.jpg")));
		
		pelicula63.setImagenPelicula(imagenPelicula63);
		
	    List<Genero> generosPelicula63 = new ArrayList<>();
	    
	    generosPelicula63.add(generosGuardados.get(0));
	    
	    generosPelicula63.add(generosGuardados.get(1));
	    
	    generosPelicula63.add(generosGuardados.get(2));
	    	    
	    pelicula63.setGeneros(generosPelicula63);
	    
	    peliculasAGuardar.add(pelicula63);
	    
 Pelicula pelicula64 = new Pelicula();
		
		pelicula64.setTitulo("Los Otros");
		
		pelicula64.setUrlWeb("https://www.imdb.com/title/tt0230600/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_los%2520otros");
		
		ImagenPelicula imagenPelicula64 = new ImagenPelicula();
		
		imagenPelicula64.setNombreArchivo("LosOtros.jpg");
		
		imagenPelicula64.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LosOtros.jpg")));
		
		pelicula64.setImagenPelicula(imagenPelicula64);
		
	    List<Genero> generosPelicula64 = new ArrayList<>();
	    
	    generosPelicula64.add(generosGuardados.get(5));
	    
	    generosPelicula64.add(generosGuardados.get(8));
	    
	    generosPelicula64.add(generosGuardados.get(10));
	    	    
	    pelicula64.setGeneros(generosPelicula64);
	    
	    peliculasAGuardar.add(pelicula64);
	    
 Pelicula pelicula65 = new Pelicula();
		
		pelicula65.setTitulo("Los Simpson");
		
		pelicula65.setUrlWeb("https://www.imdb.com/title/tt0462538/?ref_=nv_sr_srsg_3_tt_8_nm_0_q_los%2520simpson");
		
		ImagenPelicula imagenPelicula65 = new ImagenPelicula();
		
		imagenPelicula65.setNombreArchivo("LosSimpson.jpg");
		
		imagenPelicula65.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LosSimpson.jpg")));
		
		pelicula65.setImagenPelicula(imagenPelicula65);
		
	    List<Genero> generosPelicula65 = new ArrayList<>();
	    
	    generosPelicula65.add(generosGuardados.get(9));
	    
	    generosPelicula65.add(generosGuardados.get(1));
	    
	    generosPelicula65.add(generosGuardados.get(3));
	    	    
	    pelicula65.setGeneros(generosPelicula65);
	    
	    peliculasAGuardar.add(pelicula65);
	    
 Pelicula pelicula66 = new Pelicula();
		
		pelicula66.setTitulo("Lucy");
		
		pelicula66.setUrlWeb("https://www.imdb.com/title/tt2872732/?ref_=fn_al_tt_1");
		
		ImagenPelicula imagenPelicula66 = new ImagenPelicula();
		
		imagenPelicula66.setNombreArchivo("Lucy.jpg");
		
		imagenPelicula66.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Lucy.jpg")));
		
		pelicula66.setImagenPelicula(imagenPelicula66);
		
	    List<Genero> generosPelicula66 = new ArrayList<>();
	    
	    generosPelicula66.add(generosGuardados.get(0));
	    
	    generosPelicula66.add(generosGuardados.get(2));
	    
	    generosPelicula66.add(generosGuardados.get(10));
	    	    
	    pelicula66.setGeneros(generosPelicula66);
	    
	    peliculasAGuardar.add(pelicula66);
	    
 Pelicula pelicula67 = new Pelicula();
		
		pelicula67.setTitulo("Madagascar");
		
		pelicula67.setUrlWeb("https://www.imdb.com/title/tt0351283/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_madagascar");
		
		ImagenPelicula imagenPelicula67 = new ImagenPelicula();
		
		imagenPelicula67.setNombreArchivo("Madagascar.jpg");
		
		imagenPelicula67.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Madagascar.jpg")));
		
		pelicula67.setImagenPelicula(imagenPelicula67);
		
	    List<Genero> generosPelicula67 = new ArrayList<>();
	    
	    generosPelicula67.add(generosGuardados.get(9));
	    
	    generosPelicula67.add(generosGuardados.get(1));
	    
	    generosPelicula67.add(generosGuardados.get(3));
	    	    
	    pelicula67.setGeneros(generosPelicula67);
	    
	    peliculasAGuardar.add(pelicula67);
	    
 Pelicula pelicula68 = new Pelicula();
		
		pelicula68.setTitulo("Matilda");
		
		pelicula68.setUrlWeb("https://www.imdb.com/title/tt0117008/?ref_=nv_sr_srsg_0_tt_2_nm_6_q_matilda");
		
		ImagenPelicula imagenPelicula68 = new ImagenPelicula();
		
		imagenPelicula68.setNombreArchivo("Matilda.jpg");
		
		imagenPelicula68.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Matilda.jpg")));
		
		pelicula68.setImagenPelicula(imagenPelicula68);
		
	    List<Genero> generosPelicula68 = new ArrayList<>();
	    
	    generosPelicula68.add(generosGuardados.get(3));
	    
	    generosPelicula68.add(generosGuardados.get(6));
	    	    
	    pelicula68.setGeneros(generosPelicula68);
	    
	    peliculasAGuardar.add(pelicula68);
	    
 Pelicula pelicula69 = new Pelicula();
		
		pelicula69.setTitulo("Matrix");
		
		pelicula69.setUrlWeb("https://www.imdb.com/title/tt0133093/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_matrix");
		
		ImagenPelicula imagenPelicula69 = new ImagenPelicula();
		
		imagenPelicula69.setNombreArchivo("Matrix.jpg");
		
		imagenPelicula69.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Matrix.jpg")));
		
		pelicula69.setImagenPelicula(imagenPelicula69);
		
	    List<Genero> generosPelicula69 = new ArrayList<>();
	    
	    generosPelicula69.add(generosGuardados.get(0));
	    
	    generosPelicula69.add(generosGuardados.get(2));
	    	    
	    pelicula69.setGeneros(generosPelicula69);
	    
	    peliculasAGuardar.add(pelicula69);

 Pelicula pelicula70 = new Pelicula();
		
		pelicula70.setTitulo("Maxima Velocidad");
		
		pelicula70.setUrlWeb("https://www.imdb.com/title/tt0111257/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_maxima%2520velocidad");
		
		ImagenPelicula imagenPelicula70 = new ImagenPelicula();
		
		imagenPelicula70.setNombreArchivo("MaximaVelocidad.jpg");
		
		imagenPelicula70.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/MaximaVelocidad.jpg")));
		
		pelicula70.setImagenPelicula(imagenPelicula70);
		
	    List<Genero> generosPelicula70 = new ArrayList<>();
	    
	    generosPelicula70.add(generosGuardados.get(0));
	    
	    generosPelicula70.add(generosGuardados.get(1));
	    
	    generosPelicula70.add(generosGuardados.get(10));
	    	    
	    pelicula70.setGeneros(generosPelicula70);
	    
	    peliculasAGuardar.add(pelicula70);
    
 Pelicula pelicula71 = new Pelicula();
		
		pelicula71.setTitulo("Mente Siniestra");
		
		pelicula71.setUrlWeb("https://www.imdb.com/title/tt0382077/?ref_=nv_sr_srsg_0_tt_3_nm_0_q_mente%2520siniestra");
		
		ImagenPelicula imagenPelicula71 = new ImagenPelicula();
		
		imagenPelicula71.setNombreArchivo("MenteSiniestra.jpg");
		
		imagenPelicula71.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/MenteSiniestra.jpg")));
		
		pelicula71.setImagenPelicula(imagenPelicula71);
		
	    List<Genero> generosPelicula71 = new ArrayList<>();
	    
	    generosPelicula71.add(generosGuardados.get(5));
	    
	    generosPelicula71.add(generosGuardados.get(10));
	    	    
	    pelicula71.setGeneros(generosPelicula71);
	    
	    peliculasAGuardar.add(pelicula71);
	    
 Pelicula pelicula72 = new Pelicula();
		
		pelicula72.setTitulo("Mi Nombre Es Sam");
		
		pelicula72.setUrlWeb("https://www.imdb.com/title/tt0277027/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_mi%2520nombre%2520es%2520sam");
		
		ImagenPelicula imagenPelicula72 = new ImagenPelicula();
		
		imagenPelicula72.setNombreArchivo("MiNombreEsSam.jpg");
		
		imagenPelicula72.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/MiNombreEsSam.jpg")));
		
		pelicula72.setImagenPelicula(imagenPelicula72);
		
	    List<Genero> generosPelicula72 = new ArrayList<>();
	    	    
	    generosPelicula72.add(generosGuardados.get(4));
	    	    
	    pelicula72.setGeneros(generosPelicula72);
	    
	    peliculasAGuardar.add(pelicula72);
	    
 Pelicula pelicula73 = new Pelicula();
		
		pelicula73.setTitulo("Mision Imposible");
		
		pelicula73.setUrlWeb("https://www.imdb.com/title/tt0117060/?ref_=nv_sr_srsg_3_tt_8_nm_0_q_mision%2520impos");
		
		ImagenPelicula imagenPelicula73 = new ImagenPelicula();
		
		imagenPelicula73.setNombreArchivo("MisionImposible.jpg");
		
		imagenPelicula73.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/MisionImposible.jpg")));
		
		pelicula73.setImagenPelicula(imagenPelicula73);
		
	    List<Genero> generosPelicula73 = new ArrayList<>();
	    
	    generosPelicula73.add(generosGuardados.get(0));
	    
	    generosPelicula73.add(generosGuardados.get(1));
	    
	    generosPelicula73.add(generosGuardados.get(10));
	    	    
	    pelicula73.setGeneros(generosPelicula73);
	    
	    peliculasAGuardar.add(pelicula73);
    
 Pelicula pelicula74 = new Pelicula();
		
		pelicula74.setTitulo("Monster House");
		
		pelicula74.setUrlWeb("https://www.imdb.com/title/tt0385880/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_monster%2520house");
		
		ImagenPelicula imagenPelicula74 = new ImagenPelicula();
		
		imagenPelicula74.setNombreArchivo("MonsterHouse.jpg");
		
		imagenPelicula74.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/MonsterHouse.jpg")));
		
		pelicula74.setImagenPelicula(imagenPelicula74);
		
	    List<Genero> generosPelicula74 = new ArrayList<>();
	    
	    generosPelicula74.add(generosGuardados.get(9));
	    
	    generosPelicula74.add(generosGuardados.get(3));
	    	    
	    pelicula74.setGeneros(generosPelicula74);
	    
	    peliculasAGuardar.add(pelicula74);
	    
 Pelicula pelicula75 = new Pelicula();
		
		pelicula75.setTitulo("Monsters Inc");
		
		pelicula75.setUrlWeb("https://www.imdb.com/title/tt0198781/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_Monsters%2520inc");
		
		ImagenPelicula imagenPelicula75 = new ImagenPelicula();
		
		imagenPelicula75.setNombreArchivo("MonstersInc.jpg");
		
		imagenPelicula75.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/MonstersInc.jpg")));
		
		pelicula75.setImagenPelicula(imagenPelicula75);
		
	    List<Genero> generosPelicula75 = new ArrayList<>();
	    
	    generosPelicula75.add(generosGuardados.get(9));
	    
	    generosPelicula75.add(generosGuardados.get(1));
	    
	    generosPelicula75.add(generosGuardados.get(3));
	    	    
	    pelicula75.setGeneros(generosPelicula75);
	    
	    peliculasAGuardar.add(pelicula75);
    
 Pelicula pelicula76 = new Pelicula();
		
		pelicula76.setTitulo("Mulholland Drive");
		
		pelicula76.setUrlWeb("https://www.imdb.com/title/tt0166924/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_mulholland%2520drive");
		
		ImagenPelicula imagenPelicula76 = new ImagenPelicula();
		
		imagenPelicula76.setNombreArchivo("MulhollandDrive.jpg");
		
		imagenPelicula76.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/MulhollandDrive.jpg")));
		
		pelicula76.setImagenPelicula(imagenPelicula76);
		
	    List<Genero> generosPelicula76 = new ArrayList<>();
	    
	    generosPelicula76.add(generosGuardados.get(4));
	    
	    generosPelicula76.add(generosGuardados.get(8));
	    
	    generosPelicula76.add(generosGuardados.get(10));
	    	    
	    pelicula76.setGeneros(generosPelicula76);
	    
	    peliculasAGuardar.add(pelicula76);
	    
 Pelicula pelicula77 = new Pelicula();
		
		pelicula77.setTitulo("Narnia");
		
		pelicula77.setUrlWeb("https://www.imdb.com/title/tt0363771/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_narnia");
		
		ImagenPelicula imagenPelicula77 = new ImagenPelicula();
		
		imagenPelicula77.setNombreArchivo("Narnia.jpg");
		
		imagenPelicula77.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Narnia.jpg")));
		
		pelicula77.setImagenPelicula(imagenPelicula77);
		
	    List<Genero> generosPelicula77 = new ArrayList<>();
	    
	    generosPelicula77.add(generosGuardados.get(1));
	    
	    generosPelicula77.add(generosGuardados.get(6));
	    	    
	    pelicula77.setGeneros(generosPelicula77);
	    
	    peliculasAGuardar.add(pelicula77);
	    
 Pelicula pelicula78 = new Pelicula();
		
		pelicula78.setTitulo("Ni En Tus Sueños");
		
		pelicula78.setUrlWeb("https://www.imdb.com/title/tt0815236/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_ni%2520en%2520tus%2520sue%25C3%25B1os");
		
		ImagenPelicula imagenPelicula78 = new ImagenPelicula();
		
		imagenPelicula78.setNombreArchivo("NiEnTusSueños.jpg");
		
		imagenPelicula78.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/NiEnTusSueños.jpg")));
		
		pelicula78.setImagenPelicula(imagenPelicula78);
		
	    List<Genero> generosPelicula78 = new ArrayList<>();
	    
	    generosPelicula78.add(generosGuardados.get(3));
	    
	    generosPelicula78.add(generosGuardados.get(12));
	    	    
	    pelicula78.setGeneros(generosPelicula78);
	    
	    peliculasAGuardar.add(pelicula78);
	    
 Pelicula pelicula79 = new Pelicula();
		
		pelicula79.setTitulo("Ni Idea");
		
		pelicula79.setUrlWeb("https://www.imdb.com/title/tt0112697/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_ni%2520idea");
		
		ImagenPelicula imagenPelicula79 = new ImagenPelicula();
		
		imagenPelicula79.setNombreArchivo("NiIdea.jpg");
		
		imagenPelicula79.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/NiIdea.jpg")));
		
		pelicula79.setImagenPelicula(imagenPelicula79);
		
	    List<Genero> generosPelicula79 = new ArrayList<>();
	    
	    generosPelicula79.add(generosGuardados.get(3));
	    
	    generosPelicula79.add(generosGuardados.get(12));
	    	    
	    pelicula79.setGeneros(generosPelicula79);
	    
	    peliculasAGuardar.add(pelicula79);
    
 Pelicula pelicula80 = new Pelicula();
		
		pelicula80.setTitulo("La Huerfana");
		
		pelicula80.setUrlWeb("https://www.imdb.com/title/tt1148204/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_la%2520huerfana");
		
		ImagenPelicula imagenPelicula80 = new ImagenPelicula();
		
		imagenPelicula80.setNombreArchivo("Orphan.jpg");
		
		imagenPelicula80.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Orphan.jpg")));
		
		pelicula80.setImagenPelicula(imagenPelicula80);
		
	    List<Genero> generosPelicula80 = new ArrayList<>();
	    
	    generosPelicula80.add(generosGuardados.get(5));
	    
	    generosPelicula80.add(generosGuardados.get(8));
	    
	    generosPelicula80.add(generosGuardados.get(10));
	    	    
	    pelicula80.setGeneros(generosPelicula80);
	    
	    peliculasAGuardar.add(pelicula80);
	    
        Pelicula pelicula81 = new Pelicula();
		
		pelicula81.setTitulo("Passengers");
		
		pelicula81.setUrlWeb("https://www.imdb.com/title/tt1355644/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_passenge");
		
		ImagenPelicula imagenPelicula81 = new ImagenPelicula();
		
		imagenPelicula81.setNombreArchivo("Passengers.jpg");
		
		imagenPelicula81.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Passengers.jpg")));
		
		pelicula81.setImagenPelicula(imagenPelicula81);
		
	    List<Genero> generosPelicula81 = new ArrayList<>();
	    
	    generosPelicula81.add(generosGuardados.get(4));
	    
	    generosPelicula81.add(generosGuardados.get(12));
	    
	    generosPelicula81.add(generosGuardados.get(2));
	    	    
	    pelicula81.setGeneros(generosPelicula81);
	    
	    peliculasAGuardar.add(pelicula81);
	    
	    
           
        Pelicula pelicula82 = new Pelicula();
		
		pelicula82.setTitulo("Pearl Harbor");
		
		pelicula82.setUrlWeb("https://www.imdb.com/title/tt0213149/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_pearl%2520harb");
		
		ImagenPelicula imagenPelicula82 = new ImagenPelicula();
		
		imagenPelicula82.setNombreArchivo("PearlHarbor.jpg");
		
		imagenPelicula82.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/PearlHarbor.jpg")));
		
		pelicula82.setImagenPelicula(imagenPelicula82);
		
	    List<Genero> generosPelicula82 = new ArrayList<>();
	    
	    generosPelicula82.add(generosGuardados.get(0));
	    
	    generosPelicula82.add(generosGuardados.get(4));
	    
	    generosPelicula82.add(generosGuardados.get(13));
	    	    
	    pelicula82.setGeneros(generosPelicula82);
	    
	    peliculasAGuardar.add(pelicula82);
	    
	   
	     
	    Pelicula pelicula83 = new Pelicula();
		
		pelicula83.setTitulo("Pequeñas Grandes Amigas");
		
		pelicula83.setUrlWeb("https://www.imdb.com/title/tt0263757/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_peque%25C3%25B1as%2520grandes%2520am");
		
		ImagenPelicula imagenPelicula83 = new ImagenPelicula();
		
		imagenPelicula83.setNombreArchivo("PequeñasGrandesAmigas.jpg");
		
		imagenPelicula83.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/PequeñasGrandesAmigas.jpg")));
		
		pelicula83.setImagenPelicula(imagenPelicula83);
		
	    List<Genero> generosPelicula83 = new ArrayList<>();
	    
	    generosPelicula83.add(generosGuardados.get(3));
	    
	    generosPelicula83.add(generosGuardados.get(4));
	    
	    generosPelicula83.add(generosGuardados.get(12));
	    	    
	    pelicula83.setGeneros(generosPelicula83);
	    
	    peliculasAGuardar.add(pelicula83);
	    	     
	     
	     Pelicula pelicula84 = new Pelicula();
		
		pelicula84.setTitulo("Perdida");
		
		pelicula84.setUrlWeb("https://www.imdb.com/title/tt2267998/?ref_=fn_al_tt_1");
		
		ImagenPelicula imagenPelicula84 = new ImagenPelicula();
		
		imagenPelicula84.setNombreArchivo("Perdida.jpg");
		
		imagenPelicula84.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Perdida.jpg")));
		
		pelicula84.setImagenPelicula(imagenPelicula84);
		
	    List<Genero> generosPelicula84 = new ArrayList<>();
	    
	    generosPelicula84.add(generosGuardados.get(4));
	    
	    generosPelicula84.add(generosGuardados.get(8));
	    
	    generosPelicula84.add(generosGuardados.get(10));
	    	    
	    pelicula84.setGeneros(generosPelicula84);
	    
	    peliculasAGuardar.add(pelicula84);
	    
	    Pelicula pelicula85 = new Pelicula();
		
		pelicula85.setTitulo("Piratas Del Caribe");
		
		pelicula85.setUrlWeb("https://www.imdb.com/title/tt0325980/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_piratas%2520del%2520caribe");
		
		ImagenPelicula imagenPelicula85 = new ImagenPelicula();
		
		imagenPelicula85.setNombreArchivo("PiratasDelCaribe.jpg");
		
		imagenPelicula85.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/PiratasDelCaribe.jpg")));
		
		pelicula85.setImagenPelicula(imagenPelicula85);
		
	    List<Genero> generosPelicula85 = new ArrayList<>();
	    
	    generosPelicula85.add(generosGuardados.get(0));
	    
	    generosPelicula85.add(generosGuardados.get(1));
	    
	    generosPelicula85.add(generosGuardados.get(6));
	    	    
	    pelicula85.setGeneros(generosPelicula85);
	    
	    peliculasAGuardar.add(pelicula85);
	    
	    Pelicula pelicula86 = new Pelicula();
		
		pelicula86.setTitulo("Pokemon: Detective Pikachu");
		
		pelicula86.setUrlWeb("https://www.imdb.com/title/tt5884052/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_pokemon%2520detective");
		
		ImagenPelicula imagenPelicula86 = new ImagenPelicula();
		
		imagenPelicula86.setNombreArchivo("PokemonDetectivePikachu.jpg");
		
		imagenPelicula86.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/PokemonDetectivePikachu.jpg")));
		
		pelicula86.setImagenPelicula(imagenPelicula86);
		
	    List<Genero> generosPelicula86 = new ArrayList<>();
	    
	    generosPelicula86.add(generosGuardados.get(0));
	    
	    generosPelicula86.add(generosGuardados.get(1));
	    
	    generosPelicula86.add(generosGuardados.get(3));
	    	    
	    pelicula86.setGeneros(generosPelicula86);
	    
	    peliculasAGuardar.add(pelicula86);
	    
	    Pelicula pelicula87 = new Pelicula();
		
		pelicula87.setTitulo("Premonicion");
		
		pelicula87.setUrlWeb("https://www.imdb.com/title/tt0477071/?ref_=nv_sr_srsg_2_tt_8_nm_0_q_premonicion");
		
		ImagenPelicula imagenPelicula87 = new ImagenPelicula();
		
		imagenPelicula87.setNombreArchivo("Preomonicion.jpg");
		
		imagenPelicula87.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Premonicion.jpg")));
		
		pelicula87.setImagenPelicula(imagenPelicula87);
		
	    List<Genero> generosPelicula87 = new ArrayList<>();
	    
	    generosPelicula87.add(generosGuardados.get(4));
	    
	    generosPelicula87.add(generosGuardados.get(6));
	    
	    generosPelicula87.add(generosGuardados.get(8));
	    	    
	    pelicula87.setGeneros(generosPelicula87);
	    
	    peliculasAGuardar.add(pelicula87);
	    
	   Pelicula pelicula88 = new Pelicula();
		
		pelicula88.setTitulo("Pulp Fiction");
		
		pelicula88.setUrlWeb("https://www.imdb.com/title/tt0110912/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_pulp%2520fiction");
		
		ImagenPelicula imagenPelicula88 = new ImagenPelicula();
		
		imagenPelicula88.setNombreArchivo("PulpFiction.jpg");
		
		imagenPelicula88.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/PulpFiction.jpg")));
		
		pelicula88.setImagenPelicula(imagenPelicula88);
		
	    List<Genero> generosPelicula88 = new ArrayList<>();
	    	    
	    generosPelicula88.add(generosGuardados.get(7));
	    
	    generosPelicula88.add(generosGuardados.get(4));
	    	    
	    pelicula88.setGeneros(generosPelicula88);
	    
	    peliculasAGuardar.add(pelicula88);
	    
	  Pelicula pelicula89 = new Pelicula();
		
		pelicula89.setTitulo("Rapido Y Furioso");
		
		pelicula89.setUrlWeb("https://www.imdb.com/title/tt0232500/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_rapido%2520y%2520furioso");
		
		ImagenPelicula imagenPelicula89 = new ImagenPelicula();
		
		imagenPelicula89.setNombreArchivo("RapidoYFurioso.jpg");
		
		imagenPelicula89.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/RapidoYFurioso.jpg")));
		
		pelicula89.setImagenPelicula(imagenPelicula89);
		
	    List<Genero> generosPelicula89 = new ArrayList<>();
	    
	    generosPelicula89.add(generosGuardados.get(0));
	    
	    generosPelicula89.add(generosGuardados.get(7));
	    
	    generosPelicula89.add(generosGuardados.get(10));
	    	    
	    pelicula89.setGeneros(generosPelicula89);
	    
	    peliculasAGuardar.add(pelicula89);
	    
	    Pelicula pelicula90 = new Pelicula();
		
		pelicula90.setTitulo("Rapido Y Furioso 2");
		
		pelicula90.setUrlWeb("https://www.imdb.com/title/tt0322259/?ref_=fn_al_tt_19");
		
		ImagenPelicula imagenPelicula90 = new ImagenPelicula();
		
		imagenPelicula90.setNombreArchivo("RapidoYFurioso2.jpg");
		
		imagenPelicula90.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/RapidoYFurioso2.jpg")));
		
		pelicula90.setImagenPelicula(imagenPelicula90);
		
	    List<Genero> generosPelicula90 = new ArrayList<>();
	    
	    generosPelicula90.add(generosGuardados.get(0));
	    
	    generosPelicula90.add(generosGuardados.get(7));
	    
	    generosPelicula90.add(generosGuardados.get(10));
	    	    
	    pelicula90.setGeneros(generosPelicula90);
	    
	    peliculasAGuardar.add(pelicula90);
	    
	    	    
	    Pelicula pelicula91 = new Pelicula();
		
		pelicula91.setTitulo("Rescatando Al Soldado Ryan");
		
		pelicula91.setUrlWeb("https://www.imdb.com/title/tt0120815/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_rescatan");
		
		ImagenPelicula imagenPelicula91 = new ImagenPelicula();
		
		imagenPelicula91.setNombreArchivo("RescatandoAlSoldadoRyan.jpg");
		
		imagenPelicula91.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/RescatandoAlSoldadoRyan.jpg")));
		
		pelicula91.setImagenPelicula(imagenPelicula91);
		
	    List<Genero> generosPelicula91 = new ArrayList<>();
	    	    
	    generosPelicula91.add(generosGuardados.get(4));
	    
	    generosPelicula91.add(generosGuardados.get(14));
	    	    
	    pelicula91.setGeneros(generosPelicula91);
	    
	    peliculasAGuardar.add(pelicula91);
	    
	    Pelicula pelicula92 = new Pelicula();
		
		pelicula92.setTitulo("Rescate Del Metro 123");
		
		pelicula92.setUrlWeb("https://www.imdb.com/title/tt1111422/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_rescate%2520del%2520metro%2520123");
		
		ImagenPelicula imagenPelicula92 = new ImagenPelicula();
		
		imagenPelicula92.setNombreArchivo("RescateDelMetro123.jpg");
		
		imagenPelicula92.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/RescateDelMetro123.jpg")));
		
		pelicula92.setImagenPelicula(imagenPelicula92);
		
	    List<Genero> generosPelicula92 = new ArrayList<>();
	    
	    generosPelicula92.add(generosGuardados.get(0));
	    
	    generosPelicula92.add(generosGuardados.get(7));
	    
	    generosPelicula92.add(generosGuardados.get(10));
	    	    
	    pelicula92.setGeneros(generosPelicula92);
	    
	    peliculasAGuardar.add(pelicula92);
	    
	    Pelicula pelicula93 = new Pelicula();
		
		pelicula93.setTitulo("Resident Evil 1");
		
		pelicula93.setUrlWeb("https://www.imdb.com/title/tt0120804/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_resident%2520evil");
		
		ImagenPelicula imagenPelicula93 = new ImagenPelicula();
		
		imagenPelicula93.setNombreArchivo("ResidentEvil1.jpg");
		
		imagenPelicula93.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ResidentEvil1.jpg")));
		
		pelicula93.setImagenPelicula(imagenPelicula93);
		
	    List<Genero> generosPelicula93 = new ArrayList<>();
	    
	    generosPelicula93.add(generosGuardados.get(0));
	    
	    generosPelicula93.add(generosGuardados.get(5));
	    
	    generosPelicula93.add(generosGuardados.get(2));
	    	    
	    pelicula93.setGeneros(generosPelicula93);
	    
	    peliculasAGuardar.add(pelicula93);
	    
	    Pelicula pelicula94 = new Pelicula();
		
		pelicula94.setTitulo("Resident Evil 2");
		
		pelicula94.setUrlWeb("https://www.imdb.com/title/tt0318627/?ref_=fn_al_tt_1");
		
		ImagenPelicula imagenPelicula94 = new ImagenPelicula();
		
		imagenPelicula94.setNombreArchivo("ResidentEvil2.jpg");
		
		imagenPelicula94.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ResidentEvil2.jpg")));
		
		pelicula94.setImagenPelicula(imagenPelicula94);
		
	    List<Genero> generosPelicula94 = new ArrayList<>();
	    
	    generosPelicula94.add(generosGuardados.get(0));
	    
	    generosPelicula94.add(generosGuardados.get(5));
	    
	    generosPelicula94.add(generosGuardados.get(2));
	    	    
	    pelicula94.setGeneros(generosPelicula94);
	    
	    peliculasAGuardar.add(pelicula94);
	    
	    Pelicula pelicula95 = new Pelicula();
		
		pelicula95.setTitulo("Resident Evil 4");
		
		pelicula95.setUrlWeb("https://www.imdb.com/title/tt1220634/?ref_=fn_al_tt_2");
		
		ImagenPelicula imagenPelicula95 = new ImagenPelicula();
		
		imagenPelicula95.setNombreArchivo("ResidentEvil4.jpg");
		
		imagenPelicula95.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ResidentEvil4.jpg")));
		
		pelicula95.setImagenPelicula(imagenPelicula95);
		
	    List<Genero> generosPelicula95 = new ArrayList<>();
	    
	    generosPelicula95.add(generosGuardados.get(0));
	    
	    generosPelicula95.add(generosGuardados.get(5));
	    
	    generosPelicula95.add(generosGuardados.get(2));
	    	    
	    pelicula95.setGeneros(generosPelicula95);
	    
	    peliculasAGuardar.add(pelicula95);
	    
	    Pelicula pelicula96 = new Pelicula();
		
		pelicula96.setTitulo("Scary Movie");
		
		pelicula96.setUrlWeb("https://www.imdb.com/title/tt0175142/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_scary%2520movie");
		
		ImagenPelicula imagenPelicula96 = new ImagenPelicula();
		
		imagenPelicula96.setNombreArchivo("ScaryMovie.jpg");
		
		imagenPelicula96.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ScaryMovie.jpg")));
		
		pelicula96.setImagenPelicula(imagenPelicula96);
		
	    List<Genero> generosPelicula96 = new ArrayList<>();
	    	    	    
	    generosPelicula96.add(generosGuardados.get(3));
	    	    
	    pelicula96.setGeneros(generosPelicula96);
	    
	    peliculasAGuardar.add(pelicula96);
	    
	    Pelicula pelicula97 = new Pelicula();
		
		pelicula97.setTitulo("Scream");
		
		pelicula97.setUrlWeb("https://www.imdb.com/title/tt0117571/?ref_=nv_sr_srsg_1_tt_7_nm_0_q_scream");
		
		ImagenPelicula imagenPelicula97 = new ImagenPelicula();
		
		imagenPelicula97.setNombreArchivo("Scream.jpg");
		
		imagenPelicula97.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Scream.jpg")));
		
		pelicula97.setImagenPelicula(imagenPelicula97);
		
	    List<Genero> generosPelicula97 = new ArrayList<>();
	    
	    generosPelicula97.add(generosGuardados.get(5));
	    
	    generosPelicula97.add(generosGuardados.get(8));
	    	    	    
	    pelicula97.setGeneros(generosPelicula97);
	    
	    peliculasAGuardar.add(pelicula97);
	    
	    Pelicula pelicula98 = new Pelicula();
		
		pelicula98.setTitulo("Se Busca");
		
		pelicula98.setUrlWeb("https://www.imdb.com/title/tt0493464/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_wanted");
		
		ImagenPelicula imagenPelicula98 = new ImagenPelicula();
		
		imagenPelicula98.setNombreArchivo("SeBusca.jpg");
		
		imagenPelicula98.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/SeBusca.jpg")));
		
		pelicula98.setImagenPelicula(imagenPelicula98);
		
	    List<Genero> generosPelicula98 = new ArrayList<>();
	    
	    generosPelicula98.add(generosGuardados.get(0));
	    
	    generosPelicula98.add(generosGuardados.get(7));
	    
	    generosPelicula98.add(generosGuardados.get(10));
	    	    
	    pelicula98.setGeneros(generosPelicula98);
	    
	    peliculasAGuardar.add(pelicula98);
	    
	    Pelicula pelicula99 = new Pelicula();
		
		pelicula99.setTitulo("Shrek");
		
		pelicula99.setUrlWeb("https://www.imdb.com/title/tt0126029/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_Shrek");
		
		ImagenPelicula imagenPelicula99 = new ImagenPelicula();
		
		imagenPelicula99.setNombreArchivo("Shrek.jpg");
		
		imagenPelicula99.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Shrek.jpg")));
		
		pelicula99.setImagenPelicula(imagenPelicula99);
		
	    List<Genero> generosPelicula99 = new ArrayList<>();
	    
	    generosPelicula99.add(generosGuardados.get(0));
	    
	    generosPelicula99.add(generosGuardados.get(1));
	    
	    generosPelicula99.add(generosGuardados.get(3));
	    	    
	    pelicula99.setGeneros(generosPelicula99);
	    
	    peliculasAGuardar.add(pelicula99);
	    
	    Pelicula pelicula100 = new Pelicula();
		
		pelicula100.setTitulo("Si Decido Quedarme");
		
		pelicula100.setUrlWeb("https://www.imdb.com/title/tt1355630/?ref_=nv_sr_srsg_0_tt_2_nm_0_q_si%2520decido%2520quedarme");
		
		ImagenPelicula imagenPelicula100 = new ImagenPelicula();
		
		imagenPelicula100.setNombreArchivo("SiDecidoQuedarme.jpg");
		
		imagenPelicula100.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/SiDecidoQuedarme.jpg")));
		
		pelicula100.setImagenPelicula(imagenPelicula100);
		
	    List<Genero> generosPelicula100 = new ArrayList<>();
	    
	    generosPelicula100.add(generosGuardados.get(4));
	    
	    generosPelicula100.add(generosGuardados.get(6));
	    	    	    
	    pelicula100.setGeneros(generosPelicula100);
	    
	    peliculasAGuardar.add(pelicula100);
	     
        Pelicula pelicula101 = new Pelicula();
		
		pelicula101.setTitulo("Si Tuviera 30");
		
		pelicula101.setUrlWeb("https://www.imdb.com/title/tt0337563/?ref_=nv_sr_srsg_0_tt_5_nm_0_q_si%2520tuviera%252030");
		
		ImagenPelicula imagenPelicula101 = new ImagenPelicula();
		
		imagenPelicula101.setNombreArchivo("SiTuviera30.jpg");
		
		imagenPelicula101.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/SiTuviera30.jpg")));
		
		pelicula101.setImagenPelicula(imagenPelicula101);
		
	    List<Genero> generosPelicula101 = new ArrayList<>();
	    
	    generosPelicula101.add(generosGuardados.get(3));
	    
	    generosPelicula101.add(generosGuardados.get(6));
	    
	    generosPelicula101.add(generosGuardados.get(12));
	    	    	    
	    pelicula101.setGeneros(generosPelicula101);
	    
	    peliculasAGuardar.add(pelicula101);
	  

        Pelicula pelicula102 = new Pelicula();
		
		pelicula102.setTitulo("Sonic: El Erizo");
		
		pelicula102.setUrlWeb("https://www.imdb.com/title/tt3794354/?ref_=nv_sr_srsg_1_tt_5_nm_3_q_sonic%2520");
		
		ImagenPelicula imagenPelicula102 = new ImagenPelicula();
		
		imagenPelicula102.setNombreArchivo("SonicElErizo.jpg");
		
		imagenPelicula102.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/SonicElErizo.jpg")));
		
		pelicula102.setImagenPelicula(imagenPelicula102);
		
	    List<Genero> generosPelicula102 = new ArrayList<>();
	    
	    generosPelicula102.add(generosGuardados.get(0));
	    
	    generosPelicula102.add(generosGuardados.get(1));
	    
	    generosPelicula102.add(generosGuardados.get(3));
	    	    	    
	    pelicula102.setGeneros(generosPelicula102);
	    
	    peliculasAGuardar.add(pelicula102);
	    
	   
	    Pelicula pelicula103 = new Pelicula();
		
		pelicula103.setTitulo("Lo Imposible");
		
		pelicula103.setUrlWeb("https://www.imdb.com/title/tt1649419/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_lo%2520imp");
		
		ImagenPelicula imagenPelicula103 = new ImagenPelicula();
		
		imagenPelicula103.setNombreArchivo("TheImpossible.jpg");
		
		imagenPelicula103.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/TheImpossible.jpg")));
		
		pelicula103.setImagenPelicula(imagenPelicula103);
		
	    List<Genero> generosPelicula103 = new ArrayList<>();
	    
	    generosPelicula103.add(generosGuardados.get(4));
	    
	    generosPelicula103.add(generosGuardados.get(13));
	    
	    generosPelicula103.add(generosGuardados.get(10));
	    	    	    
	    pelicula103.setGeneros(generosPelicula103);
	    
	    peliculasAGuardar.add(pelicula103);
	    
	   
	    
	    Pelicula pelicula104 = new Pelicula();
		
		pelicula104.setTitulo("Desde Mi Cielo");
		
		pelicula104.setUrlWeb("https://www.imdb.com/title/tt0380510/?ref_=nv_sr_srsg_0_tt_3_nm_0_q_desde%2520mi%2520cielo");
		
		ImagenPelicula imagenPelicula104 = new ImagenPelicula();
		
		imagenPelicula104.setNombreArchivo("TheLovelyBones.jpg");
		
		imagenPelicula104.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/TheLovelyBones.jpg")));
		
		pelicula104.setImagenPelicula(imagenPelicula104);
		
	    List<Genero> generosPelicula104 = new ArrayList<>();
	    
	    generosPelicula104.add(generosGuardados.get(4));
	    
	    generosPelicula104.add(generosGuardados.get(6));
	    
	    generosPelicula104.add(generosGuardados.get(10));
	    	    	    
	    pelicula104.setGeneros(generosPelicula104);
	    
	    peliculasAGuardar.add(pelicula104);
	    
	   
	    Pelicula pelicula105 = new Pelicula();
		
		pelicula105.setTitulo("Las Virgenes Suicidas");
		
		pelicula105.setUrlWeb("https://www.imdb.com/title/tt0159097/?ref_=nv_sr_srsg_0_tt_1_nm_0_q_las%2520virgenes%2520suicidas");
		
		ImagenPelicula imagenPelicula105 = new ImagenPelicula();
		
		imagenPelicula105.setNombreArchivo("TheVirginSuicides.jpg");
		
		imagenPelicula105.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/TheVirginSuicides.jpg")));
		
		pelicula105.setImagenPelicula(imagenPelicula105);
		
	    List<Genero> generosPelicula105 = new ArrayList<>();
	    
	    generosPelicula105.add(generosGuardados.get(4));
	    	    
	    generosPelicula105.add(generosGuardados.get(12));
	    	    	    
	    pelicula105.setGeneros(generosPelicula105);
	    
	    peliculasAGuardar.add(pelicula105);
	    
	   
	    Pelicula pelicula106 = new Pelicula();
		
		pelicula106.setTitulo("Titanic");
		
		pelicula106.setUrlWeb("https://www.imdb.com/title/tt0120338/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_titanic");
		
		ImagenPelicula imagenPelicula106 = new ImagenPelicula();
		
		imagenPelicula106.setNombreArchivo("Titanic.jpg");
		
		imagenPelicula106.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Titanic.jpg")));
		
		pelicula106.setImagenPelicula(imagenPelicula106);
		
	    List<Genero> generosPelicula106 = new ArrayList<>();
	    
	    generosPelicula106.add(generosGuardados.get(4));
	    
	    generosPelicula106.add(generosGuardados.get(12));
	    	    	    	    
	    pelicula106.setGeneros(generosPelicula106);
	    
	    peliculasAGuardar.add(pelicula106);
	    
	   
	    Pelicula pelicula107 = new Pelicula();
		
		pelicula107.setTitulo("Top Gun");
		
		pelicula107.setUrlWeb("https://www.imdb.com/title/tt0092099/?ref_=nv_sr_srsg_3_tt_7_nm_1_q_top%2520gun");
		
		ImagenPelicula imagenPelicula107 = new ImagenPelicula();
		
		imagenPelicula107.setNombreArchivo("TopGun.jpg");
		
		imagenPelicula107.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/TopGun.jpg")));
		
		pelicula107.setImagenPelicula(imagenPelicula107);
		
	    List<Genero> generosPelicula107 = new ArrayList<>();
	    
	    generosPelicula107.add(generosGuardados.get(0));
	    
	    generosPelicula107.add(generosGuardados.get(4));
	    	    	    	    
	    pelicula107.setGeneros(generosPelicula107);
	    
	    peliculasAGuardar.add(pelicula107);
	    
	    
	    Pelicula pelicula108 = new Pelicula();
		
		pelicula108.setTitulo("Toy Story");
		
		pelicula108.setUrlWeb("https://www.imdb.com/title/tt0114709/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_toy%2520story");
		
		ImagenPelicula imagenPelicula108 = new ImagenPelicula();
		
		imagenPelicula108.setNombreArchivo("ToyStory.jpg");
		
		imagenPelicula108.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/ToyStory.jpg")));
		
		pelicula108.setImagenPelicula(imagenPelicula108);
		
	    List<Genero> generosPelicula108 = new ArrayList<>();
	    
	    generosPelicula108.add(generosGuardados.get(9));
	    
	    generosPelicula108.add(generosGuardados.get(1));
	    
	    generosPelicula108.add(generosGuardados.get(3));
	    	    	    
	    pelicula108.setGeneros(generosPelicula108);
	    
	    peliculasAGuardar.add(pelicula108);
	    
	   
	    Pelicula pelicula109 = new Pelicula();
		
		pelicula109.setTitulo("Transformers");
		
		pelicula109.setUrlWeb("https://www.imdb.com/title/tt0418279/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_transformers");
		
		ImagenPelicula imagenPelicula109 = new ImagenPelicula();
		
		imagenPelicula109.setNombreArchivo("Transformers.jpg");
		
		imagenPelicula109.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Transformers.jpg")));
		
		pelicula109.setImagenPelicula(imagenPelicula109);
		
	    List<Genero> generosPelicula109 = new ArrayList<>();
	    
	    generosPelicula109.add(generosGuardados.get(0));
	    
	    generosPelicula109.add(generosGuardados.get(1));
	    
	    generosPelicula109.add(generosGuardados.get(2));
	    	    	    
	    pelicula109.setGeneros(generosPelicula109);
	    
	    peliculasAGuardar.add(pelicula109);
	    
	   
	    Pelicula pelicula110 = new Pelicula();
		
		pelicula110.setTitulo("Una Loca Pelicula Epica");
		
		pelicula110.setUrlWeb("https://www.imdb.com/title/tt0799949/?ref_=nv_sr_srsg_0_tt_5_nm_0_q_una%2520loca%2520pelicula%2520epica");
		
		ImagenPelicula imagenPelicula110 = new ImagenPelicula();
		
		imagenPelicula110.setNombreArchivo("UnaLocaPeliculaEpica.jpg");
		
		imagenPelicula110.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/UnaLocaPeliculaEpica.jpg")));
		
		pelicula110.setImagenPelicula(imagenPelicula110);
		
	    List<Genero> generosPelicula110 = new ArrayList<>();
	    
	    generosPelicula110.add(generosGuardados.get(1));
	    
	    generosPelicula110.add(generosGuardados.get(3));
	    
	    generosPelicula110.add(generosGuardados.get(6));
	    	    	    
	    pelicula110.setGeneros(generosPelicula110);
	    
	    peliculasAGuardar.add(pelicula110);
	    
	    
	    Pelicula pelicula111 = new Pelicula();
		
		pelicula111.setTitulo("Un Viernes De Locos");
		
		pelicula111.setUrlWeb("https://www.imdb.com/title/tt0322330/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_un%2520viernes%2520de%2520locos");
		
		ImagenPelicula imagenPelicula111 = new ImagenPelicula();
		
		imagenPelicula111.setNombreArchivo("UnViernesDeLocos.jpg");
		
		imagenPelicula111.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/UnViernesDeLocos.jpg")));
		
		pelicula111.setImagenPelicula(imagenPelicula111);
		
	    List<Genero> generosPelicula111 = new ArrayList<>();
	    
	    generosPelicula111.add(generosGuardados.get(3));
	    
	    generosPelicula111.add(generosGuardados.get(6));
	    	    	    	    
	    pelicula111.setGeneros(generosPelicula111);
	    
	    peliculasAGuardar.add(pelicula111);
	    
	    
	    Pelicula pelicula112 = new Pelicula();
		
		pelicula112.setTitulo("Vanilla Sky");
		
		pelicula112.setUrlWeb("https://www.imdb.com/title/tt0259711/?ref_=nv_sr_srsg_0_tt_5_nm_3_q_vanilla%2520sky");
		
		ImagenPelicula imagenPelicula112 = new ImagenPelicula();
		
		imagenPelicula112.setNombreArchivo("VanillaSky.jpg");
		
		imagenPelicula112.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/VanillaSky.jpg")));
		
		pelicula112.setImagenPelicula(imagenPelicula112);
		
	    List<Genero> generosPelicula112 = new ArrayList<>();
	    
	    generosPelicula112.add(generosGuardados.get(6));
	    
	    generosPelicula112.add(generosGuardados.get(8));
	    
	    generosPelicula112.add(generosGuardados.get(12));
	    	    	    
	    pelicula112.setGeneros(generosPelicula112);
	    
	    peliculasAGuardar.add(pelicula112);
	    
	   
	    Pelicula pelicula113 = new Pelicula();
		
		pelicula113.setTitulo("Volver Al Futuro");
		
		pelicula113.setUrlWeb("https://www.imdb.com/title/tt0088763/?ref_=nv_sr_srsg_0_tt_5_nm_0_q_volver%2520al%2520futut");
		
		ImagenPelicula imagenPelicula113 = new ImagenPelicula();
		
		imagenPelicula113.setNombreArchivo("VolverAlFuturo.jpg");
		
		imagenPelicula113.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/VolverAlFuturo.jpg")));
		
		pelicula113.setImagenPelicula(imagenPelicula113);
		
	    List<Genero> generosPelicula113 = new ArrayList<>();
	    
	    generosPelicula113.add(generosGuardados.get(1));
	    
	    generosPelicula113.add(generosGuardados.get(3));
	    
	    generosPelicula113.add(generosGuardados.get(2));
	    	    	    
	    pelicula113.setGeneros(generosPelicula113);
	    
	    peliculasAGuardar.add(pelicula113);
	    
	   
	    Pelicula pelicula114 = new Pelicula();
		
		pelicula114.setTitulo("X-Men");
		
		pelicula114.setUrlWeb("https://www.imdb.com/title/tt0120903/?ref_=nv_sr_srsg_3_tt_8_nm_0_q_x%2520men");
		
		ImagenPelicula imagenPelicula114 = new ImagenPelicula();
		
		imagenPelicula114.setNombreArchivo("XMen.jpg");
		
		imagenPelicula114.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/XMen.jpg")));
		
		pelicula114.setImagenPelicula(imagenPelicula114);
		
	    List<Genero> generosPelicula114 = new ArrayList<>();
	    
	    generosPelicula114.add(generosGuardados.get(0));
	    
	    generosPelicula114.add(generosGuardados.get(1));
	    
	    generosPelicula114.add(generosGuardados.get(2));
	    	    	    
	    pelicula114.setGeneros(generosPelicula114);
	    
	    peliculasAGuardar.add(pelicula114);
	    
	    
	    Pelicula pelicula115 = new Pelicula();
		
		pelicula115.setTitulo("¿Y Donde Estan Las Rubias?");
		
		pelicula115.setUrlWeb("https://www.imdb.com/title/tt0381707/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_y%2520donde%2520estan%2520las%2520rubias");
		
		ImagenPelicula imagenPelicula115 = new ImagenPelicula();
		
		imagenPelicula115.setNombreArchivo("YDondeEstanLasRubias.jpg");
		
		imagenPelicula115.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/YDondeEstanLasRubias.jpg")));
		
		pelicula115.setImagenPelicula(imagenPelicula115);
		
	    List<Genero> generosPelicula115 = new ArrayList<>();
	    
	    generosPelicula115.add(generosGuardados.get(3));
	    
	    generosPelicula115.add(generosGuardados.get(7));
	    	    	    	    
	    pelicula115.setGeneros(generosPelicula115);
	    
	    peliculasAGuardar.add(pelicula115);
	    
	  
	    Pelicula pelicula116 = new Pelicula();
		
		pelicula116.setTitulo("Se Lo Que Hicieron El Verano Pasado");
		
		pelicula116.setUrlWeb("https://www.imdb.com/title/tt0119345/?ref_=nv_sr_srsg_4_tt_8_nm_0_q_se%2520lo%2520que%2520");
		
		ImagenPelicula imagenPelicula116 = new ImagenPelicula();
		
		imagenPelicula116.setNombreArchivo("SeLoQueHicieronElVeranoPasado.jpg");
		
		imagenPelicula116.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/SeLoQueHicieronElVeranoPasado.jpg")));
		
		pelicula116.setImagenPelicula(imagenPelicula116);
		
	    List<Genero> generosPelicula116 = new ArrayList<>();
	    
	    generosPelicula116.add(generosGuardados.get(5));
	    
	    generosPelicula116.add(generosGuardados.get(8));
	    	    	    	    
	    pelicula116.setGeneros(generosPelicula116);
	    
	    peliculasAGuardar.add(pelicula116);
	    
	   
	    Pelicula pelicula117 = new Pelicula();
		
		pelicula117.setTitulo("Tomb Raider");
		
		pelicula117.setUrlWeb("https://www.imdb.com/title/tt0146316/?ref_=nv_sr_srsg_3_tt_8_nm_0_q_tomb%2520raider");
		
		ImagenPelicula imagenPelicula117 = new ImagenPelicula();
		
		imagenPelicula117.setNombreArchivo("TombRaider.jpg");
		
		imagenPelicula117.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/TombRaider.jpg")));
		
		pelicula117.setImagenPelicula(imagenPelicula117);
		
	    List<Genero> generosPelicula117 = new ArrayList<>();
	    
	    generosPelicula117.add(generosGuardados.get(0));
	    
	    generosPelicula117.add(generosGuardados.get(1));
	    
	    generosPelicula117.add(generosGuardados.get(6));
	    	    	    
	    pelicula117.setGeneros(generosPelicula117);
	    
	    peliculasAGuardar.add(pelicula117);
	    
	   
	    Pelicula pelicula118 = new Pelicula();
		
		pelicula118.setTitulo("Oblivion");
		
		pelicula118.setUrlWeb("https://www.imdb.com/title/tt1483013/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_oblivion");
		
		ImagenPelicula imagenPelicula118 = new ImagenPelicula();
		
		imagenPelicula118.setNombreArchivo("Oblivion.jpg");
		
		imagenPelicula118.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Oblivion.jpg")));
		
		pelicula118.setImagenPelicula(imagenPelicula118);
		
	    List<Genero> generosPelicula118 = new ArrayList<>();
	    
	    generosPelicula118.add(generosGuardados.get(0));
	    
	    generosPelicula118.add(generosGuardados.get(1));
	    
	    generosPelicula118.add(generosGuardados.get(2));
	    	    	    
	    pelicula118.setGeneros(generosPelicula118);
	    
	    peliculasAGuardar.add(pelicula118);
	    
	   
	    Pelicula pelicula119 = new Pelicula();
		
		pelicula119.setTitulo("Ultravioleta");
		
		pelicula119.setUrlWeb("https://www.imdb.com/title/tt0370032/?ref_=nv_sr_srsg_2_tt_8_nm_0_q_ultravioleta");
		
		ImagenPelicula imagenPelicula119 = new ImagenPelicula();
		
		imagenPelicula119.setNombreArchivo("Ultravioleta.jpg");
		
		imagenPelicula119.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/Ultravioleta.jpg")));
		
		pelicula119.setImagenPelicula(imagenPelicula119);
		
	    List<Genero> generosPelicula119 = new ArrayList<>();
	    
	    generosPelicula119.add(generosGuardados.get(0));
	    	    
	    generosPelicula119.add(generosGuardados.get(2));
	    	    	    
	    pelicula119.setGeneros(generosPelicula119);
	    
	    peliculasAGuardar.add(pelicula119);
	    
	   
	    Pelicula pelicula120 = new Pelicula();
		
		pelicula120.setTitulo("La Isla");
		
		pelicula120.setUrlWeb("https://www.imdb.com/title/tt0399201/?ref_=fn_al_tt_1");
		
		ImagenPelicula imagenPelicula120 = new ImagenPelicula();
		
		imagenPelicula120.setNombreArchivo("LaIsla.jpg");
		
		imagenPelicula120.setImagen(mapperFiles.inputStreamToBytesArray(getClass().getResourceAsStream("./resources/LaIsla.jpg")));
		
		pelicula120.setImagenPelicula(imagenPelicula120);
		
	    List<Genero> generosPelicula120 = new ArrayList<>();
	    
	    generosPelicula120.add(generosGuardados.get(0));
	    
	    generosPelicula120.add(generosGuardados.get(2));
	    
	    generosPelicula120.add(generosGuardados.get(10));
	    	    	    
	    pelicula120.setGeneros(generosPelicula120);
	    
	    peliculasAGuardar.add(pelicula120);

	    
	    for(Pelicula p : peliculasAGuardar) {
	    	
	    	peliculaRepository.save(p);
	    	
	    }
	    
	    assertThat(peliculaRepository.findAll().size()).isEqualTo(120);
 

				
	}
	
	
	
	

}
