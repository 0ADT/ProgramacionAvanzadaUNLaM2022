package ejercicios_en_clase.luchadoresJaponeses;

/**
 * Descripcion del problema
 * 
 * Una academia dedicada a las dificiles artes de lucha oriental, esta¡
 * organizando un torneo de luchadores sumo.
 * 
 * A los efectos de conformar la grilla de combates, es necesario armar parejas
 * de luchadores que puedan ofrecer un espectaculo atractivo. Como es sabido que
 * los cultores de esta disciplina son hombres de estructura fisica imponente,
 * los organizadores habitualmente arman duplas de combatientes estableciendo
 * comparaciones relativas a sus alturas y pesos.
 * 
 * Por experiencia, los organizadores saben que un combatiente "domina" a otro
 * si lo supera en ambas medidas, o bien si lo iguala en peso y lo supera en
 * altura, o viceversa. En cualquier otro caso, los luchadores no son
 * comparables lo que hace el resultado imprevisible y por lo tanto mas
 * atractivo para el publico.
 * 
 * Sabiendo que no hay luchadores que coinciden en ambas medidas, los
 * organizadores quieren saber a cuantos posibles contrincantes domina cada uno
 * de ellos, y por esta razon se te pide que escribas un programa que efectue
 * este recuento
 * 
 * Datos de entrada 
 * Se recibe un archivo sumo.in con el siguiente formato: 
 * 	-Una linea que indica la cantidad L (1 <= L <= 100.000) de luchadores. 
 * 	-L lineas con 2 numeros P y H (0 <= P,H <= 1.000.000) que indican el peso y la altura de cada
 * participante, separados por blancos.
 * 
 * Datos de salida
 * Se debe generar un archivo sumo.out conteniendo
 * 	-L lineas con la cantidad de luchadores a quienes domina cada participante, en el mismo
 * orden en el que los participantes entraron.
 * 
 * Ejemplo Para la entrada: 
 * 10
 * 300 1500 
 * 320 1500 
 * 299 1580 
 * 330 1690 
 * 330 1540 
 * 339 1500 
 * 298 1700 
 * 344 1570 
 * 276 1678 
 * 289 1499
 * 
 * La salida debe ser: 
 * 1
 * 2 
 * 1 
 * 6 
 * 3 
 * 3 
 * 2 
 * 5 
 * 0 
 * 0
 **/
public class Main {

	public static void main(String[] args) {
		Torneo torneo = new Torneo("Luchadores Japoneses", "/src/main/resources/ejercicios_en_clase/luchadoresJaponeses/sumo.in","/src/main/resources/ejercicios_en_clase/luchadoresJaponeses/sumo.out");
		
		torneo.iniciarCompetencia();
	}

}
