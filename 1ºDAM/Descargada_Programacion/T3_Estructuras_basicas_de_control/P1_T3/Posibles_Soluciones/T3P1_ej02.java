/*
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 */

import java.util.Scanner;

public class T3P1_ej02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        String seleccion;

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
    }
}