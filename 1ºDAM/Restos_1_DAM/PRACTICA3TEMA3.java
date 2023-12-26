import java.util.Scanner; //importación de la clase "scanner" para pòder introducir datos en la consola (comunicación con el ordenador)

//al seleccionar cuadrado solo tenía que pedirte un lado porque todos son iguales, no?
//al terminar con el área te pregunta automáticamente por el perimetro, y eso no tenía que pasar

public class PRACTICA3TEMA3{
  public static void main (String[] args) {
    Scanner entrada = new Scanner(System.in); //se introduce la clase "scanner" con el nombre "entrada"
    //declaración de variables del programa
    int opciones = 0;
    int eleccion = 0;
    double ladoc = 0;
    double ladoc1 = 0;
    double base = 0;
    double altura = 0;
    double radio = 0;
    double num1 = 0;
    double num2 = 0;
    double num3 = 0;
    double num4 = 0;
    double num5 = 0;
    String respuesta = "si";
    String insertado;
    
	do{ //para poder seguir o salir del menú principal, se utiliza un "do while", englobando el programa en el "do", introduciendo en el "while" la condición que permite seguir en el menú principal o salir de él
		System.out.println("Elige una de las siguientes opciones"); //menú principal
		System.out.println("1)Figuras geométricas");
		System.out.println("2)Operaciones matemáticas");
    
		opciones= entrada.nextInt(); //elección de la opción
    
			if(opciones == 1){
				System.out.println("Figuras Geométricas");
				System.out.println("Elige una de estas 3 opciones"); //submenú en caso de elegir la opción 1
				System.out.println("1-Cuadrado");
				System.out.println("2-Triángulo");
				System.out.println("3-Círculo");
			
				eleccion= entrada.nextInt();
			                                 // a través de operaciones distintas, se logra conseguir lo que pide el ejercicio, siendo la mecánica similar en los "if" y "else if"
				if(eleccion == 1){
					System.out.println("Cálculo del área del CUADRADO");
					System.out.println("¿Lado?");
					
					ladoc = entrada.nextDouble();
					
					double areacuadr= Math.pow(ladoc,2);
					
					System.out.println("EL resultado del área del CUADRADO es "+areacuadr);
					System.out.println("Cálculo del perímetro del CUADRADO");
					System.out.println("¿Lado?");
					
					ladoc1 = entrada.nextDouble();
					
					double perimc= ladoc1*4;
					
					System.out.println("El resultado del perímetro del CUADRADO es "+perimc);
				}
				else if(eleccion == 2){
					System.out.println("Cálculo del área del TRIANGULO");
					System.out.println("¿Base?");
					
					base = entrada.nextDouble();
					
					System.out.println("¿Altura?");
					
					altura = entrada.nextDouble();
					
					double areat= (base*altura)/2;
					
					System.out.println("EL resultado del área del TRIANGULO es "+areat);
					System.out.println("Cálculo del perímetro del TRIANGULO");
					
					double perimt= base*3;
					
					System.out.println("El resultado del perímetro del TRIANGULO es "+perimt);
				}
				else if(eleccion == 3){
					System.out.println("Cálculo del área del CIRCULO");
					System.out.println("¿Radio?");
					
					radio = entrada.nextDouble();
					
					double areacirc= Math.PI*Math.pow(radio,2);
					
					System.out.println("EL resultado del área del CIRCULO es "+areacirc);
					System.out.println("Cálculo del perímetro del CIRCULO");
					
					double perimcirc= 2*Math.PI*radio;
					
					System.out.println("El resultado del perímetro es "+perimcirc);
				}
			}
        
			if(opciones == 2){
				System.out.println("Operaciones matemáticas"); //al igual que en la opción anterior, pero con un contenido diferente, pero con la mecánica igual
				System.out.println("Elige una de estas 2 opciones");
				System.out.println("1-Mayor o menor");
				System.out.println("2-Elevar un número");
				
				eleccion= entrada.nextInt();
				
				if(eleccion == 1){
				System.out.println("Introduce 3 números por pantalla");
				
				num1 = entrada.nextDouble();
				num2 = entrada.nextDouble();
				num3 = entrada.nextDouble();
				
					if(num1>num2 && num1>num3 && num2>num3){
						System.out.println(num1+" > "+num2+" > "+num3);
					}else if(num1>num3 && num1>num2 && num3>num2){
						System.out.println(num1+" > "+num3+" > "+num2);
					}else if(num2>num1 && num2>num3 && num1>num3){
						System.out.println(num2+" > "+num1+" > "+num3);
					}else if(num2>num3 && num2>num1 && num3>num1){
						System.out.println(num2+" > "+num3+" > "+num1);
					}else if(num3>num1 && num3>num2 && num1>num2){
						System.out.println(num3+" > "+num1+" > "+num2);
					}else if(num3>num2 && num3>num1 && num2>num1){
						System.out.println(num3+" > "+num2+" > "+num1);
					}
				}
				else if(eleccion == 2){
					System.out.println("Introduce un número");
				
					num4 = entrada.nextDouble();
				
					System.out.println("Introduce el número a elevar");
				
					num5 = entrada.nextDouble();
				
					double elevar = Math.pow(num4,num5);
				
					System.out.println("El resultado es "+elevar);
				}
			}
		
				System.out.println("¿Desea volver al menú principal?"); //submenú para volver o no al menú principal
				System.out.println("1) si");
				System.out.println("2) no");
				
				insertado = entrada.next();
				
	}while(respuesta.equals(insertado));
  }
}
