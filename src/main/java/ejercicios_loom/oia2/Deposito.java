package ejercicios_loom.oia2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deposito {
	private List<Mesada> mesadas = new ArrayList<Mesada>();
	private int cantDePilas = 0;

	public boolean CargarMesadas(String archivoMesadas) {
		ArchivoDeMesadas archivo = new ArchivoDeMesadas();

		mesadas = archivo.LeerArchivo(archivoMesadas);

		return mesadas != null;
	}

	public boolean GuardarMesadas(String archivoMesadas) {
		ArchivoDeMesadas archivo = new ArchivoDeMesadas();

		return archivo.EscribirArchivo(archivoMesadas, this.cantDePilas);
	}

	public boolean ApilarMesadas() {
		if (mesadas == null) {
			System.err.println("No hay mesadas cargadas");
			return false;
		}

		// Ordeno por ancho, de mayor a menor
		Collections.sort(mesadas);

		// Se toma la primer mesada y busca cual puede apilarse sobre esta
		// si encuentra una, borra la primer mesada y busco otra mesada pero
		// usando la mesada actual. Al finalizar el recorrido, borro la ultima
		// mesada utilizada para comparar.
		// Si hay solo una mesada, se incrementa la pila y se la borra.
		while (mesadas.size() > 0) {
			int j = 0;
			boolean sePuedeApilar = false;

			if (mesadas.size() == 1) {
				cantDePilas++;
				mesadas.remove(0);
			}

			for (int i = j + 1; i <= mesadas.size();) {
				if (mesadas.get(j).SePuedeApilar(mesadas.get(i))) {
					sePuedeApilar = true;
					mesadas.remove(j);
					j = i - 1;
				} else
					i++;

				if (i == mesadas.size()) {
					sePuedeApilar = true;
					mesadas.remove(j); // remuevo el ultimo que use para comparar
				}
			}

			if (sePuedeApilar) {
				cantDePilas++;
			}
		}

		return true;
	}
}
