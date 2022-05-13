package ejercicios_en_clase.armandoMoviles;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestArmandoMoviles {
	private String entrada = "src\\test\\resources\\ejercicios_en_clase\\armandoMoviles\\Lote de Prueba\\Entrada\\";
	private String salidaEjecucion = "src\\test\\resources\\ejercicios_en_clase\\armandoMoviles\\Lote de Prueba\\Salida Ejecucion\\";
	private String salidaEsperada = "src\\test\\resources\\ejercicios_en_clase\\armandoMoviles\\Lote de Prueba\\Salida Esperada\\";

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
	public void Caso_01_flujo_Normal() {
		Artesano artesano = new Artesano(entrada + "Caso_01_Flujo_Normal.in", salidaEjecucion + "Caso_01_Flujo_Normal.out");
		
		if(!artesano.CargarColgantes())
			Assert.fail("Error al abrir el archivo con los colgantes");
		
		artesano.ArmarColgantes();
		
		if(!artesano.GuardarColgantes())
			Assert.fail("Error al guardar el archivo con el peso y las varillas");
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_01_Flujo_Normal.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_01_Flujo_Normal.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_02_Ningún_Colgante() {
		Artesano artesano = new Artesano(entrada + "Caso_02_Ningún_Colgante.in", salidaEjecucion + "Caso_02_Ningún_Colgante.out");
		
		if(!artesano.CargarColgantes())
			Assert.fail("Error al abrir el archivo con los colgantes");
		
		artesano.ArmarColgantes();
		
		if(!artesano.GuardarColgantes())
			Assert.fail("Error al guardar el archivo con el peso y las varillas");
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_02_Ningún_Colgante.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_02_Ningún_Colgante.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_03_Los_Colgantes_No_Permiten_Crear_Moviles() {
		Artesano artesano = new Artesano(entrada + "Caso_03_Los_Colgantes_No_Permiten_Crear_Moviles.in", salidaEjecucion + "Caso_03_Los_Colgantes_No_Permiten_Crear_Moviles.out");
		
		if(!artesano.CargarColgantes())
			Assert.fail("Error al abrir el archivo con los colgantes");
		
		artesano.ArmarColgantes();
		
		if(!artesano.GuardarColgantes())
			Assert.fail("Error al guardar el archivo con el peso y las varillas");
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_03_Los_Colgantes_No_Permiten_Crear_Moviles.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_03_Los_Colgantes_No_Permiten_Crear_Moviles.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_04_Maximos_Valores() {
		Artesano artesano = new Artesano(entrada + "Caso_04_Maximos_Valores.in", salidaEjecucion + "Caso_04_Maximos_Valores.out");
		
		if(!artesano.CargarColgantes())
			Assert.fail("Error al abrir el archivo con los colgantes");
		
		artesano.ArmarColgantes();
		
		if(!artesano.GuardarColgantes())
			Assert.fail("Error al guardar el archivo con el peso y las varillas");
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_04_Maximos_Valores.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_04_Maximos_Valores.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_05_Solo_Un_Movil_Armado() {
		Artesano artesano = new Artesano(entrada + "Caso_05_Solo_Un_Movil_Armado.in", salidaEjecucion + "Caso_05_Solo_Un_Movil_Armado.out");
		
		if(!artesano.CargarColgantes())
			Assert.fail("Error al abrir el archivo con los colgantes");
		
		artesano.ArmarColgantes();
		
		if(!artesano.GuardarColgantes())
			Assert.fail("Error al guardar el archivo con el peso y las varillas");
		
		List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_05_Solo_Un_Movil_Armado.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_05_Solo_Un_Movil_Armado.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
	
	@Test
	public void Caso_06_Pesos_De_Colgantes_Aleatorios() {
		Artesano artesano = new Artesano(entrada + "Caso_06_Pesos_De_Colgantes_Aleatorios.in", salidaEjecucion + "Caso_06_Pesos_De_Colgantes_Aleatorios.out");
		
		if(!artesano.CargarColgantes())
			Assert.fail("Error al abrir el archivo con los colgantes");
		
		artesano.ArmarColgantes();
		
		if(!artesano.GuardarColgantes())
			Assert.fail("Error al guardar el archivo con el peso y las varillas");
		
		//List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_06_Pesos_De_Colgantes_Aleatorios.out");
		//List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_06_Pesos_De_Colgantes_Aleatorios.out");

		//assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
}
