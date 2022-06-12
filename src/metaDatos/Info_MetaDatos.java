package metaDatos;

import java.sql.*;

public class Info_MetaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//mostrarInfo_BBDD();
		
		mostraInfo_Tablas();
	}
	
	static void mostrarInfo_BBDD() {
		
		Connection miConexion = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false", "root", "12345");
			
			//obtención de metadatos
			
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			//mostramos información de la BBDD
			
			System.out.println("Gestor de BBDD " + datosBBDD.getDatabaseProductName());
			
			System.out.println("Versión del gestor " + datosBBDD.getDatabaseProductVersion());
			
			System.out.println("Nombre del driver " + datosBBDD.getDriverName());
			
			System.out.println("Versión del driver " + datosBBDD.getDriverVersion());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				miConexion.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	static void mostraInfo_Tablas() {
		
		Connection miConexion = null;
		
		ResultSet miResultSet = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false", "root", "12345");
			
			//obtención de metadatos, aquí se almacenan todos los metadatos
			
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			//lista de tablas
			
			System.out.println("Lista de tablas "); 
			
			//String[] tipo = {"TABLE"}; //muestra solo las tablas creadas por mi y sys_config que es de la BBDD sys
			
			miResultSet = datosBBDD.getTables("curso_sql", null, null, null);
			
			while(miResultSet.next()) {
				
				System.out.println(miResultSet.getString("TABLE_NAME"));
			}
			
			//lista de columnas de productos
			
			System.out.println("");
			
			System.out.println("Campos de productos");
			
			miResultSet = datosBBDD.getColumns(null, null, "productos", null);
			
			while(miResultSet.next()) {
				
				System.out.println(miResultSet.getString("COLUMN_NAME"));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				miConexion.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
