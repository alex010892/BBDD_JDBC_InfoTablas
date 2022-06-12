package modelo;

import java.sql.*;

public class Conexion {
	
	Connection miConexion = null;
	

	public Conexion() {
		
		
	}
	
	public Connection dameConexion() {
				
		
		try{
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false", "root", "12345");
			
		} catch(Exception e) {
			
			
		}
		
		return miConexion;
	}
}
