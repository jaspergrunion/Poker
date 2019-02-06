import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cards = new ArrayList<>();
    private int chips;
    private boolean isStraightFlush;
    private boolean isFours;
    private boolean isFullHouse;
    private boolean isFlush;
    private boolean isStraight;
    private boolean isThrees;
    private boolean isTwoPair;
    private boolean isOnePair;
    private Card topCard;

    public void setCard(Card card){
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public boolean isStraightFlush() {
        return isStraightFlush;
    }

    public void setStraightFlush(boolean straightFlush) {
        isStraightFlush = straightFlush;
    }

    public boolean isFours() {
        return isFours;
    }

    public void setFours(boolean fours) {
        isFours = fours;
    }

    public boolean isFullHouse() {
        return isFullHouse;
    }

    public void setFullHouse(boolean fullHouse) {
        isFullHouse = fullHouse;
    }

    public boolean isFlush() {
        return isFlush;
    }

    public void setFlush(boolean flush) {
        isFlush = flush;
    }

    public boolean isStraight() {
        return isStraight;
    }

    public void setStraight(boolean straight) {
        isStraight = straight;
    }

    public boolean isThrees() {
        return isThrees;
    }

    public void setThrees(boolean threes) {
        isThrees = threes;
    }

    public boolean isTwoPair() {
        return isTwoPair;
    }

    public void setTwoPair(boolean twoPair) {
        isTwoPair = twoPair;
    }

    public boolean isOnePair() {
        return isOnePair;
    }

    public void setOnePair(boolean onePair) {
        isOnePair = onePair;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    @Override
    public String toString() {
        return "Player{" +
//                "chips=" + chips +
                "cards=" + cards +
                '}';
    }
}
