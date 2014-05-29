/**
 * LoginBean.java
 * 
 */

package com.muebles.seguridad;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.muebles.persistencia.Usuario;
import com.muebles.persistencia.UsuarioDao;

public class RegistroBean {
	private String nombre;
	private String apellido;
	private String usuario;
	private String password;
	private String conPassword;
	private String email;
	public String error;
	public boolean bolerr = false;

	public RegistroBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void guardar(ActionEvent ae){
		if(ae.getComponent().getId().equals("guardarRegistroId")){
			if(this.password.equals(this.conPassword)){
				UsuarioDao usuarioDao = new UsuarioDao();
				Usuario usuario = new Usuario();
				usuario.setNombres(this.nombre);
				usuario.setApellidos(this.apellido);
				usuario.setUsuario(this.usuario);
				usuario.setPassword(this.password);
				usuario.setEmail(this.email);
				usuarioDao.guardar(usuario);
			}else{
				
			}
				
			
		}
	}
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getConPassword() {
		return conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isBolerr() {
		return bolerr;
	}

	public void setBolerr(boolean bolerr) {
		this.bolerr = bolerr;
	}
	
	

	
}
