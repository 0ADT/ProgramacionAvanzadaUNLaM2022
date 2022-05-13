package utilitarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class ArchivoArmandoMoviles {

	private static void crearArchivoRandomIn(int cantColgantes, String ubicacionArchivo) {
		try {
			File file = new File(ubicacionArchivo); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			bw.write(cantColgantes + "\n");

			for (int i = 0; i < cantColgantes; i++) {
				Random rd = new Random();
				
				bw.write(rd.nextInt(101) + "\n");
			}

			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		crearArchivoRandomIn(1000,
				"src\\test\\resources\\ejercicios_en_clase\\armandoMoviles\\Lote de Prueba\\Entrada\\Random.in");
	}
}
