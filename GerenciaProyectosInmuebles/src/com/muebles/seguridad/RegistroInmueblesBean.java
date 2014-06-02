package com.muebles.seguridad;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import com.muebles.persistencia.Conexion;
import com.muebles.persistencia.Inmuebles;
import com.muebles.persistencia.InmueblesDao;
import com.muebles.persistencia.Usuario;

public class RegistroInmueblesBean extends Inmuebles{

	private String ususario;
	private String pass;
	private String url;
	private String bd;
	private static Connection conexion = null;
	private static RegistroInmueblesBean registro = new RegistroInmueblesBean();
	private Usuario id = new Usuario();
	ArrayList lista = new ArrayList();
	private String nombre;
	private String direccion;
	private String telefono;
	private String VentOArr;
	private String TipNeg;
	private String Comments;
	private String idusuario;

	public RegistroInmueblesBean() {
		super();
	}
	
	/*Metodo que llama al dao de inmuebles para insertar un nuevo inmuebles
	 * */

	public void registroInmuebles() {
		
		Inmuebles	inmuebles = new Inmuebles();
		InmueblesDao insertarInmuebles = new InmueblesDao();
		inmuebles.setINMVENOARR(RegistroInmueblesBean.super.getINMVENOARR());
		inmuebles.setINMDIR(RegistroInmueblesBean.super.getINMDIR());
		inmuebles.setINMESTRATO(RegistroInmueblesBean.super.getINMESTRATO());
		inmuebles.setINMAGUA(RegistroInmueblesBean.super.getINMAGUA());
		inmuebles.setINMLUZ(RegistroInmueblesBean.super.getINMLUZ());
		inmuebles.setINMGAS(RegistroInmueblesBean.super.getINMGAS());
		inmuebles.setINMTEL(RegistroInmueblesBean.super.getINMTEL());
		inmuebles.setINMREPARA(RegistroInmueblesBean.super.getINMREPARA());
		inmuebles.setIMNMEJORA(RegistroInmueblesBean.super.getIMNMEJORA());
		inmuebles.setINMNOVED(RegistroInmueblesBean.super.getINMNOVED());
		inmuebles.setINMINVERSI(RegistroInmueblesBean.super.getINMINVERSI());
		inmuebles.setINMURL(RegistroInmueblesBean.super.getINMURL());
		inmuebles.setINMIDPAGO(RegistroInmueblesBean.super.getINMIDPAGO());
		
		insertarInmuebles.crearInmueble(inmuebles);

	}
	
	/*Metodo que llama al dao de inmuebles y consulta un inmueble por el id
	 * */

	public List consultainmueble() {
		List consultaInmuebleIDLista = null;
		InmueblesDao consultaiNmuebleID = new InmueblesDao();
		consultaInmuebleIDLista = new ArrayList();
		consultaInmuebleIDLista = consultaiNmuebleID.consultarInmueble(RegistroInmueblesBean.super.getId());
		return consultaInmuebleIDLista;
	
	}
	
	public void deleteInmuebles(){
		InmueblesDao deleteInmuebleID = new InmueblesDao();	
		deleteInmuebleID.deleteInmueble(RegistroInmueblesBean.super.getId());
	}
	
	public void updateInmuebles(){
		InmueblesDao updateInmueble = new InmueblesDao();
		Inmuebles	inmuebles = new Inmuebles();
		InmueblesDao insertarInmuebles = new InmueblesDao();
		inmuebles.setINMVENOARR(RegistroInmueblesBean.super.getINMVENOARR());
		inmuebles.setINMDIR(RegistroInmueblesBean.super.getINMDIR());
		inmuebles.setINMESTRATO(RegistroInmueblesBean.super.getINMESTRATO());
		inmuebles.setINMAGUA(RegistroInmueblesBean.super.getINMAGUA());
		inmuebles.setINMLUZ(RegistroInmueblesBean.super.getINMLUZ());
		inmuebles.setINMGAS(RegistroInmueblesBean.super.getINMGAS());
		inmuebles.setINMTEL(RegistroInmueblesBean.super.getINMTEL());
		inmuebles.setINMREPARA(RegistroInmueblesBean.super.getINMREPARA());
		inmuebles.setIMNMEJORA(RegistroInmueblesBean.super.getIMNMEJORA());
		inmuebles.setINMNOVED(RegistroInmueblesBean.super.getINMNOVED());
		inmuebles.setINMINVERSI(RegistroInmueblesBean.super.getINMINVERSI());
		inmuebles.setINMURL(RegistroInmueblesBean.super.getINMURL());
		inmuebles.setINMIDPAGO(RegistroInmueblesBean.super.getINMIDPAGO());
		updateInmueble.updateInmueble(inmuebles);
	}

	public String getidusuario() {
		return idusuario;
	}

	public String setidusuario(String idusuario) {
		return idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVentOArr() {
		return VentOArr;
	}

	public void setVentOArr(String ventOArr) {
		VentOArr = ventOArr;
	}

	public String getTipNeg() {
		return TipNeg;
	}

	public void setTipNeg(String tipNeg) {
		TipNeg = tipNeg;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

}
