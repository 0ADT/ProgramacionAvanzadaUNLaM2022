/**
 * CONSIGNA: 
 * Escribir un método en Java que permita comprobar si la diagonal principal de una matriz cuadrada de 
 * enteros tiene en cada posición un valor igual a la suma de todos los valores de las posiciones anteriores 
 * de dicha diagonal. 
 * 
 * Por ejemplo, la siguiente matriz comprueba la regla:
 * 1 2 3
 * 4 1 6
 * 7 8 2
 * 
 * Pero esta otra, no la comprueba:
 * 1 2 3
 * 4 2 6
 * 7 8 2
 **/

package ejercicios_loom.ejercicio00;

public class Ejercicio00 {	
	public static boolean Comprueba(int matriz[][]) {
		boolean result = true;
		int suma = matriz[0][0];
		
		for(int i = 1; i < matriz.length; i++) {
			if (suma != matriz[i][i]) {
				result = false;
				return result;
			}
			
			suma += matriz[i][i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int matriz[][] = {
			{1, 2, 3},
			{4, 2, 6},
			{7, 8, 2}
		};
		
		if(Comprueba(matriz))
			System.out.println("La diagonal principal de la matriz esta conformada por la suma de los valores anteriores.");
		else
			System.out.println("La matriz no cumple con la consigna.");
	}

}
