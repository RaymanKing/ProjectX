package modelo;

import java.sql.ResultSet;
import java.sql.Date;

import bbdd.Conexion;
import beans.Trabajador;

public class Register {

	// Método para insertar el trabajador en la base de datos


	public void registrarTrabajador(Trabajador trabajadorRegistered) {
		
		String nombre = trabajadorRegistered.getFirstName();
		String apellidos = trabajadorRegistered.getLastName();
		Date nacimiento = trabajadorRegistered.getDateBirth();
		String dni = trabajadorRegistered.getDni();
		int telefono = trabajadorRegistered.getNumbertlf();
		Date registered = trabajadorRegistered.getRegisteredDay();
		String password = trabajadorRegistered.getPassword();
		int rol = trabajadorRegistered.getRol();
		Conexion.EjecutarUpdate("INSERT INTO trabajadores (First_name,Last_name,Date_of_birth,DNI,Number_tlf,Registered_day,Password,Rol) VALUES ('"+nombre+"','"+apellidos+"','"+nacimiento+"','"+dni+"','"+telefono+"','"+registered+"','"+password+"','"+rol+"')");
	}
}
