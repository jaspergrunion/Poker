import java.util.ArrayList;
import java.util.List;

public class Main {
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
//        */

        // test player
        Player player1 = new Player();

        Card card1 = new Card();
        card1.setRank("2");
        card1.setSuit("Spades");
        player1.setCard(card1);

        Card card2 = new Card();
        card2.setRank("3");
        card2.setSuit("Spades");
        player1.setCard(card2);

        Card card3 = new Card();
        card3.setRank("4");
        card3.setSuit("Spades");
        player1.setCard(card3);

        Card card4 = new Card();
        card4.setRank("5");
        card4.setSuit("Spades");
        player1.setCard(card4);

        Card card5 = new Card();
        card5.setRank("6");
        card5.setSuit("Spades");
        player1.setCard(card5);

        Card card6 = new Card();
        card6.setRank("King");
        card6.setSuit("Spades");
        player1.setCard(card6);

        Card card7 = new Card();
        card7.setRank("5");
        card7.setSuit("Hearts");
        player1.setCard(card7);

        System.out.println(player1);

        Evaluate.hand(player1);

    }
}
