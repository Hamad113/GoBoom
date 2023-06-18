import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> playerNames = Arrays.asList("Player 1", "Player 2", "Player 3", "Player 4"); // Customize player names here
        Game game = new Game(playerNames);
        game.startNewGame();
    }
}






