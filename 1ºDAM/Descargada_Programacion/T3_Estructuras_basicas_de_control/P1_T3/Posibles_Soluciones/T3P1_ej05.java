/*
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 */

import java.util.Scanner;

public class T3P1_ej05 {
    public static void main(String[] args) {
        double g=0.0;
        for (int i = 0; i <= 100; i+= 10) {
            System.out.println(i + " grados celsius\t" + ((g * 9 / 5) + 32) + " grados fahrenheit");
            System.out.println(i + " grados fahrenheit\t" + ((g - 32) * 5 / 9) + " grados celsius");
            System.out.println();
            g+=10;
        }

    }
}