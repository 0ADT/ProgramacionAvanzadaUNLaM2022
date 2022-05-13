package utilitarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ArchivoLuchadoresJaponeses {

	private static void crearArchivoLuchadoresConIgualesValores(int p, int h, int cantLuchadores,
			String ubicacionArchivo) {
		try {
			File file = new File(ubicacionArchivo); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.write(cantLuchadores + "\n");// Escribir la cadena en el archivo.

			for (int i = 0; i < cantLuchadores; i++) {
				bw.write(p + " " + h + "\n");
			}

			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void crearArchivoOut(int valor, int cantLuchadores, String ubicacionArchivo) {
		try {
			File file = new File(ubicacionArchivo); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			for (int i = 0; i < cantLuchadores; i++) {
				bw.write(valor + "\n");
			}

			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		crearArchivoLuchadoresConIgualesValores(300, 1500, 100000, "src\\test\\resources\\ejercicios_en_clase\\luchadoresJaponeses\\Lote de Prueba\\Entrada\\Caso_04_El_ultimo_luchador_domina_a_todos.in");
		crearArchivoOut(0, 100000, "src\\test\\resources\\ejercicios_en_clase\\luchadoresJaponeses\\Lote de Prueba\\Salida Esperada\\Caso_04_El_ultimo_luchador_domina_a_todos.out");

	}

}
