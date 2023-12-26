/*
 * 
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 * 
 */

import java.util.*;
import javax.swing.*;

public class T3P1_ej07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;
        String seleccion;
        int menuSel;
        do {
            System.out.println("Selecciona una de las siguientes opciones:");
            System.out.println("1 Calculo Hora\n2 Calculo Mes\n3 Par o Impar\n4 Salir");
            menuSel = sc.nextInt();

            switch (menuSel) {
            case 1:
                // 01
                System.out.println("Introduce una hora");
                int hora = sc.nextInt();

                if ((0 <= hora) && (hora <= 12)) {
                    System.out.println("Buenos días");
                } else if ((12 < hora) && (hora <= 21)) {
                    System.out.println("Buenas tardes");
                } else if ((21 < hora) && (hora <= 24)) {
                    System.out.println("Buenas noches");
                } else {
                    System.out.println("Hora inválida");
                }
                break;
            //
            // 02
            case 2:

                System.out.println("Introduce el número del mes: ");
                num = sc.nextInt();

                switch (num) {
                case 1:
                    seleccion = "Enero";
                    break;
                case 2:
                    seleccion = "Febrero";
                    break;
                case 3:
                    seleccion = "Marzo";
                    break;
                case 4:
                    seleccion = "Abril";
                    break;
                case 5:
                    seleccion = "Mayo";
                    break;
                case 6:
                    seleccion = "Junio";
                    break;
                case 7:
                    seleccion = "Julio";
                    break;
                case 8:
                    seleccion = "Agosto";
                    break;
                case 9:
                    seleccion = "Septiembre";
                    break;
                case 10:
                    seleccion = "Octubre";
                    break;
                case 11:
                    seleccion = "Noviembre";
                    break;
                case 12:
                    seleccion = "Diciembre";
                    break;
                default:
                    seleccion = "un mes inválido";
                }
                System.out.println("Has seleccionado " + seleccion);
                break;
            //
            // 03
            case 3:
                System.out.println("Introduce un número: ");
                num = sc.nextInt();

                if ((num % 2) == 0) {
                    System.out.println("El número " + num + " es par.");
                } else {
                    System.out.println("El número " + num + " es impar.");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("selección no válida");
            }
        } while (menuSel != 4);
    }
}
