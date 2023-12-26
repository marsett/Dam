
// clase Triangulo
public class Triangulo {
	// Miembros o Atributos
	double base=0.0;
	double lado1=0.0;
	double lado2=0.0;
	double altura=0.0;
	
   //Constructor con par�metros de entrada
    Triangulo (double Base, double Lado1, double Lado2, double Altura){
        base=Base;
        lado1=Lado1;
        lado2=Lado2;
        altura=Altura;
    }

	// m�todo para calcular el �rea
	//No recibe par�metros ni devuelve datos
	public void area() {
		double area = (base*altura)/2;
		System.out.println(area);
	}
	
	// m�todo para calcular el per�metro
	//No recibe par�metros pero devuelve un dato Double
	public double perimetro() {
		double perimetro = base+lado1+lado2;
		return perimetro;
	}

}
