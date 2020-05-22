package controlador;

import beans.Trabajador;

public class Register {


	// Registrar nuevo empleado

	

	public void trabajadorRegister(Trabajador trabajadorRegistered) {
		new modelo.Register().registrarTrabajador(trabajadorRegistered);		
	}
	
	
	
}
