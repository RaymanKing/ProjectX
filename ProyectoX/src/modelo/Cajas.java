package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.Date;

import bbdd.Conexion;
import beans.Caja;
import beans.Recibo;

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
	
	public void insertarCambio(Caja caja, float cantidad) {		
		float currentBox = caja.getCurrentBox();
		float finalBox = caja.getFinalBox();
		float cantidadActual = finalBox + cantidad;
		Date transaction = new Date(System.currentTimeMillis());
		Conexion.EjecutarUpdate("INSERT INTO caja VALUES (0,'"+cantidad+"','"+currentBox+"','"+cantidadActual+"','"+transaction+"')");
		JOptionPane.showMessageDialog(null, "Cambio añadido correctamente");
	}
	
	public Caja recogerUltCaja() {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM caja ORDER BY IdReceipt DESC LIMIT 1 ;");
		Caja caja = new Caja();
		try {
			if(resultado.next()) {
				int id = resultado.getInt("IdReceipt");
				float amount = resultado.getFloat("Amount");
				float currentBox = resultado.getFloat("CurrentBox");
				float finalBox = resultado.getFloat("FinalBox");
				Date transaction = resultado.getDate("TransactionDate");
				caja = new Caja(id,amount,currentBox,finalBox,transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caja;
	}
	
	public void insertarRecibo(Recibo recibo, Caja caja) {
		int idRecibo = recibo.getIdReceipt();
		float precio = recibo.getPrice();
		float currentBox = caja.getFinalBox();
		float finalBox = caja.getFinalBox();
		finalBox = precio + finalBox;
		Date transaction = recibo.getTransactionDate();
		Conexion.EjecutarUpdate("INSERT INTO caja VALUES ('"+idRecibo+"','"+precio+"','"+currentBox+"','"+finalBox+"','"+transaction+"')");	
	}
	
}
