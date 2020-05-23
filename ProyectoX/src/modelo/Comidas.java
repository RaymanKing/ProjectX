package modelo;

import javax.swing.JOptionPane;

import bbdd.Conexion;

public class Comidas {

	// Método para realizar la bajada del producto en almacén
	
	public void retiradaAlmacen(int idFood, int cantidad) {
		Conexion.EjecutarUpdate("UPDATE comidas SET Stock = Stock - "+cantidad+" WHERE IdFood = "+idFood);
		JOptionPane.showMessageDialog(null, "Cantidad retirada del almacén satisfactoriamente.");
	}
	
	
}
