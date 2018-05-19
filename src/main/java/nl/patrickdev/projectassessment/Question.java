package nl.patrickdev.projectassessment;

import java.util.Random;
import java.util.Scanner;

public abstract class Question {
    protected final static Random random = new Random();

    public String answerA;
    public String answerB;
    public String answerC;
    public String answerD;
    public String question;
    abstract boolean correctMultipleChoice(int option);
    abstract boolean correctExact(String answer);
    abstract boolean readAndRate(Scanner in);

}
