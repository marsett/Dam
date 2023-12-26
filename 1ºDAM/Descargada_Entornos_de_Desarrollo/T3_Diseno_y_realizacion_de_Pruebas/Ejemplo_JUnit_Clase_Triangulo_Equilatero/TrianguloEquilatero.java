
public class TrianguloEquilatero {
	private double lado;
	private double altura;
	
	TrianguloEquilatero (double lado, double altura){
		this.lado = lado;
		this.altura = altura;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	double calculaArea() {
		double area = 0;
		if (altura==0){
			throw new ArithmeticException("No es posible que la altura sea cero");
		} else {
			//supongamos que esta f�rmula fuese la correcta del c�lculo de �rea
			//la hemos modificado para probar el salto de la excepci�n
			area = (lado * 2)/altura;
		}
		return area;
	}
	
	double calculaPerimetro() {
		double perimetro = lado*3;
		return perimetro;
	}

}
