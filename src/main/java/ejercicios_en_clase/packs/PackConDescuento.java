package ejercicios_en_clase.packs;

import java.util.ArrayList;
import java.util.List;

public class PackConDescuento extends Pack {

	private List<Articulo> articulos = new ArrayList<Articulo>();
	private double descuento;
	private String nombrePack;

	public PackConDescuento(String nombrePack, double descuento) {
		this.nombrePack = nombrePack;
		this.descuento = descuento / 100;
	}

	@Override
	public String getArticulo() {
		String contenido = "Pack: " + this.nombrePack + " - $" + this.getPrecio()
				+ "\n**Contenido del pack y precios unitarios:\n";

		for (Articulo art : articulos) {
			contenido += ("---" + art.getArticulo());
		}

		return contenido + "################\n";
	}

	@Override
	public void add(Articulo articulo) {
		articulos.add(articulo);
	}

	@Override
	public double getPrecio() {
		double monto = 0;

		for (Articulo art : articulos)
			monto += art.getPrecio();

		return monto - monto * descuento;
	}

}
