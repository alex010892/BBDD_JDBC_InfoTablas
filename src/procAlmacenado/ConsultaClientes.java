package procAlmacenado;

import java.sql.*;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false", "root", "12345");
			
			CallableStatement miSentencia = miConexion.prepareCall("{call MUESTRA_CLIENTES2}");
			
			ResultSet rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			rs.close();
			//miConexion.close();
			
		} catch(Exception e) {
			
			
		}
		
	}

}
