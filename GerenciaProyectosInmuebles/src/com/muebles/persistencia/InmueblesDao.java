package com.muebles.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InmueblesDao {
/*cambiar en el modelo entidad relacion en la tabla inmuebles los tipos de los siguientes campos
 * `agua` varchar(2) NOT NULL,
  `luz` varchar(2) NOT NULL,
  `gas` varchar(2) NOT NULL,
 * */
	public void crearInmueble(Inmuebles Inm) {
		Conexion conexion = new Conexion();
		try {
			Connection connection=conexion.getInstance().crearConexion();
			Statement st = connection.createStatement();

			String sql = "INSERT INTO INMUEBLE ( TIPO, DIRECCION, ESTRATO, AGUA, LUZ, GAS, TELEFONO, REPARACIONES, MEJORAS, NOVEDADES, INVERSIONES, URL, IDPAGO) VALUES ('"
					+ Inm.getINMVENOARR()
					+ "','"
					+ Inm.getINMDIR()
					+ "','"
					+ Inm.getINMESTRATO()
					+ "','"
					+ Inm.getINMAGUA()
					+ "','"
					+ Inm.getINMLUZ()
					+ "','"
					+ Inm.getINMGAS()
					+ "','"
					+ Inm.getINMTEL()
					+ "','"
					+ Inm.getINMREPARA()
					+ "','"
					+ Inm.getIMNMEJORA()
					+ "','"
					+ Inm.getINMNOVED()
					+ "','"
					+ Inm.getINMINVERSI()
					+ "','"
					+ Inm.getINMURL()
					+ "','"
					+ Inm.getINMIDPAGO()
					+ "')";

			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}

	}
	
	public List<Inmuebles> consultarInmueble(int Inm) {
		ArrayList inmueble = null;
		Conexion conexion = new Conexion();
		Inmuebles inmuebles = null;
		String idImnueble = "";
		idImnueble.valueOf(Inm);
		try {
			Connection connection= conexion.getInstance().crearConexion();
			Statement comando = connection.createStatement();
			String sql = "SELECT * FROM INMUEBLE WHERE id = '"+ idImnueble.trim() +"'";
					
			
			ResultSet res = comando.executeQuery(sql);
			inmueble = new ArrayList();
			while (res.next()) {
				
				inmuebles = new Inmuebles();
				
				inmuebles.setINMVENOARR(res.getString(1));
				inmuebles.setINMDIR(res.getString(2));
				inmuebles.setINMESTRATO(res.getInt(3));
				inmuebles.setINMAGUA(res.getString(4));
				inmuebles.setINMLUZ(res.getString(5));
				inmuebles.setINMGAS(res.getString(6));
				inmuebles.setINMTEL(res.getString(7));
				inmuebles.setINMREPARA(res.getString(8));
				inmuebles.setIMNMEJORA(res.getString(9));
				inmuebles.setINMNOVED(res.getString(10));
				inmuebles.setINMINVERSI(res.getString(11));
				inmuebles.setINMURL(res.getString(12));
				inmuebles.setINMIDPAGO(res.getInt(13));
				inmueble.add(inmuebles);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}
		return inmueble;

	}
	
	
	public boolean deleteInmueble(int codInmueble){
		Conexion conexion = new Conexion();	
		boolean result = false;
		PreparedStatement preparedStmt = null;
		try {
			Connection connection= conexion.getInstance().crearConexion();
			Statement comando = connection.createStatement();
			String sql = "DELETE  FROM INMUEBLE WHERE id = ? ";
			preparedStmt = connection.prepareStatement(sql);
			preparedStmt.setInt(1, codInmueble);       
	        preparedStmt.executeUpdate();
	        result = true;
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}
		return result;

		
	}
	
	public boolean updateInmueble(Inmuebles Inm){
		Conexion conexion = new Conexion();	
		boolean result = false;
		PreparedStatement preparedStmt = null;
		try {
			Connection connection= conexion.getInstance().crearConexion();
			Statement comando = connection.createStatement();
			String sql = "UPDATE INMUEBLE SET tipo = ? , direccion = ? , estrato = ? , agua = ? ,"
					+ " luz = ? , gas = ? , telefono = ? , reparaciones = ? , mejoras = ? ,"
					+ " novedades = ? , inversiones = ? , url = ? , idPago = ?   WHERE id = ? ";
			preparedStmt = connection.prepareStatement(sql);
			preparedStmt.setString(1, Inm.getINMVENOARR()); 
			preparedStmt.setString(2, Inm.getINMDIR()); 
			preparedStmt.setInt(3, Inm.getINMESTRATO()); 
			preparedStmt.setString(4, Inm.getINMAGUA()); 
			preparedStmt.setString(5, Inm.getINMLUZ()); 
			preparedStmt.setString(6, Inm.getINMGAS()); 
			preparedStmt.setString(7, Inm.getINMTEL()); 
			preparedStmt.setString(8, Inm.getINMREPARA()); 
			preparedStmt.setString(9, Inm.getIMNMEJORA()); 
			preparedStmt.setString(10, Inm.getINMNOVED()); 
			preparedStmt.setString(11, Inm.getINMINVERSI()); 
			preparedStmt.setString(12, Inm.getINMURL()); 
			preparedStmt.setInt(13, Inm.getINMIDPAGO()); 
	        preparedStmt.executeUpdate();
	        result = true;
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.getInstance().cerrarConn();
		}
		return result;

		
	}


}
