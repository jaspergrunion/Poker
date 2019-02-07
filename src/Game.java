import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {

        System.out.println("LET'S PLAY POKER!");
        System.out.println();

        /*
        int numPlayers = 6;
        int numPlayerCards = 2;
        int numCommonCards = 5;
        System.out.println("Number of players: " + numPlayers);
        System.out.println("Number of player cards: " + numPlayerCards);
        System.out.println("Number of common cards: " + numCommonCards);
        System.out.println();

        // Create new deck and shuffle
        Deck deck = new Deck();
        Deck.shuffle(deck);
        System.out.println("SHUFFLED DECK:");
        System.out.println(deck);
        System.out.println();

        // Create list of players
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player();
            player.setChips(100);
            players.add(player);
        }

        // Deal all cards
        for (int i = 0; i < numPlayerCards; i++) {
            for (Player player : players){
                Card card = deck.getCards().remove(0);
                player.setCard(card);
            }
        }

        for (Player player: players){
            System.out.println(player);
        }
        System.out.println();

        List<Card> commonCards = new ArrayList<>();
        for (int i = 0; i < numCommonCards + 3 ; i++) {
            Card card = deck.getCards().remove(0);
            if (!(i == 0 || i == 4 || i == 6)){
                commonCards.add(card);
            }
        }
        System.out.println("Common cards: " + commonCards);
        System.out.println();

        // Add common cards to each players hand
        for (Player player : players){
            for (Card card : commonCards) {
                player.setCard(card);
            }
        }

        for (Player player : players){
            System.out.println(player);
            Evaluate.hand(player);
        }
        */

        // test player
        Player player1 = new Player();

        Card card1 = new Card();
        card1.setSuit("Spades");
        card1.setRank("M");
        card1.setRankDisplay("Ace");
        player1.setCard(card1);

        Card card2 = new Card();
        card2.setSuit("Spades");
        card2.setRank("L");
        card2.setRankDisplay("King");
        player1.setCard(card2);

        Card card3 = new Card();
        card3.setSuit("Spades");
        card3.setRank("K");
        card3.setRankDisplay("Queen");
        player1.setCard(card3);

        Card card4 = new Card();
        card4.setSuit("Spades");
        card4.setRank("J");
        card4.setRankDisplay("Jack");
        player1.setCard(card4);

        Card card5 = new Card();
        card5.setSuit("Spades");
        card5.setRank("I");
        card5.setRankDisplay("Ten");
        player1.setCard(card5);

        System.out.println(player1);

        Evaluate.hand(player1);
    }
}
