package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JOptionPane;

import bbdd.Conexion;
import beans.Trabajador;

public class Trabajadores {

	// Método para comprobar que este correctamente el login

	public boolean checkUserAndPass(String dni, String password) {
		ResultSet usuarioBD = Conexion.EjecutarSentencia(
				"SELECT * FROM trabajadores WHERE DNI='" + dni + "' AND Password='" + password + "'");

		try {
			return usuarioBD.next();
		} catch (SQLException e) {
			return false;
		}
	}

	// Método que recoge el rol

	public int checkRol(String dni, String password) {
		int rol = -1;
		ResultSet resultado = Conexion.EjecutarSentencia(
				"SELECT Rol FROM trabajadores WHERE DNI='" + dni + "' AND Password='" + password + "'");
		try {
			if (resultado.next()) {
				// Recoger el rol que tiene este usuario
				rol = resultado.getInt("Rol");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No existe resultado");
			e.printStackTrace();
		}
		return rol;
	}

	// Método que recoge todos los datos del trabajador

	public static Trabajador getTrabajador(String dni, String password) {
		ResultSet trabajador = Conexion.EjecutarSentencia(
				"SELECT * FROM trabajadores WHERE DNI='" + dni + "' AND Password='" + password + "'");
		Trabajador trabajadorOn = new Trabajador();

		try {
			if (trabajador.next()) {
				int id = trabajador.getInt("IdUser");
				String name = trabajador.getNString("First_name");
				String lastName = trabajador.getNString("Last_name");
				Date birth = trabajador.getDate("Date_of_birth");
				String identify = trabajador.getNString("DNI");
				int numberTlf = trabajador.getInt("Number_tlf");
				Date registered = trabajador.getDate("Registered_day");
				String pass = trabajador.getNString("Password");
				int role = trabajador.getInt("Rol");

				trabajadorOn = new Trabajador(id, name, lastName, birth, identify, numberTlf, registered, pass, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trabajadorOn;
	}
	
	public Trabajador getInfoTrabajador(String dni) {
		ResultSet trabajador = Conexion.EjecutarSentencia(
				"SELECT * FROM trabajadores WHERE DNI='" + dni + "';");
		Trabajador trabajadorInfo = new Trabajador();

		try {
			if (trabajador.next()) {
				int id = trabajador.getInt("IdUser");
				String name = trabajador.getNString("First_name");
				String lastName = trabajador.getNString("Last_name");
				Date birth = trabajador.getDate("Date_of_birth");
				String identify = trabajador.getNString("DNI");
				int numberTlf = trabajador.getInt("Number_tlf");
				Date registered = trabajador.getDate("Registered_day");
				String pass = trabajador.getNString("Password");
				int role = trabajador.getInt("Rol");

				trabajadorInfo = new Trabajador(id, name, lastName, birth, identify, numberTlf, registered, pass, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trabajadorInfo;
	}

}
