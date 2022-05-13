package utilitarios;

/**
 * Consigna
 * 
 * Problema: "Vendedoras premiadas" (OIA)
 * 
 * Crear un lote de pruebas que asegure, con buenas probabilidades de éxito, el correcto funcionamiento del programa que intenta resolverlo.
 * Documentar, en un archivo aparte, cada uno de los casos que compone su lote de pruebas, indicando cual sería la salida esperada para cada uno de ellos, y 
 * si corresponde, cuales son los datos de entrada y qué es lo que se intenta probar en cada caso. En caso de que los datos de entrada sean numerosos, simplemente 
 * indique el nombre del archivo de entrada.
 * Cuando se justifique, codifique un programa probador; es decir, un programa que dado dos archivos (el archivo de entrada y el de salida de otro programa) 
 * nos diga si la salida es correcta (se corresponde con el archivo de entrada).
 **/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @brief Crea un archivo de entrada con los valores maximos para el problema
 *        VendedorasPremiadas
 **/
public class ArchivoInVendedorasPremiadas {

	private static void crearArchivoInVentasMaximas(int vendedoras, int cantVentas, int importe, int ventasContar,
			String ubicacionArchivo) {
		try {
			File file = new File(ubicacionArchivo); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.write(vendedoras + "\n");// Escribir la cadena en el archivo.

			for (int i = 0; i < vendedoras; i++) {
				bw.write(cantVentas + "\n");

				for (int j = 0; j < cantVentas; j++) {
					bw.write(importe + "\n");
				}
			}

			bw.write(ventasContar + "");
			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		crearArchivoInVentasMaximas(100, 999, 5000, 1000, "\\Caso_08_No_hay_ganadoras_con_ventas_al_maximo.IN");
	}

}
