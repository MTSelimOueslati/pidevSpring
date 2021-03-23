package com.esprit.tn.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.esprit.tn.entities.User;
import com.esprit.tn.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private UserRepository userRep;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager,UserRepository userRep) {
		this.authenticationManager = authenticationManager;
		this.userRep = userRep;
	}
	
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		// TODO Auto-generated constructor stub
	

	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			User user = new ObjectMapper().readValue(request.getInputStream(),User.class);
			
			return authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),new ArrayList<>()));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		User user=(User)authResult.getPrincipal();
		User user1 = userRep.findByName(user.getUsername());
		List<String> roles=new ArrayList<>();
		authResult.getAuthorities().forEach(a->{
			roles.add(a.getAuthority());
		});
		String jwt= JWT.create()
				.withIssuer(request.getRequestURI())
				.withSubject(user.getUsername())
				.withArrayClaim("roles", roles.toArray(new String[roles.size()]))
				.withClaim("verified", user1.isVerified())
				.withExpiresAt(new Date(System.currentTimeMillis()+10*24*3600*1000))
				.sign(Algorithm.HMAC256("YOUR KEY"));
		response.addHeader("Authorization", jwt);
	}
	
}
