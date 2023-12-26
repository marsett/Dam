public class DAM1_T3_P3_MARIO_JIMENEZ{
  public static void main (String[] args) {
  //declaración de variables FIJAS (posteriormente, se imprimirán en la frase aleatoria).

  //si no van a trabajar de manera separada
  //no tiene sentido dividirlo en 4 variables
  
	String nexo = "Si";
	String verbo1 = " escucha";
	String musica = " trap";
	String prep = " de";
	
  //declaración de variables ALEATORIAS (son las variables que irán cambiando según quiera el programa).
  //al querer 4 elementos aleatorios, la fórmula de "Math.random" será con un número máximo de 4 y un número mínimo de 1, ya que el rango requerido para la aleatoriedad es entre 1 y 4.
  
    String artistas="";
	  int artistasrandom = (int)(Math.random()*(4-1+1)+1);
	    switch(artistasrandom){
		  case 1 -> artistas = " Bryant Myers";
		  case 2 -> artistas = " Rvfv";
		  case 3 -> artistas = " Anuel AA";
		  case 4 -> artistas = " Ysy A";
	  }
  
    String verbo2 = "";
	  int verbo2random = (int)(Math.random()*(4-1+1)+1);
	    switch(verbo2random){
		  case 1 -> verbo2 = " se pondra";
		  case 2 -> verbo2 = " se mostrara";
		  case 3 -> verbo2 = " estara";
		  case 4 -> verbo2 = " se encontrara";
	  }
	  
    String modificador = "";
	  int modificadorrandom = (int)(Math.random()*(4-1+1)+1);
	    switch(modificadorrandom){
		  case 1 -> modificador = " tan";
		  case 2 -> modificador = " muy";
		  case 3 -> modificador = " poco";
		  case 4 -> modificador = " extremadamente";
	  }
  
    String adjetivos="";
	  int adjetivosrandom = (int)(Math.random()*(4-1+1)+1);
	    switch(adjetivosrandom){
		  case 1 -> adjetivos = " loco";
		  case 2 -> adjetivos = " contento";
		  case 3 -> adjetivos = " triste";
		  case 4 -> adjetivos = " melancolico";
	  }
 
   //en esta parte del código, se imprime de manera estructurada la frase requerida, con sus variables fijas y aleatorias. 
 
   System.out.println(nexo + verbo1  + musica +  prep + artistas + verbo2 +  modificador + adjetivos);
         
   //autores (nombres y apellidos --> 2 elementos aleatorios - con 4 opciones cada elemento)
   //se repite la fórmula de "Math.random", igual que la introducida en el código anterior
	  
    String nombres = "";
    int nombresrandom = (int)(Math.random()*(4-1+1)+1);
    switch(nombresrandom){
      case 1:
        nombres = "Antonio";
      break;
      case 2:
        nombres = "Rafa";
      break;
      case 3:
        nombres = "Omar";
      break;
      case 4:
        nombres = "Nahuel";
      break;
    }
      
    String apellidos = "";
    int apellidosrandom = (int)(Math.random()*(4-1+1)+1);
    switch(apellidosrandom){
      case 1:
		apellidos = "Ruiz";
      break;
      case 2:
        apellidos = "Vargas";
      break; 
      case 3:
        apellidos = "Costa";
      break;
      case 4:
        apellidos = "Montes";
      break;
    }
    
  //finalmente, se imprimen nombres y apellidos (totalmente aleatorios)
    System.out.println(nombres+" "+apellidos);
     
  }
}
