package ejercicios_loom.oia2;

/**
 * Consigna
 *  
 * Descripcion del problema
 * En un negocio de venta de mesadas de granito se deben almacenar N mesadas rectangulares,
 * que seran recibidas de la cantera. Las mesadas tienen el mismo grosor, pero pueden tener
 * distintos ancho y largo. Las mesadas se almacenan en un deposito apilandolas. Para poder apilar
 * una mesada encima de otra, la mesada superior no debe superar en largo ni en ancho a la mesada 
 * inferior. Es decir, la mesada superior debe tener lados que son iguales o menores que la mesada
 * inferior. Antes de apilarse, las mesadas pueden ser rotadas 90� en cualquier sentido, con lo
 * cual una mesada de 2 x 5 puede apilarse sobre una mesada de 7 x 2. Se desea saber cual es la cantidad
 * mínima de pilas de mesadas que se puede conseguir. Se te pide que escribas un programa que determinen
 * el numero minimo de pilas.
 * 
 * ++++Datos de entrada 
 * Se recibe un archivo mesadas.in con el siguiente formato:
 * Una linea que indica la cantidad N ( 1 ≤ N ≤ 200.000 ) de mesadas de granito
 * N lineas con 2 numeros a y b ( 0 < a, b ≤ 1.000.000 ) que indican las dimensiones de las mesadas
 * 
 * ++++Datos de salida 
 * Se debe generar un archivo mesadas.out conteniendo una linea con la cantidad minima de pilas
 * de mesadas que se pueden formar para almacenar las mesadas recibidas.
 * 
 * Ejemplo La entrada mesadas.in seria:
 * 6
 * 4 5
 * 9 3
 * 2 2
 * 1 2
 * 1 12
 * 2 7
 * 
 * La salida mesadas.out deberia ser:
 * 3 * 
 **/
public class MainMesadas {

	public static void main(String[] args) {
		Deposito depo = new Deposito();
		
		System.out.println("Inicio del programa");
		depo.CargarMesadas("src\\main\\resources\\ejercicios_loom\\oia2\\mesadas.in");
		depo.ApilarMesadas();
		depo.GuardarMesadas("src\\main\\resources\\ejercicios_loom\\oia2\\mesadas.out");
		System.out.println("Programa finalizado");
	}

}
