package desafios_del_taller.miniChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class RegistroChat {
	public static String LeerRegistro() {
		String mensajes = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("LOG.txt")));
			String linea;

			while ((linea = br.readLine()) != null) {
				mensajes += linea + "\n";
			}

			br.close();
		} catch (Exception e) {
			System.out.println("No hay archivo de log");
		}

		return mensajes;
	}

	public static void EscribirRegistro(String mensaje) {
		try {
			File archivo = new File("LOG.txt");

			if (!archivo.exists())
				archivo.createNewFile();

			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));

			bw.write(mensaje + System.lineSeparator());
			bw.close();
		} catch (Exception e) {
			System.err.println(e.getCause());
		}
	}
}
