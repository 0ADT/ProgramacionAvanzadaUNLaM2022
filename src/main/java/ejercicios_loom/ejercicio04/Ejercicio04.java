/**
 * Consigna:
 * Escribir un método en Java que de una matriz cuadrada dada, devuelva una matriz con n filas, donde cada una tendrá los datos
 * de una de las diagonales (de abajo a la izquierda hacia arriba a la derecha)
 * 
 * Ejemplo:
 * Para la matriz
 *  1  2  3  4
 *  5  6  7  8
 *  9  10 11 12
 *  13 14 15 16
 *  
 *  La salida debe ser
 *  13
 *  9 14
 *  5 10 15
 *  1  6 11 16
 *  2  7 12
 *  3  8
 *  4
 **/

package ejercicios_loom.ejercicio04;

import java.util.ArrayList;

public class Ejercicio04 {

	/**
	 * Crea una matriz irregular a partir del tamaño de la matriz cuadrada dada Crea
	 * un triangulo superior, es decir, el tamaño de las filas empieza en 1 y
	 * aumenta hasta tamMatrizOriginal que es el tamaño de la matriz cuadrada. En
	 * otro ciclo ese numero va decreciendo hasta llegar a 1 nuevamente y formar un
	 * triangulo. La cantidad de filas esta dada por la suma de filas y columnas de
	 * la matriz cuadrada menos 1 (esto es para que no cuente 2 veces la posicion
	 * 0,0).
	 ***/
	public static int[][] crearMatriz(int tamMatrizOriginal) {
		int matriz[][] = new int[tamMatrizOriginal + tamMatrizOriginal - 1][];
		int fila = 0;

		///// triangulo superior de la matriz
		for (int i = 1; i < tamMatrizOriginal + 1; i++, fila++)
			matriz[fila] = new int[i];

		//// triangulo inferior de la matriz
		for (int i = tamMatrizOriginal - 1; i > 0; i--, fila++)
			matriz[fila] = new int[i];

		return matriz;
	}

	/**
	 * 
	 **/
	public static int[][] matrizConDiagonales(int matriz[][]) {
		int matrizResultado[][] = crearMatriz(matriz.length);

		for (int col = 0, i = 0; col < matriz.length; col++, i++) {
			for (int fila = matriz.length - 1, j = 0; fila > 0; fila--, j++) {
				matrizResultado[j][i] = matriz[fila][col];
			}
		}

		return matrizResultado;
	}

	public static ArrayList<Integer>[] devuelveDiagonalesEnMatriz(int matriz[][]) {
		ArrayList<Integer>[] matrizDiagonales = new ArrayList[matriz.length + matriz[0].length];
		int fila = 0;

		// triangulo inferior de la matriz
		for (int i = matriz.length - 1; i >= 0; i--, fila++) {
			matrizDiagonales[fila] = new ArrayList<Integer>();

			for (int j = 0, k = i; j < matriz[i].length && k < matriz.length; j++, k++) {
				matrizDiagonales[fila].add(matriz[k][j]);
			}
		}

		// triangulo superior de la matriz

		return matrizDiagonales;
	}

	public static void main(String[] args) {
		int matriz[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int matResultado[][] = matrizConDiagonales(matriz);

		for (int i = 0; i < matResultado.length; i++) {
			for (Integer val : matResultado[i])
				System.out.print(val + " ");

			System.out.println();
		}
	}
}
