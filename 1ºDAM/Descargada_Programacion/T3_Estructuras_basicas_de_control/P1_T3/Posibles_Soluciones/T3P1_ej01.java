/*
 * 
 * Copyright 2021 mikel <mikel@DESKTOP-S61D0C5>
 * 
 */

import java.util.*;
public class T3P1_ej01 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
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
  }
}
