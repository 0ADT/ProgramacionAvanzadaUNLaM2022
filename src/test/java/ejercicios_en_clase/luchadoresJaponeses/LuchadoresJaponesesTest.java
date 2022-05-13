package ejercicios_en_clase.luchadoresJaponeses;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LuchadoresJaponesesTest {

	private String in = "src/test/resources/ejercicios_en_clase/luchadoresJaponeses/Lote de Prueba/Entrada/";
	private String out = "src/test/resources/ejercicios_en_clase/luchadoresJaponeses/Lote de Prueba/Salida del Programa/";
	private String salidaEsperada = "src/test/resources/ejercicios_en_clase/luchadoresJaponeses/Lote de Prueba/Salida Esperada/";

	@Test
	public void Caso_01_Flujo_normal() {
		Torneo torneoCaso01 = new Torneo("Caso_01_Flujo_normal", in + "Caso_01_Flujo_normal.in",
				out + "Caso_01_Flujo_normal.out");

		torneoCaso01.iniciarCompetencia();

		List<String> lineasArchivoSalidaEsperada = new ArrayList<String>();
		List<String> lineasArchivoSalidaPrograma = new ArrayList<String>();

		try {
			BufferedReader brSalidaEsperada = new BufferedReader(
					new FileReader(new File(salidaEsperada + "Caso_01_Flujo_normal.out")));
			BufferedReader brSalidaPrograma = new BufferedReader(
					new FileReader(new File(out + "Caso_01_Flujo_normal.out")));
			String linea;

			while ((linea = brSalidaEsperada.readLine()) != null) {
				lineasArchivoSalidaEsperada.add(linea);
			}

			brSalidaEsperada.close();

			while ((linea = brSalidaPrograma.readLine()) != null) {
				lineasArchivoSalidaPrograma.add(linea);
			}

			brSalidaPrograma.close();
		} catch (Exception e) {
			System.err.println("Error al leer un archivo en el test Caso_01_Flujo_normal");
			throw new AssertionError();
		}

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_02_Un_luchador_solo() {
		Torneo torneoCaso02 = new Torneo("Caso_02_Un_luchador_solo", in + "Caso_02_Un_luchador_solo.in",
				out + "Caso_02_Un_luchador_solo.out");

		torneoCaso02.iniciarCompetencia();

		List<String> lineasArchivoSalidaEsperada = new ArrayList<String>();
		List<String> lineasArchivoSalidaPrograma = new ArrayList<String>();

		try {
			BufferedReader brSalidaEsperada = new BufferedReader(
					new FileReader(new File(salidaEsperada + "Caso_02_Un_luchador_solo.out")));
			BufferedReader brSalidaPrograma = new BufferedReader(
					new FileReader(new File(out + "Caso_02_Un_luchador_solo.out")));
			String linea;

			while ((linea = brSalidaEsperada.readLine()) != null) {
				lineasArchivoSalidaEsperada.add(linea);
			}

			brSalidaEsperada.close();

			while ((linea = brSalidaPrograma.readLine()) != null) {
				lineasArchivoSalidaPrograma.add(linea);
			}

			brSalidaPrograma.close();
		} catch (Exception e) {
			System.err.println("Error al leer un archivo en el test Caso_02_Un_luchador_solo");
			throw new AssertionError();
		}

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_03_Valores_maximos_de_entrada() {
		Torneo torneoCaso03 = new Torneo("Caso_03_Valores_maximos_de_entrada",
				in + "Caso_03_Valores_maximos_de_entrada.in", out + "Caso_03_Valores_maximos_de_entrada.out");

		torneoCaso03.iniciarCompetencia();

		List<String> lineasArchivoSalidaEsperada = new ArrayList<String>();
		List<String> lineasArchivoSalidaPrograma = new ArrayList<String>();

		try {
			BufferedReader brSalidaEsperada = new BufferedReader(
					new FileReader(new File(salidaEsperada + "Caso_03_Valores_maximos_de_entrada.out")));
			BufferedReader brSalidaPrograma = new BufferedReader(
					new FileReader(new File(out + "Caso_03_Valores_maximos_de_entrada.out")));
			String linea;

			while ((linea = brSalidaEsperada.readLine()) != null) {
				lineasArchivoSalidaEsperada.add(linea);
			}

			brSalidaEsperada.close();

			while ((linea = brSalidaPrograma.readLine()) != null) {
				lineasArchivoSalidaPrograma.add(linea);
			}

			brSalidaPrograma.close();
		} catch (Exception e) {
			System.err.println("Error al leer un archivo en el test Caso_03_Valores_maximos_de_entrada");
			throw new AssertionError();
		}

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_04_El_ultimo_luchador_domina_a_todos() {
		Torneo torneoCaso04 = new Torneo("Caso_04_El_ultimo_luchador_domina_a_todos",
				in + "Caso_04_El_ultimo_luchador_domina_a_todos.in",
				out + "Caso_04_El_ultimo_luchador_domina_a_todos.out");

		torneoCaso04.iniciarCompetencia();

		List<String> lineasArchivoSalidaEsperada = new ArrayList<String>();
		List<String> lineasArchivoSalidaPrograma = new ArrayList<String>();

		try {
			BufferedReader brSalidaEsperada = new BufferedReader(
					new FileReader(new File(salidaEsperada + "Caso_04_El_ultimo_luchador_domina_a_todos.out")));
			BufferedReader brSalidaPrograma = new BufferedReader(
					new FileReader(new File(out + "Caso_04_El_ultimo_luchador_domina_a_todos.out")));
			String linea;

			while ((linea = brSalidaEsperada.readLine()) != null) {
				lineasArchivoSalidaEsperada.add(linea);
			}

			brSalidaEsperada.close();

			while ((linea = brSalidaPrograma.readLine()) != null) {
				lineasArchivoSalidaPrograma.add(linea);
			}

			brSalidaPrograma.close();
		} catch (Exception e) {
			System.err.println("Error al leer un archivo en el test Caso_04_El_ultimo_luchador_domina_a_todos");
			throw new AssertionError();
		}

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_05_Un_luchador_intermedio_domina_a_los_demas() {
		Torneo torneoCaso05 = new Torneo("Caso_05_Un_luchador_intermedio_domina_a_los_demas",
				in + "Caso_05_Un_luchador_intermedio_domina_a_los_demas.in",
				out + "Caso_05_Un_luchador_intermedio_domina_a_los_demas.out");

		torneoCaso05.iniciarCompetencia();

		List<String> lineasArchivoSalidaEsperada = new ArrayList<String>();
		List<String> lineasArchivoSalidaPrograma = new ArrayList<String>();

		try {
			BufferedReader brSalidaEsperada = new BufferedReader(
					new FileReader(new File(salidaEsperada + "Caso_05_Un_luchador_intermedio_domina_a_los_demas.out")));
			BufferedReader brSalidaPrograma = new BufferedReader(
					new FileReader(new File(out + "Caso_05_Un_luchador_intermedio_domina_a_los_demas.out")));
			String linea;

			while ((linea = brSalidaEsperada.readLine()) != null) {
				lineasArchivoSalidaEsperada.add(linea);
			}

			brSalidaEsperada.close();

			while ((linea = brSalidaPrograma.readLine()) != null) {
				lineasArchivoSalidaPrograma.add(linea);
			}

			brSalidaPrograma.close();
		} catch (Exception e) {
			System.err.println("Error al leer un archivo en el test Caso_05_Un_luchador_intermedio_domina_a_los_demas");
			throw new AssertionError();
		}

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
}
