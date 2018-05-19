package nl.patrickdev.projectassessment;

import java.util.Scanner;

public class LeonardoArchimedes extends Question {
    private int answer,
            hoeveelJaarMinderDanAMaal3,
            verledenHoeveelJaarMeerDan2KeerA,
            jarenVerschil;

    private int antwoord;

    public LeonardoArchimedes() {

        hoeveelJaarMinderDanAMaal3 = 6 + random.nextInt(10);
        verledenHoeveelJaarMeerDan2KeerA = 10 + random.nextInt(5);
        jarenVerschil = 3 + random.nextInt(4);

        // Vraag instellen
        this.question = String.format("Leonardo is %s jaar minder dan 3x zo oud als " +
                        "Archimedes. %s jaar geleden was hij %s jaar meer dan 2x zo oud als " +
                        "Archimedes.",
                hoeveelJaarMinderDanAMaal3, jarenVerschil, verledenHoeveelJaarMeerDan2KeerA);

        // Goede antwoord berekenen
        antwoord = getAnswer();
    }

    private int getAnswer() {
        int i = 3 * verledenHoeveelJaarMeerDan2KeerA - 3 * jarenVerschil + 2 * hoeveelJaarMinderDanAMaal3;
        return i;
    }

    boolean correctMultipleChoice(int option) {
        return false;
    }

    boolean correctExact(String answer) {
        return false;
    }

    @Override
    boolean readAndRate(Scanner in) {
        System.out.print("Hoe oud is Leonardo? -> ");
        int inputA = in.nextInt();

        return inputA == antwoord;
    }

}
