import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Card> cards = new ArrayList<>();
    public int chips;

    public boolean isRoyalFlush;
    public boolean isStraightFlush;
    public boolean isFours;
    public boolean isFullHouse;
    public boolean isFlush;
    public boolean isStraight;
    public boolean isThrees;
    public boolean isTwos;
    public boolean isTwoPair;
    public boolean isOnes;
    public boolean isOnePair;

    public String rankRun = "";
    public String rankFours = "";
    public String rankFullHouse = "";
    public String rankThrees = "";
    public String rankTwos = "";
    public String rankTwoPair = "";
    public String rankOnes = "";
    public String rankOnePair = "";

    public String flushSuit = "";
    public String flushRun = "";
    public String straightRun = "";
    public String topCard = "";

    public String topHand = "";

    public void dealCard(Card card){
        this.cards.add(card);
    }

    @Override
    public String toString() {
        return "Player{" +
//                "chips=" + chips +
                "cards=" + cards +
                '}';
    }

}
