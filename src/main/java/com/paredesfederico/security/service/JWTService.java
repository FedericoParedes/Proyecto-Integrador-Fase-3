package com.paredesfederico.security.service;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	private static final String SECRET_KEY ="Tm92YWtEam9rb3ZpY1JhZmFlbE5hZGFsUm9nZXJGZWRlcmVyQW5keU11cnJheUp1YW5NYXJ0aW5EZWxQb3Ryb0tlaU5pc2hpa29yaU1hcmluQ2lsaWNTdGFuV2F3cmlua2FBbGV4YW5kZXJadmVyZXZEYW5paWxNZWR2ZWRldlN0ZWZhbm9zVHNpdHNpcGFzTWF0ZW9CZXJyZXRpbmlDYXNwZXJSdXVkQW5kcmV5UnVibGV2RmVsaXhBdWdlckFsaWFzc2ltZUdyaWdvckRpbWl0cm92S2V2aW5BbmRlcnNvbkRlbmlzU2hhcG92YWxvdkhvbGdlclJ1bmVDYXJsb3NBbGNhcmF6SmFubmlrU2lubmVy";
	
	
	public String getUserName(String token) {
		
		return getClaim(token, Claims::getSubject);
		
	}


	private <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
		// TODO Auto-generated method stub
		final Claims claims = getAllClaims(token);
		
		return claimsResolver.apply(claims);
	}


	private Claims getAllClaims(String token) {
		
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
				/*.build()
				.parseClaimsJws(token)
				.getBody();*/
				
				
				
	}


	private Key getSigningKey() {
		
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		
		return Keys.hmacShaKeyFor(keyBytes);
	}

	
	public boolean validateToken(String token, UserDetails userDetails) {
		
		
		final String userName = getUserName(token);
		
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
		
	}


	private boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return getExpiration(token).before(new Date());
	}


	private Date getExpiration(String token) {
		// TODO Auto-generated method stub
		return getClaim(token, Claims::getExpiration);
	}
	
	
	
	public String generateToken(UserDetails userDetails) {
		
		final Map<String, Object> claims = Collections.singletonMap("ROLES", userDetails.getAuthorities().toString());
		
		return generateToken(claims, userDetails);
		
	}
	
	
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		
		 return Jwts.builder().setClaims(extraClaims)
				 .setSubject(userDetails.getUsername())
				 .setIssuedAt(new Date(System.currentTimeMillis()))
				 .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
				 .signWith(getSigningKey(),SignatureAlgorithm.HS256)
				 .compact();			  		
		
	}
	
	 
	
	
	
	
}
