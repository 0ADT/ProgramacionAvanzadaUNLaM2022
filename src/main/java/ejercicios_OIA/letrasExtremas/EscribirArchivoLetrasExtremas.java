package ejercicios_OIA.letrasExtremas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscribirArchivoLetrasExtremas {
	public static boolean EscribirArchivo(String ubicacion, ArrayList<String> resultados) {
		try {
			File archivo = new File(ubicacion);

			if (!archivo.exists())
				archivo.createNewFile();

			PrintWriter pw = new PrintWriter(new FileWriter(archivo));

			for (String st : resultados) {
				pw.write(st + "\n");
			}

			pw.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}
}
