package ejercicios_en_clase.packs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompraTest {

	@Test
	public void comprarArticulos() {
		Compra compra = new Compra("Compra de articulos sueltos");
		
		compra.addItem(new Articulo("banana x 1kg", 50));
		compra.addItem(new Articulo("manzana x 0,5kg", 50));
		compra.addItem(new Articulo("lechuga x 0,5kg", 12));
		compra.addItem(new Articulo("tomate x 1kg", 5));
		compra.addItem(new Articulo("nuez x 5kg", 5.99));
		
		assertEquals(122.99, compra.getMonto(), 0.01);
	}

	@Test
	public void comprarPackPrecioFijo() {
		Compra compra = new Compra("Compra de packs precio fijo");
		Pack pack1 = new PackPrecioFijo("fijo", 100);
		
		pack1.add(new Articulo("objeto 1", 999));
		pack1.add(new Articulo("objeto 2", 999));
		pack1.add(new Articulo("objeto 3", 999));
		pack1.add(new Articulo("objeto 4", 999));
		pack1.add(new Articulo("objeto 5", 999));
		pack1.add(new Articulo("objeto 6", 999));
		pack1.add(new Articulo("objeto 7", 999));
		pack1.add(new Articulo("objeto 8", 999));
		pack1.add(new Articulo("objeto 9", 999));
		pack1.add(new Articulo("objeto 10", 999));
		pack1.add(new Articulo("objeto 11", 999));
		
		compra.addItem(pack1);
		assertEquals(100, compra.getMonto(), 0);
	}
	
	@Test
	public void comprarPackConDescuento() {
		Compra compra = new Compra("Compra de packs con descuentos");
		Pack pack1 = new PackConDescuento("Descuento", 25);
		
		pack1.add(new Articulo("objeto 1", 50));
		pack1.add(new Articulo("objeto 2", 66));
		pack1.add(new Articulo("objeto 3", 999));
		pack1.add(new Articulo("objeto 4", 1000));
		pack1.add(new Articulo("objeto 5", 550));
		pack1.add(new Articulo("objeto 6", 9.99));
		pack1.add(new Articulo("objeto 7", 11.52));
		pack1.add(new Articulo("objeto 8", 75.33));
		pack1.add(new Articulo("objeto 9", 5));
		pack1.add(new Articulo("objeto 10", 0.24));
		pack1.add(new Articulo("objeto 11", 563.66));
		
		double valorConDescuento = 3330.74 - 3330.74 * 0.25;
		
		compra.addItem(pack1);
		assertEquals(valorConDescuento, compra.getMonto(), 0.01);
	}
	
	@Test
	public void comprarVariosPacks() {
		Compra compra = new Compra("Compra de packs");
		Pack pack1 = new PackConDescuento("Descuento", 25);
		Pack pack2 = new PackConRegalo("Con regalo", new Articulo("Objeto regalo", 999));
		Pack pack3 = new PackPrecioFijo("Fijo", 153.99);
		
		pack1.add(new Articulo("objeto 1", 50));
		pack1.add(new Articulo("objeto 2", 66));
		pack1.add(new Articulo("objeto 3", 999));
		
		pack2.add(new Articulo("objeto 4", 1000));
		pack2.add(new Articulo("objeto 5", 550));
		pack2.add(new Articulo("objeto 6", 9.99));
		
		pack3.add(new Articulo("objeto 7", 11.52));
		pack3.add(new Articulo("objeto 8", 75.33));
		pack3.add(new Articulo("objeto 9", 5));
		pack3.add(new Articulo("objeto 10", 0.24));
		pack3.add(new Articulo("objeto 11", 563.66));
				
		compra.addItem(pack1);
		compra.addItem(pack2);
		compra.addItem(pack3);
		
		assertEquals(1713.98 + pack1.getPrecio(), compra.getMonto(), 0.01);
	}
	
	@Test
	public void comprarItems() {
		Compra compra = new Compra("Compra de articulos sueltos y de packs");
		
		compra.addItem(new Articulo("banana x 1kg", 50));
		compra.addItem(new Articulo("manzana x 0,5kg", 50));
		compra.addItem(new Articulo("lechuga x 0,5kg", 12));
		compra.addItem(new Articulo("tomate x 1kg", 5));
		compra.addItem(new Articulo("nuez x 5kg", 5.99));
		
		Pack pack1 = new PackConDescuento("Descuento", 25);
		Pack pack2 = new PackConRegalo("Con regalo", new Articulo("Objeto regalo", 999));
		Pack pack3 = new PackPrecioFijo("Fijo", 153.99);
		
		pack1.add(new Articulo("objeto 1", 50));
		pack1.add(new Articulo("objeto 2", 66));
		pack1.add(new Articulo("objeto 3", 999));
		
		pack2.add(new Articulo("objeto 4", 1000));
		pack2.add(new Articulo("objeto 5", 550));
		pack2.add(new Articulo("objeto 6", 9.99));
		
		pack3.add(new Articulo("objeto 7", 11.52));
		pack3.add(new Articulo("objeto 8", 75.33));
		pack3.add(new Articulo("objeto 9", 5));
		pack3.add(new Articulo("objeto 10", 0.24));
		pack3.add(new Articulo("objeto 11", 563.66));
				
		compra.addItem(pack1);
		compra.addItem(pack2);
		compra.addItem(pack3);
		
		assertEquals(122.99 + 1713.98 + pack1.getPrecio(), compra.getMonto(), 0.01);
	}
}
