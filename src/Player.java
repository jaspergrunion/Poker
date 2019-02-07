import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cards = new ArrayList<>();
    private int chips;
    private boolean isRoyalStraightFlush;
    private boolean isStraightFlush;
    private boolean isFours;
    private boolean isFullHouse;
    private boolean isFlush;
    private boolean isStraight;
    private boolean isThrees;
    private boolean isTwoPair;
    private boolean isOnePair;
    private String topRank;

    private String flushTopRank = "";
    private String straightTopRank = "";

    public void setCard(Card card){
        this.cards.add(card);
    }

    public String getFlushTopRank() {
        return flushTopRank;
    }

    public void setFlushTopRank(String flushTopRank) {
        this.flushTopRank = flushTopRank;
    }

    public String getStraightTopRank() {
        return straightTopRank;
    }

    public void setStraightTopRank(String straightTopRank) {
        this.straightTopRank = straightTopRank;
    }

    public String getTopRank() {
        return topRank;
    }

    public void setTopRank(String topRank) {
        this.topRank = topRank;
    }

    public boolean isRoyalStraightFlush() {
        return isRoyalStraightFlush;
    }

    public void setRoyalStraightFlush(boolean royalStraightFlush) {
        isRoyalStraightFlush = royalStraightFlush;
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

    @Override
    public String toString() {
        return "Player{" +
//                "chips=" + chips +
                "cards=" + cards +
                '}';
    }
}
