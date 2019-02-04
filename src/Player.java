import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cards = new ArrayList<>();
    private int chips;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setCard(Card card){
        this.cards.add(card);
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    @Override
    public String toString() {
        return "Player{" +
                "chips=" + chips +
                ", cards=" + cards +
                '}';
    }
}
