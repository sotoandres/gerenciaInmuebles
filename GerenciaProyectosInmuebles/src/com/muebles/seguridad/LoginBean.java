/**
 * LoginBean.java
 * 
 */

package com.muebles.seguridad;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;

import com.muebles.persistencia.Usuario;
import com.muebles.persistencia.UsuarioDao;

public class LoginBean {
	private String name;
	private String user;
	private String password;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public void validar(ActionEvent event) {
		if (event.getComponent().getId().equals("validarId")) {
			try {
				FacesContext context = 	FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context
						.getExternalContext().getResponse();
				Usuario us = new Usuario();
				UsuarioDao dao = new UsuarioDao();
				us.setUsuario(this.user);
				us.setPassword(this.password);
				if (dao.validarUsuario(us)) {
					response.sendRedirect("/webProject/faces/welcome.xhtml");
				}
				else{
					response.sendRedirect("/webProject/faces/logins.xhtml");			
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

}
