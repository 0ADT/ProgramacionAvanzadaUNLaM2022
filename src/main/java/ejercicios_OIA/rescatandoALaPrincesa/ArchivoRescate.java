package ejercicios_OIA.rescatandoALaPrincesa;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoRescate {
	public static void EscribirArchivoRescate(String ruta, String resultado) {
		try {
			File archivo = new File(ruta);

			if (!archivo.exists())
				archivo.createNewFile();

			PrintWriter pw = new PrintWriter(new FileWriter(archivo));

			pw.write(resultado);
			pw.close();
		} catch (IOException e) {
			System.err.println("");
		}
	}

	public static GrafoRescate LeerArchivoRescate(String ruta) {
		GrafoRescate gm = null;

		try {
			File archivo = new File(ruta);
			Scanner sc = new Scanner(new FileReader(archivo));
			int claros = sc.nextInt();
			int senderos = sc.nextInt();
			int dragones = sc.nextInt();

			gm = new GrafoRescate(claros, senderos, dragones, sc.nextInt(), sc.nextInt());

			// agregar dragones
			for (int i = 0; i < dragones; i++) {
				gm.agregarDragon(sc.nextInt(), i);
			}

			// agregar senderos
			for (int i = 0; i < senderos; i++) {
				gm.agregarSendero(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}

			sc.close();
		} catch (IOException e) {
			System.err.println("");
		}

		return gm;
	}
}
