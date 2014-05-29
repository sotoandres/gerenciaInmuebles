package com.muebles.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDao {

	public boolean validarUsuario(Usuario usuario) {
		
		boolean resp = false;

		Conexion conexion = new Conexion();
		try {
			Connection con = conexion.getInstance().crearConexion();
			Statement st = con.createStatement();
			String sql = "SELECT COUNT(1) FROM USUARIOS WHERE usuario ="
					+ usuario.getUsuario() + " and password ="
					+ usuario.getPassword();
			ResultSet res = st.executeQuery(sql);
			if (res.next()) {
				if (res.getInt(1)!=0) {
					resp = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConn();
		}
		return resp;

	}

	public void guardar(Usuario usuario) {
		Conexion conexion = new Conexion();
		try {
			Connection con = conexion.getInstance().crearConexion();
			Statement st = con.createStatement();

			String sql = "INSERT INTO USUARIOS ( USUARIO, PASSWORD, NOMBRES, APELLIDOS, EMAIL) VALUES ('"
					+ usuario.getUsuario()
					+ "','"
					+ usuario.getPassword()
					+ "','"
					+ usuario.getNombres()
					+ "','"
					+ usuario.getApellidos()
					+ "','"
					+ usuario.getEmail()
					+ "')";

			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}

}
