package ejercicios_en_clase.packs;

public class Articulo extends Item {

	private String nombre;
	private double precio;

	public Articulo(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getArticulo() {
		return nombre + " - $" + precio + "\n";
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public double getPrecio() {
		return precio;
	}
}
