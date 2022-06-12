package modelo;

import java.sql.*;

public class CargaMenus {

	public Conexion miConexion;
	
	public ResultSet rs;
	
	public ResultSet rs2;
	
	
	public CargaMenus() {
		
		miConexion = new Conexion();
	}
	
	public String ejecutaConsultas() {
		
		Productos miProducto = null;
		
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			
			Statement secciones = accesoBBDD.createStatement();
			
			Statement paises = accesoBBDD.createStatement();
			
			rs = secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");
			
			rs2 = paises.executeQuery("SELECT DISTINCTROW PAISDEORIGEN FROM PRODUCTOS");
			
			miProducto = new Productos();
				
			miProducto.setSeccion(rs.getString(1));
			
			miProducto.setpOrigen(rs2.getString(1));
				
			rs.close();
			
			rs2.close();
			
			accesoBBDD.close();
			
		} catch(Exception e) {
			
			
		}
		
		return miProducto.getSeccion();
	}
		
}
