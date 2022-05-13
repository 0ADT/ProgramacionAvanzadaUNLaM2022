package ejercicios_loom.ejercicio07;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Consigna: 1. Escribir un archivo de entre 10 mil y 20 mil números enteros
 * aleatorios, en el rango de 0 a 12000. (La cantidad de números debe ser
 * aleatoria) 
 * 2. Leer dicho archivo, buscando (a) máximo, (b) mínimo, (c)
 * promedio. 
 * 3. Escribr un segundo archivo con una tabla de resultados. Ejemplo:
 * 
 * +----------+-------+ 
 * | Máximo | 11978 | 
 * +----------+-------+ 
 * | Mínimo | 3 |
 * +----------+-------+ 
 * | Promedio | 7201 | 
 * +----------+-------+
 *
 * ¡El formato de la última salida es parte del desafío!
 **/
public class ejercicio07 {

	private static List<Integer> numeros = new ArrayList<Integer>();
	private static String path = "src\\main\\resources\\ejercicios_loom\\ejercicio07\\20MilAleatorio.dat";
	private static long sumaNumeros = 0;
	private static int maximo;
	private static int minimo;
	private static int promedio;
	
	/**
	 * @brief Escribe en un archivo una determinada cantidad de numeros
	 *        pseudoaleatorios
	 **/
	public static void EscribirArchivoNumAleatorios() {
		Random rd = new Random();

		//cambio la semilla para darle un poco mas de aleatoriedad
		rd.setSeed(System.currentTimeMillis()); 
		
		//nexInt de Random devuelve un numero entre 0 y n - 1
		int cantNum =rd.nextInt(10001) + 10000; 
		
		rd.setSeed(System.currentTimeMillis());
		
		int numAleatorio = rd.nextInt(12001);

		try {
			File file = new File(path); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			for (int i = 0; i < cantNum; i++) {
				bw.write(numAleatorio + "\n");
				numAleatorio = rd.nextInt(12001);
			}

			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @brief Lee un archivo con numeros y carga los valores para operar con ellos,
	 * 	tambien suma dichos valores para sacar el promedio.
	 **/
	public static void LeerArchivo() throws FileNotFoundException {
		Scanner archivo = new Scanner (new File(path));
		
		while(archivo.hasNext()) {
			
			  String linea=archivo.nextLine();			  
			  int nro = Integer.parseInt(linea + "");
			  
			  numeros.add(nro);
			  sumaNumeros += nro;
		}
		
		archivo.close();		
	}

	/**
	 * @brief Busca el maximo, el minimo y el promedio en la lista
	 * de numeros, primero ordena dicha lista para hacer la operacion
	 * mas facil.
	 **/
	public static void BuscarDatos() {
		promedio = (int) (sumaNumeros / numeros.size());
		numeros.sort(null); //ordenamiento natural
		minimo = numeros.get(0);
		maximo = numeros.get(numeros.size() - 1);
	}
	
	/**
	 * @brief Escribe un archivo con los resultados pedidos en el formato
	 * +----------+-------+ 
	 * | Máximo | a | 
	 * +----------+-------+ 
	 * | Mínimo | b |
	 * +----------+-------+ 
	 * | Promedio | c | 
	 * +----------+-------+
	 **/
	public static void EscribirResultados() {
		String ruta = path.substring(0, path.length() - 5) + ".txt";
		try {
			File file = new File(ruta); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.write("+----------+-------+\n");
			bw.write("| Máximo | " + maximo + " |\n");
			bw.write("+----------+-------+\n");
			bw.write("| Mínimo | " + minimo + " |\n");
			bw.write("+----------+-------+\n");
			bw.write("| Promedio | " + promedio + " |\n");
			bw.write("+----------+-------+");
			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws FileNotFoundException 
	 * @brief Realiza toda la operacion pedida en el ejercicio
	 **/
	public static void RealizarOperacion() throws FileNotFoundException {
		EscribirArchivoNumAleatorios();
		LeerArchivo();
		BuscarDatos();
		EscribirResultados();		
	}
	
	public static void main(String[] args) throws FileNotFoundException {		
		System.out.println("Inicia Ejercicio 07");
		RealizarOperacion();
		System.out.println("Fin del Ejercicio 07");
	}

}
