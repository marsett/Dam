import java.util.Scanner;

public class PrincipalTriangulo {
	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		double base=0.0, altura=0.0, lado1=0.0, lado2=0.0, resultado=0.0;
		
		System.out.println("Dame el primer lado");
		lado1=entrada.nextDouble();
		
		System.out.println("Dame el segundo lado");
		lado2=entrada.nextDouble();
		
		System.out.println("Dame la altura");
		altura=entrada.nextDouble();
		
		System.out.println("Dame la base");
		base=entrada.nextDouble();

		//Creamos un objeto de Triangulo
		Triangulo t1 = new Triangulo(base, lado1, lado2, altura);
		
		//area sin que devuelva nada
		t1.area();
		
		//perimetro que devuelve el valor
		resultado = t1.perimetro();
		System.out.println(resultado);

	}
}
