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

        // Create list of cards with flush cards only
        List<Card> flushCards = new ArrayList<>();
        for (Card card : player.getCards()) {
            if (card.getSuit().equals(flushSuit)){
                flushCards.add(card);
            }
        }
        System.out.println(flushCards);

        TreeMap<String, Integer> rankFlushMap = new TreeMap<>();
        for (Card card : flushCards) {
            if (rankFlushMap.containsKey(card.getRankHidden())) {
                rankFlushMap.put(card.getRankHidden(), rankFlushMap.get(card.getRankHidden()) + 1);
            } else {
                rankFlushMap.put(card.getRankHidden(), 1);
            }
        }
        System.out.println("Rank flush map: " + rankFlushMap);

        StringBuilder sbf = new StringBuilder();
        for (Map.Entry<String, Integer> entry : rankFlushMap.entrySet()) {
            sbf.append(entry.getKey());
        }
        String rankFlushOrder = sbf.reverse().toString();
        System.out.println(rankFlushOrder);

        // Flush top rank
        String flushTopRank = "";
        String flushBottomRank = "";
        flushTopRank = rankFlushOrder.substring(0,1);
        flushBottomRank = rankFlushOrder.substring(4, 5);
        player.setFlushTopRank(flushTopRank);
        player.setFlushBottomRank(flushBottomRank);

        // Counts by rank
        TreeMap<String, Integer> rankMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (rankMap.containsKey(card.getRankHidden())) {
                rankMap.put(card.getRankHidden(), rankMap.get(card.getRankHidden()) + 1);
            } else {
                rankMap.put(card.getRankHidden(), 1);
            }
        }
        System.out.println("Rank map: " + rankMap);

        // Determine straights and multiples
        StringBuilder sbr = new StringBuilder();
        for (Map.Entry<String, Integer> entry : rankMap.entrySet()) {
            sbr.append(entry.getKey());
            if (entry.getValue() == 4){
                player.setFours(true);
                player.setFoursRank(entry.getKey());
            }
            if (entry.getValue() == 3){
                player.setThrees(true);
                player.setThreesRank(entry.getKey());
            }
        }
        String rankOrder = sbr.toString();
        System.out.println(rankOrder);

        String[] straightsArray = {"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI", "FGHIJ", "GHIJK", "HIJKL", "IJKLM"};
        for(String string : straightsArray){
            if (rankOrder.contains(string)) {
                player.setStraight(true);
                player.setStraightTopRank(string.substring(4, 5));
                player.setStraightBottomRank(string.substring(0, 1));
            }
            // Handle ace low
            if (rankOrder.contains("ABCD") && rankOrder.contains("M") && !player.isStraight()){
                player.setStraight(true);
                player.setStraightTopRank("D");
            }
        }

        // Determine straight flushes
        // This is broken
        player.setStraightFlush(player.isFlush() && player.isStraight() &&
                player.getFlushTopRank().equals(player.getStraightTopRank()) &&
                player.getFlushBottomRank().equals(player.getStraightBottomRank()));
        player.setRoyalStraightFlush(player.isStraightFlush() && player.getStraightTopRank().equals("M"));

        // Print hand strength booleans
        System.out.println("> Royal straight flush: " + player.isRoyalStraightFlush());
        System.out.println("> Straight flush: " + player.isStraightFlush());
        System.out.println("> Four of a kind: " + player.isFours());
        System.out.println("> Fours rank: " + player.getFoursRank());
        System.out.println("> Flush: " + player.isFlush());
        System.out.println("> Flush suit: " + flushSuit);
        System.out.println("> Flush top rank: " + player.getFlushTopRank());
        System.out.println("> Flush bottom rank: " + player.getFlushBottomRank());
        System.out.println("> Straight: " + player.isStraight());
        System.out.println("> Straight top rank: " + player.getStraightTopRank());
        System.out.println("> Straight bottom rank: " + player.getStraightBottomRank());
        System.out.println("> Three of a kind: " + player.isThrees());
        System.out.println("> Threes rank: " + player.getThreesRank());

        System.out.println();

    }

}
