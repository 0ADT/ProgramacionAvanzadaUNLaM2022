package ejercicios_OIA.letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeerArchivoLetrasExtremas {
	public static ArrayList<String> leerArchivo(String archivo) {
		List<String> letras = new ArrayList<String>();

		try {
			Scanner sc = new Scanner(new FileReader(new File(archivo)));
			int cantPalabras = sc.nextInt();

			sc.nextLine();// Obtengo el salto de linea luego de obtener cantidad de palabras

			for (int i = 0; i < cantPalabras; i++) {
				letras.add(sc.nextLine());
			}

			sc.close();
		} catch (FileNotFoundException e) {
			letras = null;
		}

		return (ArrayList<String>) letras;
	}
}
