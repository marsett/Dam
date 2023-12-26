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
        Scanner sc = new Scanner(System.in); //instanciaciÃ³n de Scanner
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
            //introducciÃ³n de datos
            System.out.println("Selecciona una de las siguientes opciones:");
            System.out.println("1| Figuras geométricas\t2| Operaciones matemáticas");
            menuGen = sc.nextInt();
            //switch menu general
            switch (menuGen) {
            case 1:
                System.out.println("Selecciona una de las siguientes opciones:");
                System.out.println("1| Cuadrado\t2| Triángulo\t2| Cí­rculo");
                menuFig = sc.nextInt();

                System.out.println("Selecciona una de las siguientes opciones:");
                System.out.println("1| Cálculo de área\t2| Cálculo de perí­metro");
                menuCalculo = sc.nextInt();
                //switch menu figura
                switch (menuFig) {
                case 1:
                    System.out.println("Introduce el lado:");
                    cuadLado = sc.nextInt();
                    if (menuCalculo == 1) {
                        figPeriArea = "área";
                        cuadArea = Math.pow(cuadLado, 2);
                        figResultado = cuadArea;
                    } else if (menuCalculo == 2) {
                        figPeriArea = "perí­metro";
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
                        figPeriArea = "área";
                        triArea = triBase * triAltura / 2;
                        figResultado = triArea;
                    } else if (menuCalculo == 2) {
                        figPeriArea = "perí­metro";
                        triHipo = Math.sqrt(Math.pow(triBase / 2, 2) + Math.pow(triAltura, 2));
                        triPer = triBase + (2 * triHipo);
                        figResultado = triPer;
                    }
                    break;
                case 3:
                    figura = "cí­rculo";
                    System.out.println("Introduce un rádio válido:");
                    circRad = sc.nextInt();
                    if (menuCalculo == 1) {
                        figPeriArea = "área";
                        circArea = Math.PI * Math.pow(circRad, 2);
                        figResultado = circArea;
                    } else if (menuCalculo == 2) {
                        figPeriArea = "perí­metro";
                        circPer = 2 * Math.PI * circRad;
                        figResultado = circPer;
                    }
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida");
                    break;
                }
                //salida
                System.out.println("El " + figPeriArea + " del " + figura + " es " + figResultado);
                break;                
            case 2:
                System.out.println("Selecciona una de las siguientes opciones:");
                System.out.println("1| Mayor o menor\t2| Elevar un número");
                menuOpera = sc.nextInt();
                //switch menu operaciÃ³n matemÃ¡tica
                switch (menuOpera) {
                case 1:
                    System.out.println("Introduce los 3 números a ordenar separados por un espacio");
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
                    System.out.println("La opción seleccionada no es válida");
                    break;
                }
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
                break;
            }
            //consulta para volver al menÃº principal
            //nÃ³tese que no permite salir del bucle sin una opciÃ³n vÃ¡lida
            do {
                System.out.println("¿Quiere volver al menú principal?");
                System.out.println("Y\t|\tN");
                menuVolverPass = sc.next();
                if (menuVolverPass.equalsIgnoreCase("N")) {
                    System.out.println("Gracias por tu visita");
                    menuVolver = false;
                    menuSalir = false;
                } else if (menuVolverPass.equalsIgnoreCase("Y")) {
                    System.out.println("Así­ sea");
                    menuVolver = true;
                    menuSalir = false;
                } else {
                    System.out.println("La opción seleccionada no es válida");
                    menuSalir = true;
                }
            } while (menuSalir);
        } while (menuVolver);        
        sc.close();
    }
}