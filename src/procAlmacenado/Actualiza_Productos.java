package procAlmacenado;

import java.sql.*;
import javax.swing.*;

public class Actualiza_Productos {

	public static void main(String[] args) {

		int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
		
		String nArticulo = JOptionPane.showInputDialog("Introduce nombre articulo");
		
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false", "root", "12345");
			
			CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_PROD(?,?)}");
			
			miSentencia.setInt(1, nuevoPrecio);
			
			miSentencia.setString(2, nArticulo);
			
			miSentencia.execute();
			
			System.out.println("Actualización OK");
			
			miConexion.close();
			
		} catch(Exception e) {
			
		}

	}

}
