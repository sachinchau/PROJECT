import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Guessing Game");
            System.out.println("I have selected a number between 1 and 100. ");
            System.out.println("You have "+ maxAttempts +" attempts to guess it correctly.");


            while (attempts < maxAttempts && !guessedCorrectly) {
                attempts++;
                System.out.print("Enter your guess (" + attempts + "/" + maxAttempts + "): ");
                int userGuess = sc.nextInt();

                if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + numberToGuess);
            }

            int scoreForRound = Math.max(0, maxAttempts - attempts + 1); // Assign score based on attempts
            totalScore += scoreForRound; // Add round score to total score
            System.out.println("Your score for this round: " + scoreForRound);
            System.out.println("Your total score: " + totalScore);

           
            System.out.print("Would you like to play again? (yes/no): ");
            String response = sc.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
                System.out.println("Thanks for playing! Goodbye.");
            }
        }


        }
    }
    

