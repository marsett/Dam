package clasesinternas;

public class ClasesInternasEstaticas {
	public static void main(String[] args) {
		ClaseContenedora obj=new ClaseContenedora();
		ClaseContenedora.ClaseAnidada objInt;
		objInt=new ClaseContenedora.ClaseAnidada();
		
		ClaseContenedora.ClaseAnidada.SubClase x;
		x=objInt.new SubClase();
		
		ClaseContenedora.ClaseAnidada.SubClaseAnidada objInt2;
		objInt2=new ClaseContenedora.ClaseAnidada.SubClaseAnidada();
		
	}
}
