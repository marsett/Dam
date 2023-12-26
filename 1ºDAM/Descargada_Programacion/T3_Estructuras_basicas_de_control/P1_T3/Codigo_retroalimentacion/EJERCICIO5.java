public class EJERCICIO5{
	public static void main (String[] args) {
		double c;														//declaración de variable (celsius)
		for(int f= 10; f<=100; f+=10){									/*se utiliza un "for", cuya condición introducida declara la variable f
																		(fahrenheit) siendo igual a 10 (al ser este el comienzo del rango de valores). 
																		Se dice que f<=100 (ya que se piden los valores hasta 100) y se hace f+=10, 
																		ya que deben ser valores mostrados de 10 en 10. Posteriormente, se introduce 
																		la fórmula del cambio entre grados fahrenheit y celsius; finalmente, se imprime
																		por pantalla la tabla*/
			c = (5.0/9.0)*(f-32);
			System.out.println(f+" º fahrenheit = "+c+"º celsius");
		}
	}
}
