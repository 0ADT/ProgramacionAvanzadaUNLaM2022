package ejercicios_OIA.letrasExtremas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LetrasExtremas {
	private ArrayList<String> palabras;
	private ArrayList<String> resultados = new ArrayList<String>();

	public LetrasExtremas(ArrayList<String> letras) {
		this.palabras = letras;
	}

	public void resolver() {
		HashMap<Character, Integer> letrasExtremas = new HashMap<Character, Integer>();

		// Realiza el conteo de letras repetidas al inicio y al final de cada palabra
		// O(n)
		for (String palabra : palabras) {
			char letraInicial;
			char letraFinal;

			if (palabra.length() > 1) {
				letraFinal = palabra.charAt(palabra.length() - 1);

				if (!letrasExtremas.containsKey(letraFinal)) { // O(1)
					letrasExtremas.put(letraFinal, 1);
				} else {
					letrasExtremas.put(letraFinal, letrasExtremas.get(letraFinal) + 1);
				}
			}

			letraInicial = palabra.charAt(0);

			if (!letrasExtremas.containsKey(letraInicial)) { // O(1)
				letrasExtremas.put(letraInicial, 1);
			} else {
				letrasExtremas.put(letraInicial, letrasExtremas.get(letraInicial) + 1);
			}
		}

		// Encuentra el maximo valor de repeticiones y carga en un array las letras que
		// cumplan con ese valor, esto es por si existiesen mas de una letra que se
		// repita
		int maxValue = (Collections.max(letrasExtremas.values())); // O(n)
		ArrayList<Character> letras = new ArrayList<Character>();

		// O(n)
		for (Map.Entry<Character, Integer> letra : letrasExtremas.entrySet()) {
			if (letra.getValue().equals(maxValue)) {
				letras.add(letra.getKey());

				if (resultados.isEmpty()) {
					resultados.add(letra.getKey() + "");
				} else {
					resultados.set(0, resultados.get(0).concat(" " + letra.getKey())); // O(1)
				}
			}
		}

		// Se cargan las palabras que coincidan con las letras en un array sin repetidos
		ArrayList<String> palabrasResultados = new ArrayList<String>();

		// O(n^2)
		for (String palabra : palabras) { // O(n)
			if ((letras.contains(palabra.charAt(0)) || letras.contains(palabra.charAt(palabra.length() - 1)))
					&& !palabrasResultados.contains(palabra)) {// O(2n)
				palabrasResultados.add(palabra);
			}
		}

		resultados.addAll(palabrasResultados);
	}

	public ArrayList<String> getResultados() {
		return this.resultados;
	}
}
