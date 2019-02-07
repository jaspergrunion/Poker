import java.util.*;

public class Evaluate {

    public static void hand(Player player) {

        // Determine flush
        TreeMap<String, Integer> suitMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (suitMap.containsKey(card.getSuit())) {
                suitMap.put(card.getSuit(), suitMap.get(card.getSuit()) + 1);
            } else {
                suitMap.put(card.getSuit(), 1);
            }
        }
        System.out.println("Suit Map: " + suitMap);

        String flushSuit = "";
        for (Map.Entry<String, Integer> entry : suitMap.entrySet()) {
            if (entry.getValue() >= 5){
                player.setFlush(true);
                flushSuit = entry.getKey();
            }
        }

        // Determine straight
        TreeMap<String, Integer> rankMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), rankMap.get(card.getRank()) + 1);
            } else {
                rankMap.put(card.getRank(), 1);
            }
        }
        System.out.println(rankMap);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : rankMap.entrySet()) {
            sb.append(entry.getKey());
        }
        String cardOrder = sb.toString();

        String[] straightsArray = {"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI", "FGHIJ", "GHIJK", "HIJKL", "IJKLM"};
        boolean hasStraight = false;
        for(String string : straightsArray){
            // Handle ace low
            if (cardOrder.contains("ABCD") && cardOrder.contains("M")){
                hasStraight = true;
                player.setStraightTopRank("D");
            }
            // Other straights
            if (cardOrder.contains(string)) {
                hasStraight = true;
                player.setStraightTopRank(string.substring(4));
            }
        }
        if(hasStraight){
            player.setStraight(true);
        }
        // Determine straight flushes
        player.setStraightFlush(player.isFlush() && player.isStraight());
        player.setRoyalStraightFlush(player.isStraightFlush() && player.getStraightTopRank().equals("M"));

        // Print hand strength booleans
//        System.out.println();
        System.out.println("> Royal Straight Flush: " + player.isRoyalStraightFlush());
        System.out.println("> Straight Flush: " + player.isStraightFlush());
        System.out.println("> Flush: " + player.isFlush());
        System.out.println("> Flush suit: " + flushSuit);
        System.out.println("> Straight: " + player.isStraight());
        System.out.println("> Straight Top Rank: " + player.getStraightTopRank());

        System.out.println();

    }

}
