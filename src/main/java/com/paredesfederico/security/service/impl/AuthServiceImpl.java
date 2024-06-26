package com.paredesfederico.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.paredesfederico.entidades.Rol;
import com.paredesfederico.entidades.Usuario;
import com.paredesfederico.enums.TipoRol;
import com.paredesfederico.repository.IRolRepository;
import com.paredesfederico.repository.IUsuarioRepository;
import com.paredesfederico.security.dto.AuthResponse;
import com.paredesfederico.security.dto.AuthenticationRequest;
import com.paredesfederico.security.dto.RegisterRequest;
import com.paredesfederico.security.service.AuthService;
import com.paredesfederico.security.service.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
		
	private final IUsuarioRepository usuarioRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final JWTService jwtService;
	
	private final AuthenticationManager authenticationManager;
	
	private final IRolRepository rolRepository;
	
	
	
	@Override	
	public AuthResponse register(RegisterRequest request) {
	    
		List<Rol> roles = new ArrayList<>();
	    
        Optional<Rol> rol =  rolRepository.findByNombreRol(TipoRol.ROL_USER);
	    
        if(rol.isPresent()){
        	roles.add(rol.get());
        }
	    
	    var user = Usuario.builder()
	    		.email(request.getEmail())
	    		.password(passwordEncoder.encode(request.getPassword()))
	    		.roles(roles)
	    		.build();
	    
	    usuarioRepository.save(user);
	    
	    var jwToken = jwtService.generateToken(user);
	    
	    
		return AuthResponse.builder().token(jwToken).build();
	}


	public AuthResponse authenticate(AuthenticationRequest request) {
		
		authenticationManager.authenticate(
				
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		var user = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
		
		var jwtToken = jwtService.generateToken(user);
		
		return AuthResponse.builder().token(jwtToken).build();
	}

	
	
	
	
}
