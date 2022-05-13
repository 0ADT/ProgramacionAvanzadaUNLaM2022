package desafios_del_taller.desafio02;

/**
 * Consigna: El Pony Express fue un servicio de correo rápido que cruzaba
 * Estados Unidos. Empezaba en St. Joseph (Misuri) y llegaba hasta Sacramento
 * (California). Estuvo operativo desde abril de 1860 a noviembre de 1861. Los
 * mensajes se llevaban a caballo a lo largo de praderas, planicies, desiertos y
 * montañas. Redujo el tiempo que tardaba el correo en llegar desde el océano
 * Atlántico al océano Pacífico a diez días.
 * 
 * Cómo funcionaba: Habia una cierta cantidad de estaciones, donde el jinete
 * cambiaba su caballo por uno fresco, o se le pasaba la bolsa de correo al
 * próximo jinete.
 * 
 * El problema: Se te pide ayuda para implementar el siguiente método:
 **
 * 
 //* @param estaciones es la distancia en millas de una estación hasta la otra
 //* @returns la cantidad de jinetes necesarios para enviar el correo desde un
 //*          extremo hasta el otro del recorrido
 * public int jinetes(int[] estaciones) { }
 * 
 * Nota: Cada jinete viaja tan lejos como puede, pero nunca lo hace más
 * de 100 millas seguidas
 * 
 * Algunos ejemplos Los siguientes ejemplos pueden servirte para probar
 * tu solución. Si hicieras más, ¡agregalas a tu respuesta!
 * 
 * Assert.assertEquals(1, jinetes(new int[] {18, 15}));
 * Assert.assertEquals(2, jinetes(new int[] {43, 23, 40, 13}));
 * Assert.assertEquals(3, jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
 * Assert.assertEquals(3, jinetes(new int[] {51, 51, 51}));
 * Assert.assertEquals(4, jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
 **/

public class PonyExpress {
	
	public static int jinetes(int[] estaciones) {
		int jinetes = 1;
		int millas = estaciones[0];
		
		for(int i = 1; i < estaciones.length; i++) {
			millas += estaciones[i];
			
			if(millas > 100) {
				jinetes++;
				millas = estaciones[i];
			}
		}
		
		return jinetes;
	}

}
