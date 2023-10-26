package PackOne;

import java.util.Arrays;
import java.util.Scanner;

public class UserWish {
    private static final String[] WORDS = {"JAVA", "PYTHON", "COMPUTER", "PROGRAMMING", "DEVELOPMENT","CAR","BIKER"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
        int tries = 0;

        while (tries < MAX_TRIES && new String(guessedWord).contains("_")) {
            System.out.println("Current word: " + new String(guessedWord));
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toUpperCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                tries++;
                System.out.println("Wrong guess! Tries left: " + (MAX_TRIES - tries));
            }
        }

        if (new String(guessedWord).contains("_")) {
            System.out.println("Sorry, you lost! The word was: " + wordToGuess);
        } else {
            System.out.println("Congratulations! You guessed the word: " + new String(guessedWord));
        }

        scanner.close();
    }
}
