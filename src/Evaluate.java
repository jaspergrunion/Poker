import java.util.*;

public class Evaluate {

    public static void hand(Player player) {

        // Counts by suit
        TreeMap<String, Integer> suitMap = new TreeMap<>();
        for (Card card : player.cards) {
            if (suitMap.containsKey(card.getSuit())) {
                suitMap.put(card.getSuit(), suitMap.get(card.getSuit()) + 1);
            } else {
                suitMap.put(card.getSuit(), 1);
            }
        }

        // Determine flush
        for (Map.Entry<String, Integer> entry : suitMap.entrySet()) {
            if (entry.getValue() >= 5){
                player.isFlush = true;
                player.flushSuit = entry.getKey();
            }
        }

        // Create list of cards with flush cards only
        List<Card> flushCards = new ArrayList<>();
        for (Card card : player.cards) {
            if (card.getSuit().equals(player.flushSuit)){
                flushCards.add(card);
            }
        }

        TreeMap<String, Integer> rankFlushMap = new TreeMap<>();
        for (Card card : flushCards) {
            if (rankFlushMap.containsKey(card.getRankHidden())) {
                rankFlushMap.put(card.getRankHidden(), rankFlushMap.get(card.getRankHidden()) + 1);
            } else {
                rankFlushMap.put(card.getRankHidden(), 1);
            }
        }

        StringBuilder sbf = new StringBuilder();
        for (Map.Entry<String, Integer> entry : rankFlushMap.entrySet()) {
            sbf.append(entry.getKey());
        }
        player.flushRun = sbf.toString();

        // Counts by rank
        TreeMap<String, Integer> rankMap = new TreeMap<>();
        for (Card card : player.cards) {
            if (rankMap.containsKey(card.getRankHidden())) {
                rankMap.put(card.getRankHidden(), rankMap.get(card.getRankHidden()) + 1);
            } else {
                rankMap.put(card.getRankHidden(), 1);
            }
        }

        // Determine multiples
        StringBuilder sbRanks = new StringBuilder();
        StringBuilder sbFours = new StringBuilder();
        StringBuilder sbThrees = new StringBuilder();
        StringBuilder sbTwos = new StringBuilder();
        StringBuilder sbOnes = new StringBuilder();

        for (Map.Entry<String, Integer> entry : rankMap.entrySet()) {
            sbRanks.append(entry.getKey());
            if (entry.getValue() == 4){
                player.isFours = true;
                sbFours.append(entry.getKey());
            }
            if (entry.getValue() == 3){
                player.isThrees = true;
                sbThrees.append(entry.getKey());
            }
            if (entry.getValue() == 2){
                player.isTwos = true;
                sbTwos.append(entry.getKey());
            }
            if (entry.getValue() == 1){
                player.isOnes = true;
                sbOnes.append(entry.getKey());
            }
        }
        player.rankRun = sbRanks.toString();
        player.rankFours = sbFours.toString();
        player.rankThrees = sbThrees.toString();
        player.rankTwos = sbTwos.toString();
        player.rankOnes = sbOnes.toString();

        player.isFullHouse = (player.isThrees && player.isTwos);
        player.rankFullHouse = (player.rankTwos.substring(player.rankTwos.length() - 1) +
                player.rankThrees.substring(player.rankThrees.length() - 1));
        player.isTwoPair = (player.rankTwos.length() >= 2);
        player.rankTwoPair = (player.rankTwos.substring(player.rankTwos.length() - 2));
        player.isOnePair = (player.rankTwos.length() >= 1);
        player.rankOnePair = (player.rankTwos.substring(player.rankTwos.length() - 1));

        // Determine straights
        String[] straightsArray = {"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI", "FGHIJ", "GHIJK", "HIJKL", "IJKLM"};

        // Handle ace low
        if (player.rankRun.contains("ABCD") && player.rankRun.contains("M")){
            player.isStraight = true;
            player.straightRun = "MABCD";
        }

        // Check for other straights
        for(String string : straightsArray){
            if (player.rankRun.contains(string)) {
                player.isStraight = true;
                player.straightRun = string;
            }
        }

        // Determine straight flushes
        player.isStraightFlush = (player.isFlush && player.isStraight &&
                (player.flushRun.contains(player.straightRun) ||
                        (player.straightRun.equals("MABCD") &&
                                player.flushRun.contains("ABCD") && player.flushRun.contains("M")))

        );
        player.isRoyalFlush = (player.isStraightFlush && player.straightRun.equals("IJKLM"));

        // Print hand strength
        System.out.println(player);
        System.out.println("Suit Map: " + suitMap);
        System.out.println("Rank flush map: " + rankFlushMap);
        System.out.println("Rank map: " + rankMap);
        System.out.println("Rank run: " + player.rankRun);
        System.out.println();
        System.out.println("> Royal flush: " + player.isRoyalFlush);
        System.out.println("> Straight flush: " + player.isStraightFlush);
        System.out.println();
        System.out.println("> Four of a kind: " + player.isFours);
        System.out.println("> Fours ranks: " + player.rankFours);
        System.out.println();
        System.out.println("> Full House: " + player.isFullHouse);
        System.out.println("> Full House ranks: " + player.rankFullHouse);
        System.out.println();
        System.out.println("> Flush: " + player.isFlush);
        System.out.println("> Flush suit: " + player.flushSuit);
        System.out.println("> Flush run: " + player.flushRun);
        System.out.println();
        System.out.println("> Straight: " + player.isStraight);
        System.out.println("> Straight run: " + player.straightRun);
        System.out.println();
        System.out.println("> Three of a kind: " + player.isThrees);
        System.out.println("> Threes ranks: " + player.rankThrees);
        System.out.println();
        System.out.println("> Two pair: " + player.isTwoPair);
        System.out.println("> Two Pair ranks: " + player.rankTwoPair);
        System.out.println();
        System.out.println("> One pair: " + player.isOnePair);
        System.out.println("> One Pair ranks: " + player.rankOnePair);
        System.out.println();
        System.out.println("> Two of a kind: " + player.isTwos);
        System.out.println("> Twos ranks: " + player.rankTwos);
        System.out.println();
        System.out.println("> One of a kind: " + player.isOnes);
        System.out.println("> One ranks: " + player.rankOnes);
        System.out.println();

    }

}
