import java.util.List;
import java.util.ArrayList;

class Player {
    private String name;
    private List<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        score = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    public void clearHand() {
        hand.clear();
    }

    public void addToScore(int points) {
        score += points;
    }

    public Card playCard(Card card) {
        if (card != null) {
            // Remove the card from the player's hand
            removeCardFromHand(card);
            // Add the card to the current trick
            return card;
        } else {
            System.out.println("Invalid card selection. Please choose a valid card from your hand.");
            return null;
        }
    }

    public Card getCardFromHand(String command) {
        // Extract the suit and rank from the command
        String suitString = command.substring(0, 1);
        String rankString = command.substring(1);

        // Find the matching card in the player's hand
        for (Card card : hand) {
            if (card.getSuit().getSymbol().equals(suitString) && card.getRank().getSymbol().equals(rankString)) {
                return card;
            }
        }
        return null; // Card not found in the hand
    }
}
