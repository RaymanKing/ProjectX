package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import bbdd.Conexion;
import beans.Caja;

public class Cajas {

	public ArrayList<Caja> recogerDatosCaja(){
		ResultSet caja = Conexion.EjecutarSentencia("SELECT * FROM caja;");
		ArrayList<Caja> datosCaja = new ArrayList<Caja>();
		try {
			while(caja.next()) {
				Caja datoCaja = new Caja();
				int idRecibo = caja.getInt("IdReceipt");
				float amount = caja.getFloat("Amount");
				float currentBox = caja.getFloat("CurrentBox");
				float finalBox = caja.getFloat("FinalBox");
				Date transaction = caja.getDate("TransactionDate");
				datoCaja = new Caja(idRecibo, amount, currentBox, finalBox, transaction);
				datosCaja.add(datoCaja);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datosCaja;
	}
	
	public int entradaDeDatos() {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT COUNT(IdReceipt) AS Entradas FROM caja;");
		int entradas = 0;
		try {
			if(resultado.next()) {
				entradas = resultado.getInt("Entradas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entradas;
	}
	
	
}
