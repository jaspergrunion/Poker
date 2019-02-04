public class Play {
    public static void main(String[] args) {

        System.out.println("LET'S PLAY POKER!");
        int numPlayers = 4;
        int numPlayerCards = 2;
        int numCommonCards = 5;
        System.out.println("Number of players: " + numPlayers);
        System.out.println("Number of player cards: " + numPlayerCards);
        System.out.println("Number of common cards: " + numCommonCards);

        // Create new deck
        Deck deck1 = new Deck();
        System.out.println();

        System.out.println("FRESH DECK:");
        System.out.println("Number of cards in deck: " + deck1.getCards().size());
        System.out.println(deck1);
        System.out.println("27th Card: " + deck1.getCards().get(26));
        System.out.println();

        // Shuffle deck
        Deck.shuffle(deck1);
        System.out.println("AFTER SHUFFLING:");
        System.out.println("Number of cards in deck: " + deck1.getCards().size());
        System.out.println(deck1);
        System.out.println("27th Card: " + deck1.getCards().get(26));
        System.out.println();

        Deck.shuffle(deck1);
        System.out.println("AFTER SHUFFLING AGAIN:");
        System.out.println("Number of cards in deck: " + deck1.getCards().size());
        System.out.println(deck1);
        System.out.println("27th Card: " + deck1.getCards().get(26));
        System.out.println();

    }
}
