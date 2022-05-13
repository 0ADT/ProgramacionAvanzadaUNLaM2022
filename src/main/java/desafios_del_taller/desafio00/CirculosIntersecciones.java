package desafios_del_taller.desafio00;

/**
 * Consigna:
 * 		Para construir un c�rculo se requiere un punto, que ser� su centro,
 * y un radio. Nuestro peque�o programa nos permitir� verificar si hay o no
 * intersecci�n entre dos c�rculos. Se te pide programar las clases Punto,
 * Circulo, y una prueba que te permita verificar el correcto funcionamiento del
 * m�todo especificado.
 * 
 * Ejemplo de funcionamiento:
 * 
 * Circulo c1 = new Circulo(new Punto(0, 0), 1); 
 * Circulo c2 = new Circulo(new Punto(1, 1), 1.5); 
 * System.out.println(c1.intersectaCon(c2)); // true
 * 
 * Nota: Si pudieras comprobarlo mediante un JUnit test, �tanto mejor!
 * 
 * Nota: Suban todas las clases que utilizaron para resolver el desafio
 * 
 * TIP: En Eclipse, se formatea el c�digo con CTRL + SHIFT + F
 **/
public class CirculosIntersecciones {

	public static void main(String[] args) {
		Circulo c1 = new Circulo(new Punto(0, 0), 1); 
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5); 
		System.out.println(c1.intersectaCon(c2)); // true
	}

}
