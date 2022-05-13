package desafios_del_taller.desafio00;

public class Circulo {

	private Punto centro;
	private double radio;
	
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public Punto getCentro() {
		return this.centro;
	}
	
	/**
	 * @brief Indica si se intersectan los circulos o no. El calculo se realiza de
	 *        la siguiente manera, primero se obtiene la distancia entre los centros
	 *        de los circulos que se calcula como: sqrt((x1 - x2)^2 + (y1 - y2)^2),
	 *        luego, si esa distancia es menor o igual a la suma de los radios y
	 *        ademas es mayor a la resta de los mismos, puedo decir que las
	 *        circunferencias se intersectan.
	 * 
	 * @param c2: Es el circulo con el cual quiero verificar si se intersecta o no.
	 * 
	 * @return true si hay interseccion, false si no la hay.
	 **/
	public boolean intersectaCon(Circulo c2) {
		double distancia = this.centro.DistanciaAlPunto(c2.getCentro());
		
		return distancia <= this.radio + c2.getRadio() && distancia >= Math.abs(this.radio - c2.getRadio());
	}
}
