package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.Conexion;

public class Mesas {

	// Método para recoger las mesas que tenemos con productos
	
	public ArrayList<Integer> devolverNumMesas(){
		ResultSet mesas = Conexion.EjecutarSentencia("SELECT DISTINCT IdTable FROM pedidos;");
		ArrayList <Integer> mesasOcupadas = new ArrayList <Integer>();
		try {
			while(mesas.next()) {
				int mesa = 0;
				mesa = mesas.getInt("IdTable");
				mesasOcupadas.add(mesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mesasOcupadas;
	}
	
	
	public float recogerTotal(int numero) {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM pedidos WHERE IdTable = '"+numero+"';");
		float sumatorio = 0;
		try {
			while(resultado.next()) {
				float suma = resultado.getInt("Price");
				sumatorio = suma + sumatorio;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sumatorio;
	}
}
