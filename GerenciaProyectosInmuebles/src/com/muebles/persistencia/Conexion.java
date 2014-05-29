/**
 * 
 */
package com.muebles.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author dfnietop
 * 
 */
public class Conexion {
	private Connection conexion = null;

	public Conexion() {
		crearConexion();
	}

	private static Conexion instance = new Conexion();

	public Connection crearConexion() {

		try {
//			Properties propiedades = new Properties();
//			propiedades.load(new FileInputStream(
//					"/PersistenceResource.properties"));
//
//			this.bd = propiedades.getProperty("bd");
//			this.url = propiedades.getProperty("url");
//			this.pass = propiedades.getProperty("pass");
//			this.ususario = propiedades.getProperty("usuario");

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/gerencia","root", "Admin*1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;

	}

	public void cerrarConn() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Conexion getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return new Conexion();
		}

	}

}
