
public class T3P2 {
	public static void main(String[] args) {
		//declaraci�n e inicializaci�n de varaibles
		char numero = '\0';
		String verboA = "";
		String verboB = "";
		String preposicionA = "";
		String preposicionB = "";
		String sustantivoA = "";
		String sustantivoB = "";
		String nombre = "";
		String apellido = "";
		int numRand;
		int verboArand;
		int verboBrand;
		int sustArand;
		int sustBrand;
		int nombRand;
		int apeRand;
		//variables incicializadas con valores random
		numRand = (int) (Math.random() * (2 + 1 - 1) + 1);
		verboArand = (int) (Math.random() * (4 + 1 - 1) + 1);
		verboBrand = (int) (Math.random() * (4 + 1 - 1) + 1);
		sustArand = (int) (Math.random() * (4 + 1 - 1) + 1);
		sustBrand = (int) (Math.random() * (4 + 1 - 1) + 1);
		nombRand = (int) (Math.random() * (4 + 1 - 1) + 1);
		apeRand = (int) (Math.random() * (4 + 1 - 1) + 1);
		//switches 
		switch (nombRand) {
		case 1:
			nombre = "Yen";
			break;
		case 2:
			nombre = "Chuan";
			break;
		case 3:
			nombre = "Ip";
			break;
		case 4:
			nombre = "Mulan";
			break;
		}
		switch (apeRand) {
		case 1:
			apellido = "Fu";
			break;
		case 2:
			apellido = "Chi";
			break;
		case 3:
			apellido = "Lee";
			break;
		case 4:
			apellido = "Wang";
			break;
		}
		switch (verboArand) {
		case 1:
			verboA = "come";
			break;
		case 2:
			verboA = "habla";
			preposicionA = " de";
			break;
		case 3:
			verboA = "piensa";
			preposicionA = " en";
			break;
		case 4:
			verboA = "regala";
			break;
		}
		switch (numRand) {
		case 1:
			numero = 'n';
			break;
		case 2:
			numero = 's';
			break;
		}
		switch (sustArand) {
		case 1:
			sustantivoA = "chocolate";
			break;
		case 2:
			sustantivoA = "quimeras";
			break;
		case 3:
			sustantivoA = "monstruos";
			break;
		case 4:
			sustantivoA = "f�tbol";
			break;
		}
		switch (verboBrand) {
		case 1:
			verboB = "escribir�";
			preposicionB = " sobre";
			break;
		case 2:
			verboB = "criar�";
			break;
		case 3:
			verboB = "so�ar�";
			preposicionB = " con";
			break;
		case 4:
			verboB = "fabricar�";
			break;
		}
		switch (sustBrand) {
		case 1:
			sustantivoB = "ignorantes";
			break;
		case 2:
			sustantivoB = "Pok�mons";
			break;
		case 3:
			sustantivoB = "ex�menes";
			break;
		case 4:
			sustantivoB = "tonter�as";
			break;
		}
		//concatenaci�n
		System.out.println("S� " + verboA + numero + preposicionA + " " + sustantivoA + " " + verboB + numero
				+ preposicionB + " " + sustantivoB + ". " + nombre + " " + apellido + ".");
	}
}
