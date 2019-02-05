import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {

        System.out.println("LET'S PLAY POKER!");
        System.out.println();

        int numPlayers = 4;
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

        for (Player player : players){
            for (Card card : commonCards) {
                player.setCard(card);
            }
        }

        for (Player player: players){
            System.out.println(player);
        }
        System.out.println();

        for (Player player :players){
            HandStrength.rankMap(player);
            HandStrength.suitMap(player);
            System.out.println();
        }

    }
}
