package modelo;

import javax.swing.JOptionPane;

import bbdd.Conexion;

public class Comidas {

	// M�todo para realizar la bajada del producto en almac�n
	
	public void retiradaAlmacen(int idFood, int cantidad) {
		Conexion.EjecutarUpdate("UPDATE comidas SET Stock = Stock - "+cantidad+" WHERE IdFood = "+idFood);
		JOptionPane.showMessageDialog(null, "Cantidad retirada del almac�n satisfactoriamente.");
	}
	
	
}
