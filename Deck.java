import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
        private List<Card> cards;
    
        public Deck() {
            cards = new ArrayList<>();
            initializeDeck();
        }
    
        private void initializeDeck() {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    cards.add(new Card(suit, rank));
                }
            }
        }
    
        public List<Card> getCards() {
            return cards;
        }
    
        public void shuffle() {
            Collections.shuffle(cards);
        }
    
        public void dealCards(List<Player> players, int numCards) {
            int numPlayers = players.size();
            int totalCards = numCards * numPlayers;
    
            if (totalCards <= cards.size()) {
                for (int i = 0; i < numCards; i++) {
                    for (Player player : players) {
                        Card card = cards.remove(0);
                        player.addCardToHand(card);
                    }
                }
            } else {
                System.out.println("Not enough cards in the deck to deal.");
            }
        }
    
        public Card drawCard() {
            if (!cards.isEmpty()) {
                return cards.remove(0);
            }
            return null;
        }
    
    
}
