package principal;

import javax.swing.*;

import vista.*;

public class Ejecuta_Modelo_Vista_Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Aplicacion mimarco = new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}
