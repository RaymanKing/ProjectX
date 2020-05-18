package controlador;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Login {

	// Chequeo del Login
	
	public void checkUser(String dni, String password) {
		boolean userCheck = new modelo.Users().checkUserAndPass(dni, password);
		if(userCheck) {
			int userRol = new modelo.Users().checkRol(dni, password);
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
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		}
	}
	
}
