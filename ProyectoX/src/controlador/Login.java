package controlador;

import java.sql.ResultSet;
import modelo.*;
import beans.*;

import javax.swing.JOptionPane;

public class Login {

	// Chequeo del Login
	
	public boolean checkUser(String dni, String password) {
		boolean userCheck = new modelo.Trabajadores().checkUserAndPass(dni, password);
		if(userCheck) {
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
		}else {
			JOptionPane.showMessageDialog(null, "Usuario incorrecto");
			userCheck = false;
		}
		return userCheck;
	}
	
	// Recogida de datos
	
	
	//Trabajador trabajadorOn = Trabajadores.getTrabajador(dni, password);
	//trabajadorOn = Trabajadores.getTrabajador(dni, password);
	
}
