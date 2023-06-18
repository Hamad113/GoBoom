# Part 2

## A. Member Contributions

No | ID         | Name               | Task descriptions | Contribution %
-- | ---------- | ------------------ | -----------------  | --------------
1  | 1211300020 |Hamad Omar Bin Afeef|                     |100%
2  |            |      |                   |
3  |            |      |                   |
4  |            |      |                   |


## B. Part 1 Feature Completion (Latest)

Mark Y for Complete, P for Partial done, N for Not implemented.

No | Feature                                                                         | Completed (Y/P/N)
-- | ------------------------------------------------------------------------------- | -----------------
1  | All cards should be faced up to facilitate checking.                            |Y
2  | Start a new game with randomized 52 cards.                                      |Y
3  | The first card in the deck is the first lead card and is placed at the center.  |Y
4  | The first lead card determines the first player.                                |Y
5  | Deal 7 cards to each of the 4 players.                                          |Y
6  | All players must follow the suit or rank of the lead card.                      |Y
7  | The highest-rank card with the same suit as the lead card wins the trick.       |Y
8  | The winner of a trick leads the next card.                                      |Y


## C. Part 2 Feature Completion

Mark Y for Complete, P for Partial done, N for Not implemented.

No | Feature                                                                          | Completed (Y/P/N)
-- | -------------------------------------------------------------------------------- | -----------------
1  | If a player cannot follow suit or rank, the player must draw from the deck       |N
   | until a card can be played.                                                      |
2  | When the remaining deck is exhausted and the player cannot play,                 |N
   | the player does not play in the trick.                                           |N
3  | Finish a round of game correctly. Display the score of each player.              |N
4  | Can exit and save the game (use file or database).                               |P
5  | Can resume the game. The state of the game is restored when resuming a game      |P
   | (use file or database).                                                          |
6  | Reset the game. All scores become zero. Round and trick number restart from 1.   |N
7  | Support GUI playing mode (cards should be faced up or down as in the real game). |N
   | The GUI can be in JavaFX, Swing, Spring, or Android.                             |Y
8  | Keep the console output to facilitate checking.                                  |p
   | The data in console output and the GUI must tally.                               |Y


## D. Link to Part 2 GitHub Repo

https: //github.com/Hamad113/GoBoom.git

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






