/*
 * 
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 * 
 */

import java.util.*;
import javax.swing.*;
public class T3P3 {

    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in); //instanciación de Scanner
        int menuGen;
        int menuFig;
        int menuCalculo;
        int menuOpera;

        double circRad;
        double circPer;
        double circArea;

        double triBase;
        double triAltura;
        double triHipo;
        double triArea;
        double triPer;

        double cuadLado;
        double cuadPer;
        double cuadArea;

        String figura = "";
        String figPeriArea = "";
        double figResultado = 0.0;

        int n1;
        int n2;
        int n3;
        int nBase;
        int nExpo;
        int nPow;

        String menuVolverPass = "";
        boolean menuVolver = true;
        boolean menuSalir = false;
        //bucle do while
        do {
            //introducción de datos
            System.out.println("Selecciona una de las siguientes opciones:");
            System.out.println("1| Figuras geom�tricas\t2| Operaciones matem�ticas");
            menuGen = sc.nextInt();
            //switch menu general
            switch (menuGen) {
            case 1:
                System.out.println("Selecciona una de las siguientes opciones:");
                System.out.println("1| Cuadrado\t2| Tri�ngulo\t2| C�rculo");
                menuFig = sc.nextInt();

                System.out.println("Selecciona una de las siguientes opciones:");
                System.out.println("1| C�lculo de �rea\t2| C�lculo de per�metro");
                menuCalculo = sc.nextInt();
                //switch menu figura
                switch (menuFig) {
                case 1:
                    System.out.println("Introduce el lado:");
                    cuadLado = sc.nextInt();
                    if (menuCalculo == 1) {
                        figPeriArea = "�rea";
                        cuadArea = Math.pow(cuadLado, 2);
                        figResultado = cuadArea;
                    } else if (menuCalculo == 2) {
                        figPeriArea = "per�metro";
                        cuadPer = cuadLado * 4;
                        figResultado = cuadPer;
                    }
                    break;
                case 2:
                    System.out.println("Introduce la base:");
                    triBase = sc.nextInt();
                    System.out.println("Introduce la altura:");
                    triAltura = sc.nextInt();
                    if (menuCalculo == 1) {
                        figPeriArea = "�rea";
                        triArea = triBase * triAltura / 2;
                        figResultado = triArea;
                    } else if (menuCalculo == 2) {
                        figPeriArea = "per�metro";
                        triHipo = Math.sqrt(Math.pow(triBase / 2, 2) + Math.pow(triAltura, 2));
                        triPer = triBase + (2 * triHipo);
                        figResultado = triPer;
                    }
                    break;
                case 3:
                    figura = "c�rculo";
                    System.out.println("Introduce un r�dio v�lido:");
                    circRad = sc.nextInt();
                    if (menuCalculo == 1) {
                        figPeriArea = "�rea";
                        circArea = Math.PI * Math.pow(circRad, 2);
                        figResultado = circArea;
                    } else if (menuCalculo == 2) {
                        figPeriArea = "per�metro";
                        circPer = 2 * Math.PI * circRad;
                        figResultado = circPer;
                    }
                    break;
                default:
                    System.out.println("La opci�n seleccionada no es v�lida");
                    break;
                }
                //salida
                System.out.println("El " + figPeriArea + " del " + figura + " es " + figResultado);
                break;                
            case 2:
                System.out.println("Selecciona una de las siguientes opciones:");
                System.out.println("1| Mayor o menor\t2| Elevar un n�mero");
                menuOpera = sc.nextInt();
                //switch menu operación matemática
                switch (menuOpera) {
                case 1:
                    System.out.println("Introduce los 3 n�meros a ordenar separados por un espacio");
                    n1 = sc.nextInt();
                    n2 = sc.nextInt();
                    n3 = sc.nextInt();
                    System.out.println("El orden correcto es:");
                    //condiciones
                    if (n1 < n2 && n2 < n3 && n1 < n3) {
                        System.out.println(n1 + " " + n2 + " " + n3);
                    }
                    if (n1 < n3 && n3 < n2 && n1 < n2) {
                        System.out.println(n1 + " " + n3 + " " + n2);
                    }
                    if (n2 < n1 && n1 < n3 && n2 < n3) {
                        System.out.println(n2 + " " + n1 + " " + n3);
                    }
                    if (n2 < n1 && n3 < n1 && n2 < n3) {
                        System.out.println(n2 + " " + n3 + " " + n1);
                    }
                    if (n3 < n1 && n1 < n2 && n3 < n2) {
                        System.out.println(n3 + " " + n1 + " " + n2);
                    }
                    if (n3 < n2 && n2 < n1 && n3 < n1) {
                        System.out.println(n3 + " " + n2 + " " + n1);
                    }
                    //una alternativa
                    /*
                    if (n1 > n2) {
                        if (n2 > n3) {
                            System.out.println(n3 + " " + n2 + " " + n1);
                        } else if (n1 > n3) {
                            System.out.println(n2 + " " + n3 + " " + n1);
                        } else {
                            System.out.println(n2 + " " + n1 + " " + n3);
                        }
                    } else {
                        if (n1 > n3) {
                            System.out.println(n3 + " " + n1 + " " + n2);
                        } else if (n2 > n3) {
                            System.out.println(n1 + " " + n3 + " " + n2);
                        } else {
                            System.out.println(n1 + " " + n2 + " " + n3);
                        }
                    } 
                    */
                    break;
                case 2:
                    System.out.println("Introduce el numero base y exponente separados por un espacio");
                    nBase = sc.nextInt();
                    nExpo = sc.nextInt();
                    nPow = (int) Math.pow(nBase, nExpo);
                    System.out.println("El resultado de elevar " + nBase + " a " + nExpo + " es " + nPow);
                    break;
                default:
                    System.out.println("La opci�n seleccionada no es v�lida");
                    break;
                }
                break;
            default:
                System.out.println("La opci�n seleccionada no es v�lida");
                break;
            }
            //consulta para volver al menú principal
            //nótese que no permite salir del bucle sin una opción válida
            do {
                System.out.println("�Quiere volver al men� principal?");
                System.out.println("Y\t|\tN");
                menuVolverPass = sc.next();
                if (menuVolverPass.equalsIgnoreCase("N")) {
                    System.out.println("Gracias por tu visita");
                    menuVolver = false;
                    menuSalir = false;
                } else if (menuVolverPass.equalsIgnoreCase("Y")) {
                    System.out.println("As� sea");
                    menuVolver = true;
                    menuSalir = false;
                } else {
                    System.out.println("La opci�n seleccionada no es v�lida");
                    menuSalir = true;
                }
            } while (menuSalir);
        } while (menuVolver);        
        sc.close();
    }
}