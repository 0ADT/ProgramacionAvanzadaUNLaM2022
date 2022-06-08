package ejercicios_OIA.metro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoMetro {
	public static void EscribirArchivoMetro(String ruta, int resultado) {
		try {
			File archivo = new File(ruta);

			if (!archivo.exists())
				archivo.createNewFile();

			PrintWriter pw = new PrintWriter(new FileWriter(archivo));

			pw.write(resultado + "");
			pw.close();
		} catch (IOException e) {
			System.err.println("");
		}
	}

	public static GrafoMetro LeerArchivoMetro(String ruta) {
		GrafoMetro gm = null;

		try {
			File archivo = new File(ruta);

			if (!archivo.exists()) {

			}

			Scanner sc = new Scanner(new FileReader(archivo));

			gm = new GrafoMetro(sc.nextInt());
			gm.setCantTuneles(sc.nextInt());
			gm.setCantPuentes(sc.nextInt());

			for (int i = 0; i < gm.getCantTuneles(); i++) {
				gm.addTunel(sc.nextInt(), sc.nextInt());
			}

			for (int i = 0; i < gm.getCantPuentes(); i++) {
				gm.addPuente(sc.nextInt(), sc.nextInt());
			}

			sc.close();
		} catch (IOException e) {
			System.err.println("");
		}

		return gm;
	}
}
