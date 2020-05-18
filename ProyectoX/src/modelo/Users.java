package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bbdd.Conexion;

public class Users {

	public boolean checkUserAndPass(String dni, String password) {
		ResultSet usuarioBD = Conexion.EjecutarSentencia("SELECT * FROM trabajadores WHERE DNI='"+dni+"' AND Password='"+password+"'");
		
		try {
			return usuarioBD.next();
		}catch(SQLException e) {
			return false;
		}
	}
	
	public int checkRol(String dni, String password) {
		int rol = -1;
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT Rol FROM trabajadores WHERE DNI='"+dni+"' AND Password='"+password+"'");
		try {
			if(resultado.next()) {
				// Recoger el rol que tiene este usuario
				rol = resultado.getInt("Rol");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No existe resultado");
			e.printStackTrace();
		}
		return rol;
	}
	
}
