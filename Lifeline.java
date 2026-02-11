package com.gqt_java.java_gqt.project;

import java.util.Scanner;

public class Lifeline {
  public static int useLifeline(
            boolean lifelineUsed,Scanner sc,
            int correctAnswer,
            String audiencePoll,
            String[] options) {
        // COLORS
        String BLUE = "\u001B[34m";     // Lifeline options color
        String PURPLE = "\u001B[35m";   // Output result color
        String RESET = "\u001B[0m";

        if (lifelineUsed) {
            return -1;
        }
//  Lifeline options in BLUE color
        System.out.println(BLUE + "1) Audience Poll" + RESET);
        System.out.println(BLUE + "2) 50-50" + RESET);

        int choice = sc.nextInt();
      if (choice == 1) {
            // 👉 Audience poll result in PURPLE
            System.out.println(PURPLE + audiencePoll + RESET);
            System.out.print("Enter answer: ");
            return sc.nextInt();
        }
        else if (choice == 2) {
            // 👉 50-50 output in PURPLE
            System.out.println(PURPLE + "50-50 Options:" + RESET);
            System.out.println(options[correctAnswer - 1]);

            for (int i = 0; i < options.length; i++) {
                if (i != correctAnswer - 1) {
                    System.out.println(options[i]);
                    break;
                }
            }
            System.out.print("Enter answer: ");
            return sc.nextInt();
        }

        return -1;
    }
}
