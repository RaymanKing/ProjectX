package controlador;

public class Pagos {

	public float recogerT(int mesaNumero) {
		float total = new modelo.Mesas().recogerTotal(mesaNumero);
		return total;
	}
	
}
