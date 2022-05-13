/**
 * Consigna:
 * Escribir un método en Java que de una matriz numérica dada, devuelva una matriz con la misma cantidad de elementos, pero 
 * donde cada valor es la suma de sus adyacentes originales (arriba, abajo, izquierda, y derecha; si existen)
 * 
 * Ejemplo:
 * Para la matriz
 *  8  2 -3  4
 *  5 -6 -6 20
 *  21  1 -5  0
 *  
 *  La salida debe ser
 *  15  1  -3 21
 *  28 -4   0 18
 *  27 11 -10 15
 **/

package ejercicios_loom.ejercicio02;

public class Ejercicio02 {

	public static void main(String[] args) {
		//Resultado 4 8  8
		//			5 10 11
		//			4 8  8
		int matriz[][] = {
				{1, 2, 3},
				{1, 2, 3},
				{1, 2, 3}
		};
		
		matriz = matrizSumada(matriz);
		mostrarMatriz(matriz);
		System.out.println();
		
		//Resultado 3  5 16 12
		//			5  5 11 16
		//			-1 8 20 -3
		//			0  9 7  2
		int matriz2[][] = {
				{5, -2, 3,  9},
				{0, -1, 6,  0},
				{1,  2, 3,  1},
				{-4, 3, 8, -7}
		};
		
		matriz = matrizSumada(matriz2);
		mostrarMatriz(matriz);
	}
	
	public static int[][] matrizSumada(int matIN[][]) {
		int[][] matOUT = new int [matIN.length][];
		int sum = 0;
		
		//*******************************se suma primer linea de la matriz*************************************************//
		matOUT[0] = new int[matIN[0].length];
		matOUT[0][0] = (matIN[0][0] + matIN[0][1] + matIN[1][0]);
		
		for(int i = 1; i < matIN.length - 1; i++) {
			sum = matIN[0][i - 1] + matIN[0][i] + matIN[0][i + 1] + matIN[1][i];
			matOUT[0][i] = sum;
		}
		
		matOUT[0][matOUT.length - 1] = (matIN[0][matIN.length - 2] + matIN[0][matIN.length - 1] + matIN[1][matIN.length - 1]);
		
		//*******************************suma el centro de la matriz*************************************************//
		for(int i = 1; i < matIN.length - 1; i++) {
			matOUT[i] = new int[matIN[i].length];
			matOUT[i][0] = (matIN[i - 1][0] + matIN[i][0] + matIN[i][1] + matIN[i + 1][0]);
			
			for(int j = 1; j < matIN[i].length - 1; j++) {
				sum = matIN[i][j - 1] + matIN[i][j] + matIN[i][j + 1] + matIN[i + 1][j] + matIN[i - 1][j];
				matOUT[i][j] = sum;
			}
			
			matOUT[i][matOUT[i].length - 1] = (matIN[i][matIN.length - 2] + matIN[i][matIN.length - 1] + matIN[i + 1][matIN.length - 1] + matIN[i - 1][matIN.length - 1]);
		}

		//********************************suma la ultima fila de la matriz************************************************//
		matOUT[matOUT.length - 1] = new int[matIN[matIN.length - 1].length];
		matOUT[matIN.length - 1][0] = (matIN[matIN.length - 1][0] + matIN[matIN.length - 1][1] + matIN[matIN.length - 2][0]);
		
		for(int i = 1; i < matIN.length - 1; i++) {
			sum = matIN[matIN.length - 1][i - 1] + matIN[matIN.length - 1][i] + matIN[matIN.length - 1][i + 1] + matIN[matIN.length - 2][i];
			matOUT[matOUT.length - 1][i] = sum;
		}
		
		matOUT[matOUT.length - 1][matIN.length - 1] = (matIN[matIN.length - 1][matIN.length - 2] + matIN[matIN.length - 1][matIN.length - 1] + matIN[matIN.length - 2][matIN.length - 1]);
		
		return matOUT;
	}
	
	
	public static void mostrarMatriz(int [][] mat) {
		for(int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
