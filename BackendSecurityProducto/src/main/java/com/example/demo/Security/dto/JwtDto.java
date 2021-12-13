package com.example.demo.Security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {
	
	private String token;
	private String bearer = "Bearer";
	private String nombreUsusario;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDto(String token, String nombreUsusario, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.token = token;
		this.nombreUsusario = nombreUsusario;
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getNombreUsusario() {
		return nombreUsusario;
	}

	public void setNombreUsusario(String nombreUsusario) {
		this.nombreUsusario = nombreUsusario;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}	

}
