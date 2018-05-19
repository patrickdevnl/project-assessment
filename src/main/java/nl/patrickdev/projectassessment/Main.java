package nl.patrickdev.projectassessment;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Question a = getQuestion();

        Scanner input = new Scanner(System.in)
                .useLocale(Locale.ENGLISH);

        System.out.println("\n\n" + a.question);
        while (true) {
            boolean correct = a.readAndRate(input);
            if (!correct) {
                System.out.println("Oei, da's best wel fout. Nog een keer!");
            } else {
                System.out.println("Jeeeej!");
                break;
            }
        }
    }


    public static Question getQuestion() {
        Random r = new Random();
        switch (r.nextInt(3)) {
            case 0:
                return new Vogelkooi();
            case 1:
            default:
                return new LeonardoArchimedes();
            case 2:
                return new CijferGemiddelde();
        }
    }
}
