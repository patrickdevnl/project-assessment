package nl.patrickdev.projectassessment;

import java.util.Scanner;

public class CijferGemiddelde extends Question {
    double antwoord,
            grade1,
            grade2;
    int testAmount,
            gradeWeight;

    public CijferGemiddelde() {
        double average;
        do {
            testAmount = random.nextInt(5) + 4;
            grade1 = (random.nextInt(91) + 10) / 10d;
            grade2 = (random.nextInt(91) + 10) / 10d;
            antwoord = (random.nextInt(91) + 10) / 10d;
            gradeWeight = random.nextInt(3) * 25 + 25;
            average = (grade1 + grade2) / 2 * ((100 - gradeWeight) / 100d) + antwoord * (gradeWeight / 100d);
        } while (average % 0.1 > 0 || average < 5.5);

        // Vraag instellen
        this.question = String.format("Leonardo moet voor zijn wiskunde examen %s toetsen maken. Voor " +
                        "de eerste 2 haalt hij een %s en een %s. Hij wil een %s gemiddeld scoren. De %s " +
                        "toetsen die hij nog moet maken tellen samen voor %s%% mee voor het eindcijfer.",
                testAmount,
                grade1,
                grade2,
                average,
                testAmount - 2,
                gradeWeight);
    }

    boolean correctMultipleChoice(int option) {
        return false;
    }

    boolean correctExact(String answer) {
        return false;
    }

    @Override
    boolean readAndRate(Scanner in) {
        System.out.print("Wat moet hij gemiddeld halen? -> ");
        double inputA = in.nextDouble();

        return inputA == antwoord;
    }

}
