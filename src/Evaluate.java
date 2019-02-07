import java.util.*;

public class Evaluate {

    public static void hand(Player player) {

        // Counts by suit
        TreeMap<String, Integer> suitMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (suitMap.containsKey(card.getSuit())) {
                suitMap.put(card.getSuit(), suitMap.get(card.getSuit()) + 1);
            } else {
                suitMap.put(card.getSuit(), 1);
            }
        }
        System.out.println("Suit Map: " + suitMap);

        // Determine flush
        String flushSuit = "";
        for (Map.Entry<String, Integer> entry : suitMap.entrySet()) {
            if (entry.getValue() >= 5){
                flushSuit = entry.getKey();
                player.setFlush(true);
            }
        }
        // Flush top rank
        String flushTopRank = "";
        for (Card card : player.getCards()){
            if ((card.getRank().compareTo(flushTopRank) > 0) && card.getSuit().equals(flushSuit)){
                flushTopRank = card.getRank();
            }
        }
        player.setFlushTopRank(flushTopRank);

        // Counts by rank
        TreeMap<String, Integer> rankMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), rankMap.get(card.getRank()) + 1);
            } else {
                rankMap.put(card.getRank(), 1);
            }
        }
        System.out.println("Rank map: " + rankMap);

        // Determine straight
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : rankMap.entrySet()) {
            sb.append(entry.getKey());
        }
        String rankOrder = sb.toString();

        String[] straightsArray = {"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI", "FGHIJ", "GHIJK", "HIJKL", "IJKLM"};
        for(String string : straightsArray){
            if (rankOrder.contains(string)) {
                player.setStraight(true);
                player.setStraightTopRank(string.substring(4));
            }
            // Handle ace low
            if (rankOrder.contains("ABCD") && rankOrder.contains("M") && !player.isStraight()){
                player.setStraight(true);
                player.setStraightTopRank("D");
            }
        }
        // Determine straight flushes
        player.setStraightFlush(player.isFlush() && player.isStraight());
        player.setRoyalStraightFlush(player.isStraightFlush() && player.getStraightTopRank().equals("M"));

        // Print hand strength booleans
        System.out.println("> Royal straight flush: " + player.isRoyalStraightFlush());
        System.out.println("> Straight flush: " + player.isStraightFlush());
        System.out.println("> Flush: " + player.isFlush());
        System.out.println("> Flush suit: " + flushSuit);
        System.out.println("> Flush top rank: " + player.getFlushTopRank());
        System.out.println("> Straight: " + player.isStraight());
        System.out.println("> Straight top rank: " + player.getStraightTopRank());

        System.out.println();

    }

}
