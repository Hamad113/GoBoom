import java.util.List;
import java.util.ArrayList;


class Trick {
    private List<Card> cards;
    private Suit currentSuit;
    private Rank currentRank;

    public Trick() {
        cards = new ArrayList<>();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getSize() {
        return cards.size();
    }

    public Suit getCurrentSuit() {
        return currentSuit;
    }

    public Rank getCurrentRank() {
        return currentRank;
    }

    public void addCard(Card card) {
        cards.add(card);
        if (currentSuit == null && currentRank == null) {
            currentSuit = card.getSuit();
            currentRank = card.getRank();
        }
    }

    public void clear() {
        cards.clear();
        currentSuit = null;
        currentRank = null;
    }

    public Card getCard(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        }
        return null;
    }

    public boolean isComplete(int numPlayers) {
        return cards.size() == numPlayers;
    }

    public int getWinner() {
        int cardIndex = 0;
        Card winningCard = getWinningCard();
        if (winningCard != null) {
            // Find the player who played the winning card
            for (Card card : cards) {
                if (card.equals(winningCard)) {
                    return cardIndex;
                }
                cardIndex++;
            }
        }
        return -1; // No winner found
    }

    private Card getWinningCard() {
        Card highestCard = null;
        for (Card card : cards) {
            if (highestCard == null || card.getRank().ordinal() > highestCard.getRank().ordinal()) {
                highestCard = card;
            }
        }
        return highestCard;
    }

    public List<Card> getPlayedCards() {
        return cards;
    }
}

