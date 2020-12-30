package NumberGuess;

import javax.swing.*;

public class Check_Guess extends Evaluate_Guess {
    int n = 0;
    int guess = 0;
    int count = 1;
    boolean game_end = true;
    int k;

    public void check_guess() {
        do {
            super.evaluate(guess, n, count, game_end);
            if (game_end) {
                k = JOptionPane.showConfirmDialog(
                        null,
                        "Would you like to Continue?",
                        "Number Guessing Game",
                        JOptionPane.YES_NO_OPTION);
            }
        }
        while (k == JOptionPane.YES_OPTION);
    }
}



