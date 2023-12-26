import java.util.Scanner;

public class T3P4 {

    public static void main(String[] args) {
	// declaración e inicialización de varaibles
	int cpuFuerza = 30;
	int cpuFuerzaCompleta;
	int cpuMagia = 10;
	int cpuMagiaCompleta;
	int cpuEnergia = 500;
	int cpuAtaqRand;
	int cpuAtaque = 0;
	int cpuSuerte = 50;
	int cpuSuerteCompleta;
	String cpuAtaqTipo = "";
	int cpuPocionNum = 3;

	String jugNombre;
	int jugFuerza = 30;
	int jugFuerzaCompleta;
	int jugMagia = 10;
	int jugMagiaCompleta;
	int jugEnergia = 500;
	int jugAtaque = 0;
	int jugSuerte = 50;
	int jugSuerteCompleta;
	String jugAtaqTipo = "";
	int jugAtaqTipoNum;
	int jugPocionNum = 3;

	Scanner sc = new Scanner(System.in); // instanciación de Scanner
	int round = 1;
	int pocionEnergia = 50;
	boolean ataqueInutil=false;

	// inicio del juego
	System.out.println("Ingresa el nombre de nuestro héroe:");
	jugNombre = sc.nextLine();
	System.out.println("\n¡A luchar!\n");
	// bucle do while mientras no muera alguno de los personajes
	do {
	    // información por cada ROUND
	    System.out.println("*****************************************");
	    System.out.println("*ROUND " + round + "*********************************");
	    System.out.println(jugNombre + "\t\tEnemigo");
	    System.out.println("Salud " + jugEnergia + "\t\tSalud " + cpuEnergia);
	    System.out.println("Pociones " + jugPocionNum + "\t\tPociones " + cpuPocionNum + "\n");
	    System.out.println("*****************************************");
	    // enemigo
	    // condición para usar pociones
	    // si no las necesita, entonces ataca
	    if (cpuPocionNum > 0 && cpuEnergia < 50) {
		cpuEnergia += pocionEnergia;
		cpuPocionNum--;
		System.out.println("El enemigo ha recuperado " + pocionEnergia + " puntos de salud.\n");
	    } else {
		cpuAtaqRand = (int) Math.round(Math.random()); // ataque aleatorio
		switch (cpuAtaqRand) {
		case 0:
		    cpuFuerzaCompleta = cpuFuerza + ((int) (Math.random() * (50 - 25 + 1) + 25));// fuerza + un valor aleatorio
		    cpuAtaque = cpuFuerzaCompleta;
		    cpuAtaqTipo = "físico";
		    break;
		case 1:
		    cpuMagiaCompleta = cpuMagia + ((int) (Math.random() * (100 - 0 + 1) + 0)); // magia + un valor aleatorio
		    cpuAtaque = cpuMagiaCompleta;
		    cpuAtaqTipo = "mágico";
		    break;
		}
		System.out.println("El enemigo ha realizado un ataque " + cpuAtaqTipo + " de " + cpuAtaque + " puntos.");
		// suerte
		jugSuerteCompleta = jugSuerte + ((int) (Math.random() * (50 - 0 + 1) + 0));
		cpuSuerteCompleta = cpuSuerte + ((int) (Math.random() * (100 - 0 + 1) + 0));
		if (jugSuerteCompleta < cpuSuerteCompleta) {
		    jugEnergia = jugEnergia - cpuAtaque;
		    System.out.println("La salud de " + jugNombre + " es de " + jugEnergia + " puntos.\n");
		    // puesto que el jugador es el último del turno, se le da la posibilidad de una última acción
		    if (jugEnergia < 0) {
			System.out.println(jugNombre + " está agonizando, pero ¡aún puede lanzar un último ataque!\n");
		    }
		} else {
		    System.out.println("Por suerte " + jugNombre + " ha esquivado el ataque.\n");
		}
	    }
	    // jugador
	    System.out.println("*****************************************");
	    System.out.println("¿Qué acción quieres realizar?\n1|Físico \t2|Mágia \t3|Poción");
	    jugAtaqTipoNum = sc.nextInt();
	    // case 3 en el switch está vacia, pero permite tener una salida combinada en el if con independencia al tipo de ataque
	    switch (jugAtaqTipoNum) {
	    case 1:
		jugFuerzaCompleta = jugFuerza + ((int) (Math.random() * (50 - 25 + 1) + 25));// fuerza + un valor aleatorio
		jugAtaque = jugFuerzaCompleta;
		jugAtaqTipo = "físico";
		break;
	    case 2:
		jugMagiaCompleta = jugMagia + ((int) (Math.random() * (100 - 0 + 1) + 0)); // magia + un valor aleatorio
		jugAtaque = jugMagiaCompleta;
		jugAtaqTipo = "mágico";
		break;
	    case 3:
		break;
	    default:
		ataqueInutil = true;
		jugAtaque = 0;
		jugAtaqTipo = "inútil";
		break;
	    }
	    if (jugAtaqTipoNum != 3) {
		System.out.println(jugNombre + " ha realizado un ataque " + jugAtaqTipo + " de " + jugAtaque + " puntos.");
		if (ataqueInutil==false) {		   
		    // suerte
		    cpuSuerteCompleta = cpuSuerte + ((int) (Math.random() * (50 - 0 + 1) + 0));
		    jugSuerteCompleta = jugSuerte + ((int) (Math.random() * (100 - 0 + 1) + 0));
		    if (cpuSuerteCompleta < jugSuerteCompleta) {
			cpuEnergia = cpuEnergia - jugAtaque;
			System.out.println("La salud del enemigo es de " + cpuEnergia + " puntos.\n");
		    } else {
			System.out.println("El enemigo ha esquivado el ataque.\n");
		    }
		}
	    } else {
		// pociones
		if (jugPocionNum > 0) {
		    jugEnergia += pocionEnergia;
		    System.out.println(jugNombre + " se ha tomado una poción que le ha recuperado " + pocionEnergia + " puntos de salud.");
		    jugPocionNum--;
		} else {
		    System.out.println("No le quedan pociones a " + jugNombre);
		}
	    }
	    round++; // contador de round
	    ataqueInutil=false; //reseteamos el valor de ataqueInutil
	} while (cpuEnergia > 0 && jugEnergia > 0); // condición del bucle
	// finalización del juego
	System.out.println("*****************************************");
	if (cpuEnergia <= 0 && jugEnergia <= 0) {
	    System.out.println("No sé cómo ha podido pasar pero han terminado palmando los dos ( ｡ŏ﹏ŏ)");
	} else if (cpuEnergia <= 0) {
	    System.out.println(jugNombre + " ha destrozado a su enemigo. ( >‿◠ )");
	} else {
	    System.out.println("El cadáver de " + jugNombre + " será deborado por gusanos. ( ˘︹˘ )");
	}
	System.out.println("\n*****************************************");
	System.out.println("*GAME OVER*******************************");
	System.out.println("*****************************************");
	sc.close();
    }
}