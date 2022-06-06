package utilitarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class ArchivoMesadasDeGranito {

	private static void crearArchivoIn(int cantMesadas, String ubicacionArchivo) {
		try {
			File file = new File(ubicacionArchivo); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.write(cantMesadas + "\n");

			int ancho;
			int largo;

			for (int i = 0; i < cantMesadas; i++) {
				Random rd = new Random();
				
				ancho = rd.nextInt(1000001);
				largo = rd.nextInt(1000001);
				bw.write(ancho + " " + largo + "\n");
			}

			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void crearArchivoMesadasIgualesIn(int cantMesadas, String ubicacionArchivo) {
		try {
			File file = new File(ubicacionArchivo); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.write(cantMesadas + "\n");

			int ancho = 2;
			int largo = 2;

			for (int i = 0; i < cantMesadas; i++) {
				bw.write(ancho + " " + largo + "\n");
			}

			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		crearArchivoIn(200000, "src/test/resources/ejercicios_loom/oia2/Lote De Prueba/Entrada/Caso_00_.in");
		crearArchivoMesadasIgualesIn(200000, "src\\test\\resources\\ejercicios_loom\\oia2\\Lote De Prueba\\Entrada\\Caso_00_Iguales.in");

	}

}
