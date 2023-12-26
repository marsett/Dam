import java.util.Scanner; //importación de la clase Scanner

public class T3P4_MARIO_JIMENEZ{
  public static void main (String[] args) {
	  
	  Scanner intro = new Scanner(System.in); //declaración de la clase Scanner con el nombre "intro"
    
    //declaración de las variables utilizadas en el ejercicio
    
    int perjuicio;  
    
    //variable común al personaje atacante y al personaje defensor
    
    int turno = 1;  //variable que se va sumando según las rondas van pasando (la suma está declarada a posterori)
    String enemigo = "Juan Demonio";  
    
    //variables correspondientes al héroe
    
    int saludh;
    int fuerzah;
    int magiah;
    int pocionh;
    int suerteh;
    
    //variables correspondientes al enemigo
    
    int salude;
    int fuerzae;
    int magiae;
    int pocione;
    int suertee;
    
    //inicialización variables del héroe
    
    saludh = 500;
    fuerzah = 30;
    magiah = 10;
    pocionh = 3;
    suerteh = 50;
    
    //inicialización variables del enemigo
    
    salude = 500;
    fuerzae = 30; 
    magiae = 10;
    pocione = 3;
    suertee = 50;
    
    System.out.println("Introduce el nombre de tu héroe");
    
    String nombre = intro.nextLine();
    
    System.out.println("*****************************************");
    
    System.out.println("¡A luchar!");
    
    System.out.println("*****************************************");
    
    do{
      System.out.println("*****************************************");
      System.out.println("Ronda "+turno++); //número de ronda
      System.out.println("*****************************************");
      System.out.println(enemigo+" : Salud = "+salude+"N pociones = "+pocione); //salud y pociones del enemigo
      System.out.println("*****************************************");
      
      if(salude < 50 && pocione > 0){
        salude+=50;
        System.out.println("Ha utilizado la pocion"+salude);  //condición donde, si la salud del enemigo es mayor a 50 y el número de pociones es mayor a 0, la poción tomada suma 50 puntos de salud
      }
      else{ //se declaran las suertes de héroe y enemigo con valores aleatorios diferentes
        
        int accion1 = (int)(Math.random()*(2-1+1)+1);
        suerteh = suerteh + (int)(Math.random()*(100-0+1)+0);
        suertee = suertee + (int)(Math.random()*(100-50+1)+50);
        
        //se realiza un "switch" donde hay 2 opciones (ataque físico y ataque mágico) donde los daños contienen valores diferentes, condicionando las suertes, con el fin de ejecutar los ataques o que el héroe o enemigo los esquive
        
        switch(accion1){
          case 1:
            perjuicio = fuerzae +(int)(Math.random()*(50-25+1)+25);
              if(suertee > suerteh){
                saludh -= perjuicio;
                System.out.println("Ataque ejecutado. Nueva salud -> "+saludh);
              }else{
                System.out.println("Ataque esquivado por el héroe");
              }
          break;
          case 2:
            perjuicio = fuerzae +(int)(Math.random()*(100-0+1)+0);
            if(suertee > suerteh){
                saludh -= perjuicio;
                System.out.println("Ataque ejecutado. Nueva salud -> "+saludh);
              }else{
                System.out.println("Ataque esquivado por el heroe");
              }
          break;
        }
      }
        
        //se elige la acción a realizar manualmente
        
        System.out.println("¿Que accion quieres realizar?");
        System.out.println("1) Fisico");
        System.out.println("2) Magia");
        System.out.println("3) Pocion");
        
        int accion2 = intro.nextInt();
        
        //se declaran las suertes de héroe y enemigo con valores aleatorios diferentes
        
        suerteh = suerteh + (int)(Math.random()*(100-50+1)+50);
        suertee = suertee + (int)(Math.random()*(100-0+1)+0);
        
        //al igual que en el caso anterior (CPU) con las acciones del héroe se realiza prácticamente lo mismo
        
        switch(accion2){
          case 1:
            perjuicio = fuerzah +(int)(Math.random()*(50-25+1)+25);
              if(suerteh > suertee){
                salude -= perjuicio;
                System.out.println("Ataque ejecutado. Nueva salud -> "+salude);
              }else{
                System.out.println("Ataque esquivado por el cpu");
              }
          break;
          case 2:
            perjuicio = fuerzah +(int)(Math.random()*(100-0+1)+0);
            if(suerteh > suertee){
              salude -= perjuicio;
              System.out.println("Ataque ejecutado. Nueva salud -> "+salude);
            }else{
              System.out.println("Ataque esquivado por el heroe");
            }
          break;
          case 3:
            if(pocionh > 0){
              
            saludh += 50;
            
              System.out.println("Ha tomado una pocion. Nueva Salud: "+saludh);
            }else{
              System.out.println("No hay pociones");
            }
          break;
          default:
              System.out.println("Ha perdido el turno");
        }
        
        //al finalizar partida, se da la enhorabuena al rival
        
        if(saludh < 0){
          System.out.println(nombre+" da la victoria a su rival");
        }else if(salude < 0){
          System.out.println("El rival da la victoria a "+nombre);
        }
         
    }while(saludh > 0 && salude > 0); //el "do while" se ejecutará si se cumple la condición establecida en el "while"
  }
}
