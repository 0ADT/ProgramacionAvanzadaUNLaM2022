package ejercicios_en_clase.packs;

import java.util.ArrayList;
import java.util.List;

public class PackConRegalo extends Pack {

	private List<Articulo> articulos = new ArrayList<Articulo>();
	private Articulo articuloRegalo;
	private String nombrePack;

	public PackConRegalo(String nombrePack, Articulo articuloRegalo) {
		this.nombrePack = nombrePack;
		this.articuloRegalo = articuloRegalo;
	}

	@Override
	public String getArticulo() {
		String contenido = "Pack: " + this.nombrePack + " - $" + this.getPrecio() + ":\n";

		for (Articulo art : articulos) {
			contenido += ("---" + art.getArticulo());
		}

		contenido += ("**** Regalo por comprar este Pack: " + this.articuloRegalo.getNombre() + "****\n");
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

		return monto;
	}

}
