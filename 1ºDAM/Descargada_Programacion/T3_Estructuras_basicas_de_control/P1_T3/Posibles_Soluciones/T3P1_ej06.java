/*
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 */

import javax.swing.*;

public class T3P1_ej06 {
    public static void main(String[] args) {
        int numero1;
        int numero2;
        int resta;
        numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
        do {
            numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca otro numero"));
            resta = numero1 - numero2;
            numero1 = resta;
        } while (resta >= 0);
        System.out.println("El numero es negativo");
    }
}