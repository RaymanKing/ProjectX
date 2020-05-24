package beans;

public class Comida {

	int idFood;
	String name;
	int type;
	int stock;
	float price_unit;
	
	// Constructores
	
	public Comida() {}
	public Comida(int idFood, String name, int type, int stock, float price_unit) {
		this.idFood = idFood;
		this.name = name;
		this.type = type;
		this.stock = stock;
		this.price_unit = price_unit;
	}
	
	public Comida(int idFood, String name, float price_unit) {
		this.idFood = idFood;
		this.name = name;
		this.price_unit = price_unit;
	}
	
	public Comida(String name, int type, int stock, float price_unit) {
		this.name = name;
		this.type = type;
		this.stock = stock;
		this.price_unit = price_unit;
	}
	
	// Getter y setters
	
	public int getIdFood() {
		return this.idFood;
	}
	
	public void setIdFoor(int idFood) {
		this.idFood = idFood;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public float getPrice_unit() {
		return this.price_unit;
	}
	
	public void setPrice_unit(float price_unit) {
		this.price_unit = price_unit;
	}
	
	// To string
	
	public String toString() {
		return "La comida "+name+" con id "+idFood+" es del tipo "+type+" , tenemos en el stock "+stock+" unidades a precio por unidad de "+price_unit+" euros.";
	}
	
	
}
