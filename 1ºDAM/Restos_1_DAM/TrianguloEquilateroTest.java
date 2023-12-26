import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrianguloEquilateroTest {

	private TrianguloEquilatero tprueba;
	private double lado, altura;
	
	//Se ejecuta al principio de la prueba
	@BeforeAll //BeforeClass en Junit4 sin ser static
	static void testBeforeAll() {
		System.out.println("Empieza el Junit");
	}
	
	//Se ejecuta al final de la prueba
	@AfterAll  //AfterClass en Junit4 sin ser static
	static void testAfterAll() {
		System.out.println("Acaba el Junit");
	}
	
	//Se ejecuta antes de cada @Test
	@BeforeEach  //Before en Junit4
	void testBefore() {
		System.out.println("Empieza un Test");
		lado = 3.0;
		altura = 5.0;
		tprueba = new TrianguloEquilatero(lado,altura);
	}
	
	//Se ejecuta después de cada @Test
	@AfterEach  //After en Junit4
	void testAfter() {
		System.out.println("Acaba un Test");
	}

	//Test para probar el constructor
	@Test
	void testTrianguloEquilatero() {
		System.out.println("Test Constructor");
		assertEquals(altura,tprueba.getAltura());
		assertEquals(lado,tprueba.getLado());
	}
	
	//Test para probar CalculaArea con valores correctos
	@Test
	void testCalculaArea() {
		System.out.println("Test Area");
		//TrianguloEquilatero tprueba = new TrianguloEquilatero(3,5);
		double resultadoArea = tprueba.calculaArea();
		double esperado = 7.5; //(3*5)2
		assertEquals(esperado,resultadoArea);
	}
	
	//Test para probar CalculaArea con fallo por excepción
	@Test //(expected = ArithmeticException.class) en Junit4
	void testCalculaAreaError() {
		System.out.println("Test Area Error");
		//TrianguloEquilatero tprueba = new TrianguloEquilatero(3,0);
		tprueba.setAltura(0);
		assertThrows(ArithmeticException.class, () -> {
			tprueba.calculaArea();
		    });
	}

	//Test para probar CalculaPerimetro con valores correctos
	@Test
	void testCalculaPerimetro() {
		System.out.println("Test Perimetro");
		//TrianguloEquilatero tprueba = new TrianguloEquilatero(3,5);
		double resultadoPerimetro = tprueba.calculaPerimetro();
		double esperado = 9; //3*3
		assertEquals(esperado,resultadoPerimetro);
	}

}
