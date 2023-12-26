/* 
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 */

import java.util.Scanner;

public class T3P1_ej03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Introduce un número: ");
        num = sc.nextInt();

        if ((num % 2) == 0) {
            System.out.println("El número " + num + " es par.");
        } else {
            System.out.println("El número " + num + " es impar.");
        }
    }
}