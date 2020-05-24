package controlador;

import java.sql.ResultSet;
import modelo.*;
import beans.*;

import javax.swing.JOptionPane;

public class Login {

	// Chequeo del Login
	
	public void checkUser(String dni, String password) {
		Trabajador trabajador = new modelo.Trabajadores().getTrabajador(dni, password);
		if(trabajador.getIdUser() != 0) {
			int userRol = new modelo.Trabajadores().checkRol(dni, password);
			// Llamada al metodo que crea un objeto trabajador con todos sus datos
			Trabajador trabajadorOn = modelo.Trabajadores.getTrabajador(dni,password);
			if(userRol == 101) {
				JOptionPane.showMessageDialog(null, "Buenos dias jefe");
				// Tengo que añadir la ventana que le abrira al jefe con todas las opciones
				}else if(userRol == 1) {
				JOptionPane.showMessageDialog(null, "Buenos dias almacenero al curro");
				// Añadir ventana con restricciones
			}else if(userRol == 0) {
				JOptionPane.showMessageDialog(null, "Buenos dias camarero al curro");
				// Añadir ventana con restricciones
			}
			new controlador.Fichero().escrituraFichero(dni);
			vista.Menu frame = new vista.Menu(trabajador);
			
		}else {
			JOptionPane.showMessageDialog(null, "Usuario incorrecto");
		}
	}
}
