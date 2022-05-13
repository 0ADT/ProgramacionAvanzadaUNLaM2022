package ejercicios_en_clase.packs;

import java.util.ArrayList;
import java.util.List;

public class PackPrecioFijo  extends Pack{

	private List<Articulo> articulos = new ArrayList<Articulo>();
	private double precio;
	private String nombrePack;
	
	public PackPrecioFijo(String nombrePack, double precio) {
		this.nombrePack = nombrePack;
		this.precio = precio;
	}
	
	@Override
	public String getArticulo() {
		String contenido = "Pack: " + this.nombrePack + " - $" + this.precio + " - Contiene:\n";
		
		for(Articulo art : articulos) {
			contenido += ("---" + art.getNombre() + "\n");
		}
		
		return contenido + "################\n";
	}

	@Override
	public void add(Articulo articulo) {
		this.articulos.add(articulo);
	}

	@Override
	public double getPrecio() {
		return precio;
	}

}
