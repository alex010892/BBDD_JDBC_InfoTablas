package modelo;

import java.sql.*;

public class EjecutaConsultas {

	private Conexion miConexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion;
	
	private final String consultaSeccion = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ?";
	
	private PreparedStatement enviaConsultaPais;
	
	private final String consultaPais = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE PAISDEORIGEN = ?";
	
	private PreparedStatement enviaConsultaTodos;
	
	private final String consultaTodos = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ? AND PAISDEORIGEN = ?";
	

	public EjecutaConsultas() {
		
		miConexion = new Conexion();
	}
	
	public ResultSet filtraBBDD(String seccion, String pais) {
		
		Connection conecta = miConexion.dameConexion();
		
		rs = null;
		
		try {
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				
				enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				rs = enviaConsultaSeccion.executeQuery();
				
			} else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaPais = conecta.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				rs = enviaConsultaPais.executeQuery();
								
			} else {
				
				enviaConsultaTodos = conecta.prepareStatement(consultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				
				enviaConsultaTodos.setString(2, pais);
				
				rs = enviaConsultaTodos.executeQuery();
				
			}			
			
		} catch(Exception e) {
			
			
		}
				
		return rs;
	}
}
