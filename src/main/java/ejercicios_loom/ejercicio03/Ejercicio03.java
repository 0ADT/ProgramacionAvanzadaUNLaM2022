/**
 * Consigna:
 * Escribir un método en Java que de una matriz numérica dada, devuelva un vector con n elementos, donde cada elemento
 * es la moda de una fila. Si hubiese más de una moda, se deberá utilizar la de mayor valor
 * 
 * Ejemplo:
 * Para la matriz
 *  1  2  3  4
 *  5 -6 -6 20
 *  1  1 10 10
 *   
 *   La salida debe ser
 *   4 -6 10
 **/

package ejercicios_loom.ejercicio03;

public class Ejercicio03 {

	/**
	 * La moda es el valor que mas se repite
	 **/
	public static int[] devolverModa(int matriz[][]) {
		int vectorModa[] = new int[matriz.length];
		int fila = 0;

		while (fila < matriz.length) {
			int moda = 0;
			int maxRepeticiones = 0;

			for (int i = 0; i < matriz[fila].length; i++) {
				int repeticiones = 0;

				for (int j = i + 1; j < matriz[fila].length; j++) {
					if (matriz[fila][i] == matriz[fila][j])
						repeticiones++;
				}

				if (maxRepeticiones == repeticiones && moda < matriz[fila][i]) {
					moda = matriz[fila][i];
				} else if (maxRepeticiones < repeticiones) {
					moda = matriz[fila][i];
					maxRepeticiones = repeticiones;
				}
			}

			vectorModa[fila] = moda;
			fila++;
		}

		return vectorModa;
	}

	public static void main(String[] args) {
		int matriz[][] = { { 1, 2, 3, 4 }, { 5, -6, -6, 20 }, { 1, 1, 10, 10 } };

		int vectorModa[] = devolverModa(matriz);

		System.out.println();

		for (int i = 0; i < vectorModa.length; i++) {
			System.out.print(vectorModa[i] + " ");
		}

		int matriz2[][] = { { 1, 2, 3, 4 }, { -6, 5, -6, 20 }, { 1, 10, 1, 10 }, { -1, 0, 7, -1 } };

		int vectorModa2[] = devolverModa(matriz2);

		System.out.println();

		for (int i = 0; i < vectorModa2.length; i++) {
			System.out.print(vectorModa2[i] + " ");
		}
	}

}
