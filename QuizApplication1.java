package com.gqt_java.java_gqt.project;
import java.util.Scanner;
public class QuizApplication1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        boolean lifelineUsed = false;
        int ans;
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("\nWelcome " + name + "! Quiz Started\n");
        Question[] questions = new Question[10];
        questions[0] = new Question(
                "Q1. What is the capital city of India?",
                new String[]{"1) Chennai","2) Mumbai","3) New Delhi","4) Kolkata"},
                3,
                "Chennai:10%  Mumbai:15%  New Delhi:60%  Kolkata:15%"
        );
        questions[1] = new Question(
                "Q2. Which language is mainly used for Android app development?",
                new String[]{"1) Java","2) Python","3) PHP","4) C"},
                1,
                "Java:70%  Python:10%  PHP:10%  C:10%"
        );
        questions[2] = new Question(
                "Q3. Which keyword is used to create an object in Java?",
                new String[]{"1) object","2) new","3) class","4) create"},
                2,
                "object:10%  new:75%  class:10%  create:5%"
        );
        questions[3] = new Question(
                "Q4. Which company developed Java?",
                new String[]{"1) Google","2) Microsoft","3) Sun Microsystems","4) Apple"},
                3,
                "Google:10%  Microsoft:10%  Sun Microsystems:70%  Apple:10%"
        );
        questions[4] = new Question(
                "Q5. Which symbol is used for single-line comments in Java?",
                new String[]{"1) #","2) <!-- -->","3) //","4) /* */"},
                3,
                "#:5%  <!-- -->:10%  //:75%  /* */:10%"
        );
        questions[5] = new Question(
                "Q6. Which data type is used to store decimal values?",
                new String[]{"1) char","2) boolean","3) float","4) int"},
                3,
                "char:5%  boolean:10%  float:75%  int:10%"
        );
        questions[6] = new Question(
                "Q7. Which loop executes at least once?",
                new String[]{"1) while","2) for","3) do-while","4) foreach"},
                3,
                "while:10%  for:15%  do-while:70%  foreach:5%"
        );
        questions[7] = new Question(
                "Q8. Which method is the entry point of Java?",
                new String[]{"1) run()","2) main()","3) start()","4) init()"},
                2,
                "run():10%  main():75%  start():10%  init():5%"
        );
        questions[8] = new Question(
                "Q9. Which operator is used for comparison?",
                new String[]{"1) +","2) =","3) ==","4) *"},
                3,
                "+:5%  =:10%  ==:75%  *:10%"
        );
        questions[9] = new Question(
                "Q10. Java is a ______ language.",
                new String[]{"1) Assembly","2) Low-level","3) High-level","4) Machine"},
                3,
                ""
        );
        int[] rewards = {1000,20000,30000,40000,50000,60000,70000,80000,85000,100000};

        for (int i = 0; i < 10; i++) {
            Question q = questions[i];
            while (true) {
                System.out.println("\n" + q.text);
                for (String opt : q.options) {
                    System.out.println(opt);
                }
                if (i < 9)
                    System.out.println("5) Lifeline");
                ans = sc.nextInt();
                if (ans == 5 && i < 9) {
                    int newAns = Lifeline.useLifeline(
                            lifelineUsed, sc, q.correctAnswer, q.audiencePoll, q.options);
                    if (newAns == -1) {
                        System.out.println(YELLOW + "No more lifelines are available\n" + RESET);
                        continue;
                    }
                    lifelineUsed = true;
                    ans = newAns;
                }
                if (ans == q.correctAnswer) {
                    System.out.println(GREEN + name +
                            " it is correct answer you are rewarded with " + rewards[i] + RESET);
                    break;
                } else {
                    System.out.println(RED + "Wrong Answer! Game Over" + RESET);
                    sc.close();
                    return;
                }
            }
        }
        System.out.println(GREEN + " CONGRATULATIONS YOU WON THE QUIZ " + RESET);
        sc.close();
    }
}
