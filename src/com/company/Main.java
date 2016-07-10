package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        System.out.println("Guess My Number");
        Scanner in = new Scanner(System.in);
        String repeat = "y";

        while (repeat.equals("y")) {
            repeat = playGame(in, repeat, count);
        }
        System.out.println("Thanks for playing!");
    }


    private static String playGame(Scanner in, String repeat, int count) {
        int max = getMax(in);
        int num = getNumber(max);
        int userGuess = getGuess(in);
        String out = testInput(num, userGuess);
        while (out != "Correct!") {

            System.out.println(out);
            userGuess = getGuess(in);
            count++;
            out = testInput(num, userGuess);
        }
        System.out.println(out);
        repeat = getRepeat(in, count);
        return repeat;
    }


    public static int getNumber(int max) {
        int randomNumber = (int)(Math.random() * max + 1);
        return randomNumber;
    }


    public static String testInput(int num, int userGuess) {
        String out = "";
        if (userGuess == num) {
            out = "Correct!";

        } else if (userGuess > num) {
            out = "Too high";

        } else if (userGuess < num) {
            out = "Too low";
        }
        return out;
    }


    public static int getGuess(Scanner in) {

        return in.nextInt();
    }


    public static int getMax(Scanner in) {
        System.out.println("What would you like the max integer to be?");
        int max = in.nextInt();
        System.out.println("Okay, guess an integer between 1 and " + max + "! Good luck!");
        return max;
    }


    public static String getRepeat(Scanner in, int count) {
        System.out.println("Congrats on the correct answer!");
        System.out.println("It took you " + count + " guesses.");
        System.out.println("Would you like to play again? (y/n)");
        return in.next();
    }
}
