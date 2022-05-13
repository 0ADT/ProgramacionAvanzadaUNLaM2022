/**
 * Consigna:
 * Escribir un método en Java que permita comprobar si la multiplicación de todos los 
 * valores de una matriz numérica, dará 0 o no
 **/

package ejercicios_loom.ejercicio01;

public class Ejercicio01 {
	public static boolean DaCero(int matriz[][]) {
		boolean result = false;
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					result = true;
					return result;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int matriz[][] = {
				{1, 5, 3},
				{0, 5, 1},
				{9, 2, 4}
		};

		if(DaCero(matriz))
			System.out.println("La multiplicacion de los valores da cero.");
		else
			System.out.println("La multiplicacion de los valores NO dará cero.");
	}

}
