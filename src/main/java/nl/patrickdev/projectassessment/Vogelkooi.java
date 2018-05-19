package nl.patrickdev.projectassessment;

import java.util.Scanner;

public class Vogelkooi extends Question {
    private int oppervlakteTuin, budget,
            inhoudA, oppervlakteA, kostenA,
            inhoudB, oppervlakteB, kostenB;

    private int antwoordA, antwoordB;

    public Vogelkooi() {
        oppervlakteTuin = random.nextInt(8) * 4 + 40;
        budget = random.nextInt(10) * 25 + 600;

        inhoudA = random.nextInt(6) * 4 + 8;
        oppervlakteA = random.nextInt(3) + 2;
        kostenA = (2 + random.nextInt(3)) * 25;

        do {
            inhoudB = random.nextInt(6) * 4 + 8;
        } while (inhoudB == inhoudA);

        do {
            oppervlakteB = random.nextInt(5) + 10;
        } while (oppervlakteB == oppervlakteA);

        do {
            kostenB = (2 + random.nextInt(3)) * 25;
        } while (kostenB == kostenA);


        // Vraag instellen
        this.question = String.format("Leonardo wil enkele vogelkooien in zijn tuin zetten. " +
                        "Hij heeft hier %s m² tuin en € %s voor gereserveerd. Vogelkooi A heeft " +
                        "een inhoud van %s m³ en grondoppervlak van %s m² en kost € %s. Vogelkooi " +
                        "B heeft een grondoppervlak van %s m², een inhoud van %s m³ en hij kost € " +
                        "%s. Hoeveel van elke vogelkooi moet hij neerzetten om een zo groot mogelijke " +
                        "vogelkooi inhoud te halen, binnen zijn budget en de gereserveerde plaats? " +
                        "Vanwege de fragiele bouw van de vogelkooien is het niet mogelijk om ze te stapelen.",
                oppervlakteTuin, budget, inhoudA, oppervlakteA, kostenA, oppervlakteB, inhoudB, kostenB);

        // Goede antwoord berekenen
        int[] answer = getAnswer();
        antwoordA = answer[0];
        antwoordB = answer[1];
    }

    private int[] getAnswer() {
        int[] result = new int[3];
        bruteforce(0, 0, 0, 0, 0, result);
        return result;
    }

    private void bruteforce(int kooiASoFar, int kooiBSoFar, int oppervlakteSoFar, int budgetSpent, int inhoudSoFar, int[] result) {
        if (oppervlakteSoFar > oppervlakteTuin || budgetSpent > budget) {
            return;
        }

        if (inhoudSoFar > result[2]) {
            result[0] = kooiASoFar;
            result[1] = kooiBSoFar;
            result[2] = inhoudSoFar;
        }

        bruteforce(kooiASoFar + 1, kooiBSoFar, oppervlakteSoFar + oppervlakteA, budgetSpent + kostenA, inhoudSoFar + inhoudA, result);
        bruteforce(kooiASoFar, kooiBSoFar + 1, oppervlakteSoFar + oppervlakteB, budgetSpent + kostenB, inhoudSoFar + inhoudB, result);
    }

    boolean correctMultipleChoice(int option) {
        return false;
    }

    boolean correctExact(String answer) {
        return false;
    }

    @Override
    boolean readAndRate(Scanner in) {
        System.out.print("Hoeveel voor A? -> ");
        int inputA = in.nextInt();
        System.out.println("Hoeveel voor B? -> ");
        int inputB = in.nextInt();

        return inputA == antwoordA && inputB == antwoordB;
    }

}
