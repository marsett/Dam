/*
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 */

import java.util.Scanner;

public class T3P1_ej04 {
    public static void main(String[] args) {

        int limite = 50;
        int x;

        System.out.println("Bucle for");
        for (x = 0; x <= limite; x += 2) {
            System.out.println(x);
        }

        System.out.println();
        System.out.println("Bucle while");
        x = 0;
        while (x <= limite) {
            System.out.println(x);
            x += 2;
        }

        System.out.println();
        System.out.println("Bucle do while");
        x = 0;
        do {
            System.out.println(x);
            x += 2;
        } while (x <= limite);

    }
}