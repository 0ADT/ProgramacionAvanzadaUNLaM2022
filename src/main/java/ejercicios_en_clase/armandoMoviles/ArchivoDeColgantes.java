package ejercicios_en_clase.armandoMoviles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoDeColgantes {
	private String entrada;
	private String salida;

	public ArchivoDeColgantes(String entrada, String salida) {
		this.entrada = entrada;
		this.salida = salida;
	}

	public List<Colgante> LeerEntrada() {
		List<Colgante> colgantes = new ArrayList<Colgante>();

		try {
			File archivo = new File(entrada);

			if (!archivo.exists())
				return null;

			Scanner sc = new Scanner(archivo);
			int cantColgantes = sc.nextInt();

			for (int i = 0; i < cantColgantes; i++)
				colgantes.add(new Colgante(sc.nextInt()));

			sc.close();
		} catch (Exception e) {
			System.err.println("Error al abrir el archivo con los colgantes en " + entrada);
			colgantes = null;
		}

		return colgantes;
	}

	public boolean GuardarSalida(int pesoTotal, int cantVarillas) {
		try {
			File archivo = new File(salida);

			if (!archivo.exists())
				archivo.createNewFile();

			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

			if (pesoTotal == 0 || cantVarillas == 0)
				bw.write("no se puede");
			else
				bw.write(pesoTotal + " " + cantVarillas);
			
			bw.close();
		} catch (Exception e) {
			System.err.println("Error al guardar el archivo con los colgantes en " + this.salida);
			return false;
		}

		return true;
	}

}
