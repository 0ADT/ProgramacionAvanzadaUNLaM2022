package desafios_del_taller.desafio00;

public class Punto {

	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	/**
	 * @brief Calcula y devuelve la distancia entre dos puntos: 
	 * sqrt((x1 - x2)^2 + (y1 - y2)^2)
	 * 
	 * @param p2: Punto con el cual quiero calcular la distancia.
	 * 
	 * @return distancia al punto del tipo double.
	 **/
	public double DistanciaAlPunto(Punto p2) {
		return Math.hypot(this.x - p2.getX(), this.y - p2.getY());
	}
}
