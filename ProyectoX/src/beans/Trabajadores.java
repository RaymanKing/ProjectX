package beans;

import java.util.Date;

public class Trabajadores {

	int idUser;
	String first_name;
	String last_name;
	Date date_of_birth;
	String dni;
	int number_tlf;
	Date registered_day;
	String password;
	int rol;

	// Constructores

	public Trabajadores() {
	}

	public Trabajadores(int idUser, String first_name, String last_name, Date date_of_birth, String dni, int number_tlf,
			Date registered_day, String password, int rol) {
		this.idUser = idUser;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.dni = dni;
		this.number_tlf = number_tlf;
		this.registered_day = registered_day;
		this.password = password;
		this.rol = rol;
	}
	
	// Getters y setters
	
	public int getIdUser() {
		return this.idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName(String last_name) {
		return this.last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public Date getDateBirth() {
		return this.date_of_birth;
	}
	
	public void setDateBirth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getNumbertlf() {
		return this.number_tlf;
	}
	
	public void setNumbertlf(int number_tlf) {
		this.number_tlf = number_tlf;
	}
	
	public Date getRegisteredDay() {
		return this.registered_day;
	}
	
	public void setRegisteredDay(Date registered_day) {
		this.registered_day = registered_day;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRol() {
		return this.rol;
	}
	
	public void setRol(int rol) {
		this.rol = rol;
	}
	
	// To string
	
	public String toString() {
		return "El usuario "+idUser+" con nombre "+first_name+" "+last_name+" , fecha de nacimiento "+date_of_birth+" y dni "+dni+" y con numero de teléfono "+number_tlf;
	}

}
