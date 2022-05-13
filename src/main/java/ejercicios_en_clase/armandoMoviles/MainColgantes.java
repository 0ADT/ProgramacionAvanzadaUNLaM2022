package ejercicios_en_clase.armandoMoviles;

public class MainColgantes {

	public static void main(String[] args) {
		Artesano artesano = new Artesano("src/main/resources/ejercicios_en_clase/armandoMoviles/colgantes.in", "src/main/resources/ejercicios_en_clase/armandoMoviles/colgantes.out");
		
		artesano.CargarColgantes();
		artesano.ArmarColgantes();
		artesano.GuardarColgantes();
	}

}
