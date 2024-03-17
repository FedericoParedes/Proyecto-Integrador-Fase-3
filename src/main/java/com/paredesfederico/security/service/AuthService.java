package com.paredesfederico.security.service;

import com.paredesfederico.security.dto.AuthResponse;
import com.paredesfederico.security.dto.AuthenticationRequest;
import com.paredesfederico.security.dto.RegisterRequest;

public interface AuthService {

	AuthResponse register (RegisterRequest request);
	
	AuthResponse authenticate (AuthenticationRequest request);
}
