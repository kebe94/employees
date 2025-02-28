package com.kebe94.employees.divers;

import java.util.Random;

public class Generate {
    public static String CodeGenerate(String code, int nb){
      String start = code;
      Random value = new Random();
      int r_value = 10;
      int count_nb = 0;
      //Générer deux valeurs à ajouter 'Value'
      int r1 = value.nextInt(r_value);
      int r2 = value.nextInt(r_value);
      start += Integer.toString(r1) + Integer.toString(r2) + "";

      int count = count_nb;
      int n = count_nb;
      for (int i = 0; i < nb; i++) {
          if (count == 4) {
              start += "";
              count = count_nb;
          } else
              n = value.nextInt(r_value);
          start += Integer.toString(n);
          count++;

      }
      return start;
    }
}
