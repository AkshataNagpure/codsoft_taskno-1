import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {

            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew round! Guess the number between 1 and 100.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next();
                }

                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess);
            }

            totalRounds++;

            totalAttempts += attempts;

            System.out.print("\nDo you want to play another round? (y/n): ");
            String playAgain = scanner.next();
            if (playAgain.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total attempts made: " + totalAttempts);

        if (totalRounds > 0) {
            double averageAttempts = (double) totalAttempts / totalRounds;
            System.out.println("Average attempts per round: " + averageAttempts);
        } else {
            System.out.println("No rounds played.");
        }

        scanner.close();
    }
}
