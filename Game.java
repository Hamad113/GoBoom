
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Deck deck;
    private List<Player> players;
    private Trick currentTrick;
    private int currentTrickId;
    private int currentPlayerIndex;

    public Game(List<String> playerNames) {
        deck = new Deck();
        players = new ArrayList<>();
        initializePlayers(playerNames);
        currentTrick = new Trick();
        currentPlayerIndex = 0;
        currentTrickId = 1;
    }
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
    public int getCurrentTrickId() {
        // Return the current trick ID
        // Implement your logic here
        return currentTrickId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Trick getCurrentTrick() {
        return currentTrick;
    }

    public Deck getDeck() {
        return deck;
    }

    public void startNewGame() {
        deck.shuffle();
        dealCardsToPlayers();
        playGame();
    }

    private void initializePlayers(List<String> playerNames) {
        for (String name : playerNames) {
            Player player = new Player(name);
            players.add(player);
        }
    }

    private void dealCardsToPlayers() {
        int numCardsPerPlayer = 7; // Customize this according to your game rules
        deck.dealCards(players, numCardsPerPlayer);
    }

    private void playGame() {
        boolean gameEnd = false;
        Player winner = null;

        while (!gameEnd) {
            Player currentPlayer = players.get(currentPlayerIndex);

            if (currentPlayer.getHand().isEmpty()) {
                gameEnd = true;
                winner = currentPlayer;
                break;
            }

            displayGameState();

            System.out.println("Turn: " + currentPlayer.getName());
            System.out.println("Enter a command (s - Start new game, x - Exit, d - Draw cards, card - Play a card):");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            switch (command) {
                case "s":
                    startNewGame();
                    return;
                case "x":
                    gameEnd = true;
                    break;
                case "d":
                    Card drawnCard = deck.drawCard();
                    if (drawnCard != null) {
                        currentPlayer.addCardToHand(drawnCard);
                        System.out.println("Player " + currentPlayer.getName() + " drew a card: " + drawnCard);
                    } else {
                        System.out.println("No more cards in the deck.");
                    }
                    break;
                default:
                    Card playedCard = currentPlayer.getCardFromHand(command);

                    if (currentTrickId == 1 || playedCard.getSuit().equals(currentTrick.getCurrentSuit()) || playedCard.getRank().equals(currentTrick.getCurrentRank())) {
                        playedCard = currentPlayer.playCard(playedCard);
                        if (playedCard != null) {
                            currentTrick.addCard(playedCard);
                            System.out.println("Player " + currentPlayer.getName() + " played: " + playedCard);
                            currentPlayer.removeCardFromHand(playedCard);
                            currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); // Move to the next player
                            if (currentTrick.isComplete(players.size())) {
                                int trickWinnerIndex = currentTrick.getWinner();
                                Player trickWinner = players.get(trickWinnerIndex);
                                if (trickWinner != null) {
                                    trickWinner.addToScore(1);
                                }
                                System.out.println("*** Player " + trickWinner.getName() + " wins Trick #" + trickWinner.getScore() + " ***");
                                currentTrick.clear();
                            }
                            currentTrickId++;
                        }
                    } else {
                        System.out.println("Invalid card. Try again.");
                    }
                    break;
            }
        }

        declareWinner(winner);
    }

    private void displayGameState() {
        System.out.println("Trick #" + (players.get(0).getScore() + 1));
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getHand());
        }
        System.out.println("Center: " + currentTrick.getPlayedCards());
        System.out.println("Deck: " + deck.getCards());
        System.out.println("Score:");
        for (Player player : players) {
            System.out.println(player.getName() + " = " + player.getScore());
        }
    }

    private void declareWinner(Player winner) {
        System.out.println("Game over!");
        System.out.println("The winner is: " + winner.getName());
        System.out.println("Final scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}
