package com.paredesfederico.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.paredesfederico.entidades.Rol;
import com.paredesfederico.entidades.Usuario;
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
	
	
	
	@Override	
	public AuthResponse register(RegisterRequest request) {
	    
		List<Rol> roles = new ArrayList<>();
	    
	    Rol rol = new Rol();
	    
	    rol.setNombreRol("ROLE_USER");
	    
	    roles.add(rol);
	    
	    var user = Usuario.builder()
	    		.email(request.getEmail())
	    		.password(passwordEncoder.encode(request.getPassword()))
	    		.roles(roles)
	    		.build();
	    
	    usuarioRepository.save(user);
	    
	    var jwToken = jwtService.generateToken(user);
	    
	    
		return AuthResponse.builder().token(jwToken).build();
	}



	@Override
	public AuthResponse authenticate(AuthenticationRequest request) {
		
		authenticationManager.authenticate(
				
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		var user = usuarioRepository.findUsuarioByEmail(request.getEmail()).orElseThrow();
		
		var jwtToken = jwtService.generateToken(user);
		
		return AuthResponse.builder().token(jwtToken).build();
	
	}

	
	
	
	
}
