import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

    private String[] ranks = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
    private String[] ranksDisplay = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < ranks.length ; i++) {
            for (int j = 0; j < suits.length; j++) {
                Card tempCard = new Card();
                tempCard.setRank(ranks[i]);
                tempCard.setRankDisplay(ranksDisplay[i]);
                tempCard.setSuit(suits[j]);
                cards.add(tempCard);
            }
        }
    }

    public static Deck shuffle(Deck deck){
        int n = deck.getCards().size();
        for (int i = 0; i < deck.getCards().size(); i++) {
            int r = i + (int) (Math.random() * (n-i));
            Card tempCardI = deck.getCards().get(i);
            Card tempCardR = deck.getCards().get(r);
            deck.getCards().set(r, tempCardI);
            deck.getCards().set(i, tempCardR);
        }
        return deck;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Number of cards: " + this.cards.size() + "\nDeck{" +
                "cards=" + cards +
                '}';
    }
}
