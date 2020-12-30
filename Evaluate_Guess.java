package NumberGuess;

import javax.swing.*;

public class Evaluate_Guess {
    public static boolean evaluate(int guess, int n, int count, boolean game_end) {
        n = (int) (Math.random() * 100 + 1);
        while (count < 6) {
            try {
                String response = JOptionPane.showInputDialog(null, "Enter a Number from 1-100.\n This is your " + no(count) + " Guess.", "Number Guessing Game", 3);
                if (response == null) {
                    System.exit(0);
                }
                guess = Integer.parseInt(response);
                if (count == 5) {
                    JOptionPane.showMessageDialog(null, "" + no_left(n));
                    game_end = false;
                    break;
                } else if (guess != n) {
                    JOptionPane.showMessageDialog(null, "" + determineGuess(guess, n, count));
                    game_end = true;
                } else if (guess == n) {
                    JOptionPane.showMessageDialog(null, "" + correct_ans(count, n));
                    game_end = false;
                    break;
                }
                count++;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, " Please Enter a Valid Number.", "Error !!", 3);
            }

        }

        return game_end;
    }

    public static String determineGuess(int guess, int n, int count) {
        if (guess <= 0 || guess > 100) {
            return "Your Guess is Invalid.";
        } else if (guess > n + 20) {
            return "Your Guess is Quite Large.\nYou have " + (5 - count) + " Guesses Left.";
        } else if (guess < n - 20) {
            return "Your Guess is Quite Small.\nYou have " + (5 - count) + " Guesses Left.";
        } else if (guess > n && guess < n + 20) {
            return "You are Quite Close. Try a Smaller Number\nYou have " + (5 - count) + " Guesses Left.";
        } else if (guess < n && guess > n - 20) {
            return "You are Quite Close. Try a Larger Number\nYou have " + (5 - count) + " Guesses Left.";
        }
        return "Try Another Number";
    }

    public static String correct_ans(int count, int guess) {
        return "Correct! The Number was " + guess + "\nTotal Guesses: " + count;
    }

    public static String no_left(int n) {
        return "You Ran out of guesses.\nThe Number was " + n + ".";
    }

    public static String no(int count) {
        if (count == 1) {
            return "First";
        } else if (count == 2) {
            return "Second";
        } else if (count == 3) {
            return "Third";
        } else if (count == 4) {
            return "Fourth";
        } else {
            return "Last";
        }
    }

}
