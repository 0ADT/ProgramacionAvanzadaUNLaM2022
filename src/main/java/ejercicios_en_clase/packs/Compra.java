package ejercicios_en_clase.packs;

import java.util.ArrayList;
import java.util.List;

/**
 * Para cierto módulo de un carrito de compras web, se desea poder totalizar el
 * valor de una compra. 
 * *La compra, naturalmente, puede tener uno o más ítems.
 * *Puede comprarse más de un ítem del mismo artículo. 
 * *No es necesario controlar stock. 
 * *Existen artículos individuales, y packs. Los packs pueden tener tres
 * tipos de precio: 
 * 		Precio con descuento: el valor del pack tiene un porcentaje de descuento. 
 * 		Precio fijo: el valor del pack tiene un precio fijado, independientemente del precio de sus ítems. 
 * 		Uno de regalo: el pack contiene un artículo que se obsequia con la compra del mismo.
 * 
 * Necesitamos programar una pieza de código que pueda manejar todas estas
 * situaciones, arrojando el total de la compra.
 * 
 * Mostrar el ticket con la compra realizada: el total, el listado de articulos, 
 * el precio de cada articulo, el nombre del pack y su precio
 ***/
public class Compra {
	private List<Item> items = new ArrayList<Item>();
	private String descripcion;

	public Compra(String descripcion) {
		this.descripcion = descripcion;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void mostrarTicket() {
		System.out.println("Detalle de la compra:");
		System.out.println(this.descripcion + "\n");

		for (Item i : items)
			System.out.print(i.getArticulo());

	}

	public double getMonto() {
		double monto = 0;
		
		for(Item i : items)
			monto += i.getPrecio();
		
		return monto;
	}
	
	public static void main(String[] args) {
		Compra compra = new Compra("Esta es la compra del dia");
		
		compra.addItem(new Articulo("banana", 15.45));
		compra.addItem(new Articulo("sandia", 0.99));
		compra.addItem(new Articulo("reloj casio", 1.26));
		
		Pack pack1 = new PackPrecioFijo("Oferta semanal 25", 28);
		Pack pack2 = new PackPrecioFijo("Oferta de pascuas", 15);
		Pack pack3 = new PackConDescuento("Combo navideño", 15);
		Pack pack4 = new PackConRegalo("Primavera sensacional", new Articulo("Bicicleta MTB", 500));
		
		pack1.add(new Articulo("Shampoo", 5));
		pack1.add(new Articulo("Jabon LuZ", 4.99));
		pack1.add(new Articulo("Pelota Volley", 1.39));
		pack1.add(new Articulo("Crema de afeitar", 99.99));
		
		pack2.add(new Articulo("Asado x 1kg", 25.66));
		pack2.add(new Articulo("Chorizo x 5U", 15.32));
		pack2.add(new Articulo("Picada Especial x 1kg", 1.99));
		pack2.add(new Articulo("Bife de chorizo x 0,5kg", 0.99));
		
		pack3.add(new Articulo("Vitel Tone x 5kg", 1.29));
		pack3.add(new Articulo("Recalentado Especial x 10kg", 90));
		
		pack4.add(new Articulo("Campera lana Talle XL", 14.99));
		pack4.add(new Articulo("Pantalon Frisado", 1.56));
		pack4.add(new Articulo("Botas para la nieve", 9.99));
		pack4.add(new Articulo("Guantes de lana", 1.99));
		pack4.add(new Articulo("Varillas de madera x 1m", 0.89));
		pack4.add(new Articulo("Cafe La Morenita x 0,25kg", 5.99));
		
		compra.addItem(pack1);
		compra.addItem(pack2);
		compra.addItem(pack3);
		compra.addItem(pack4);
		compra.mostrarTicket();
	}
}
