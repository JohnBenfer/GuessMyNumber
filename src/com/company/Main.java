package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Guess My Number");
        Scanner in = new Scanner(System.in);
        String repeat = "y";

        while (repeat == "y") {
            System.out.println(repeat);
            repeat = playGame(in, repeat);
            System.out.println(repeat);
            if (repeat == "n") {
                repeat = "n";
            } else if (repeat == "y") {
                repeat = "y";
            }
        }

        System.out.println("Thanks for playing!");

        // debug System.out.println(userGuess);
        // debug System.out.println(num);



    }
    private static String playGame(Scanner in, String repeat) {
        int max = getMax(in);
        int num = getNumber(max);
        int userGuess = getGuess(in);
        String out = testInput(num, userGuess);
        while (out != "Correct!") {

            System.out.println(out);
            userGuess = getGuess(in);
            out = testInput(num, userGuess);
        }
        System.out.println(out);
        repeat = getRepeat(in);

        System.out.println(repeat);
        return repeat;
    }


    public static int getNumber(int max) {
        int randomNumber = (int)(Math.random() * max + 1);
        return randomNumber;
    }


    public static String testInput(int num, int userGuess) {
        String out;
        if (userGuess == num) {
            out = "Correct!";
            return out;

        } else if (userGuess > num) {
            out = "Too high";
            return out;

        } else if (userGuess < num) {
            out = "Too low";
            return out;
        }
        return null;
    }


    public static int getGuess(Scanner in) {

        int userGuess = in.nextInt();
        return userGuess;
    }


    public static int getMax(Scanner in) {
        System.out.println("What would you like the max integer to be?");
        int max = in.nextInt();
        System.out.println("Okay, guess an integer between 1 and " + max + "! Good luck!");
        return max;
    }


    public static String getRepeat(Scanner in) {
        System.out.println("Congrats on the correct answer!");
        System.out.println("Would you like to play again? (y/n)");
        String repeat = in.next();
        return repeat;
    }
}
