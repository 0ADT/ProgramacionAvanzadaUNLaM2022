package ejercicios_OIA.letrasExtremas;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestLetrasExtremas {
	
	private final String in = "src\\test\\resources\\ejercicios_OIA\\letrasExtremas\\Lote De Prueba\\Entrada\\";
	private final String out = "src\\test\\resources\\ejercicios_OIA\\letrasExtremas\\Lote De Prueba\\Salida Ejecucion\\";
	private final String expected = "src\\test\\resources\\ejercicios_OIA\\letrasExtremas\\Lote De Prueba\\Salida Esperada\\";

	/**
	 * @brief Metodo para cargar las lineas de los archivos
	 * 
	 * @param archivo: ruta completa donde se encuentran los archivos
	 * 
	 * @return Una lista con todas las lineas del archivo
	 **/
	private List<String> leerArchivo(String archivo) {
		List<String> lineasArchivo = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(archivo)));
			String linea;

			while ((linea = br.readLine()) != null) {
				lineasArchivo.add(linea);
			}

			br.close();
		} catch (Exception e) {
			System.err.println("Error al leer un archivo en el test " + archivo);
			throw new AssertionError();
		}

		return lineasArchivo;
	}

	@Test
	public void Caso_01_Flujo_normal() {
		LetrasExtremas lt = new LetrasExtremas(LeerArchivoLetrasExtremas.leerArchivo(in + "Caso_01_Flujo_normal.in"));

		lt.resolver();
		EscribirArchivoLetrasExtremas.EscribirArchivo(out + "Caso_01_Flujo_normal.out", lt.getResultados());
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(expected + "Caso_01_Flujo_normal.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(out+ "Caso_01_Flujo_normal.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_02_Hay_una_letra_extrema_en_lista_con_maxima_cantidad_de_palabras() {
		LetrasExtremas lt = new LetrasExtremas(LeerArchivoLetrasExtremas.leerArchivo(in + "Caso_02_Hay_una_letra_extrema_en_lista_con_maxima_cantidad_de_palabras.in"));

		lt.resolver();
		EscribirArchivoLetrasExtremas.EscribirArchivo(out + "Caso_02_Hay_una_letra_extrema_en_lista_con_maxima_cantidad_de_palabras.out", lt.getResultados());
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(expected + "Caso_02_Hay_una_letra_extrema_en_lista_con_maxima_cantidad_de_palabras.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(out+ "Caso_02_Hay_una_letra_extrema_en_lista_con_maxima_cantidad_de_palabras.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_03_Encuentra_letras_repetidas() {
		LetrasExtremas lt = new LetrasExtremas(LeerArchivoLetrasExtremas.leerArchivo(in + "Caso_03_Encuentra_letras_repetidas.in"));

		lt.resolver();
		EscribirArchivoLetrasExtremas.EscribirArchivo(out + "Caso_03_Encuentra_letras_repetidas.out", lt.getResultados());
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(expected + "Caso_03_Encuentra_letras_repetidas.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(out+ "Caso_03_Encuentra_letras_repetidas.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_04_Una_letra_como_palabra() {
		LetrasExtremas lt = new LetrasExtremas(LeerArchivoLetrasExtremas.leerArchivo(in + "Caso_04_Una_letra_como_palabra.in"));

		lt.resolver();
		EscribirArchivoLetrasExtremas.EscribirArchivo(out + "Caso_04_Una_letra_como_palabra.out", lt.getResultados());
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(expected + "Caso_04_Una_letra_como_palabra.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(out+ "Caso_04_Una_letra_como_palabra.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_05_Una_palabra() {
		LetrasExtremas lt = new LetrasExtremas(LeerArchivoLetrasExtremas.leerArchivo(in + "Caso_05_Una_palabra.in"));

		lt.resolver();
		EscribirArchivoLetrasExtremas.EscribirArchivo(out + "Caso_05_Una_palabra.out", lt.getResultados());
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(expected + "Caso_05_Una_palabra.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(out+ "Caso_05_Una_palabra.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_06_Dos_letras_con_la_misma_cantidad_de_repeticiones() {
		LetrasExtremas lt = new LetrasExtremas(LeerArchivoLetrasExtremas.leerArchivo(in + "Caso_06_Dos_letras_con_la_misma_cantidad_de_repeticiones.in"));

		lt.resolver();
		EscribirArchivoLetrasExtremas.EscribirArchivo(out + "Caso_06_Dos_letras_con_la_misma_cantidad_de_repeticiones.out", lt.getResultados());
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(expected + "Caso_06_Dos_letras_con_la_misma_cantidad_de_repeticiones.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(out+ "Caso_06_Dos_letras_con_la_misma_cantidad_de_repeticiones.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
}
