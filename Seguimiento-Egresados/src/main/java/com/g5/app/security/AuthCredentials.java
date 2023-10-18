package com.g5.app.security;

public class AuthCredentials {

	private String dni;
	private String password;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthCredentials(String dni, String password) {
		this.dni = dni;
		this.password = password;
	}
	
	public AuthCredentials() {}
	
	
	
}
