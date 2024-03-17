package com.paredesfederico.security.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.paredesfederico.security.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter{
	
	@Autowired
	private final UserDetailsService userDetailsService;
	
	@Autowired
	private final JWTService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	final String authHeader = request.getHeader("Authorization");
	final String jwToken;
	final String userName;
	
	if(authHeader == null || !authHeader.startsWith("Bearer")) {
		filterChain.doFilter(request, response);
		return;
		
		
	}
	
	
	jwToken = authHeader.substring(7);
	
	userName = jwtService.getUserName(jwToken);
	
	if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		
		boolean isTokenValidate = jwtService.validateToken(jwToken, userDetails);
		
		if(isTokenValidate) {
			
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
	}
	
	filterChain.doFilter(request, response);
	
	
	
	}












}
