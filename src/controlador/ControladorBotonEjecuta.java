package controlador;

import java.awt.event.*;
import java.sql.*;

import modelo.*;

import vista.*;


public class ControladorBotonEjecuta implements ActionListener {

	private Marco_Aplicacion elmarco;
	
	EjecutaConsultas obj = new EjecutaConsultas();
	
	private ResultSet resultadoConsulta;
	
	
	public ControladorBotonEjecuta(Marco_Aplicacion elmarco) {
		
		this.elmarco = elmarco;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		String seleccionSeccion = (String) elmarco.secciones.getSelectedItem();
		
		String seleccionPais = (String) elmarco.paises.getSelectedItem();
		
		resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
		
		try {
			
			elmarco.resultado.setText("");
			
			while(resultadoConsulta.next()) {
				
				elmarco.resultado.append(resultadoConsulta.getString(1));
				
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(2));
				
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(3));
				
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(4));
				
				elmarco.resultado.append("\n");
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}

		
}
