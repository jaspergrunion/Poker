import java.util.*;

public class Hand {

    public static void evaluate(Player player) {

        // Count by ranks
        TreeMap<String, Integer> rankMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), rankMap.get(card.getRank()) + 1);
            } else {
                rankMap.put(card.getRank(), 1);
            }
        }
        System.out.println(rankMap);

        // Determine straight
        Set<String> keys = rankMap.keySet();
        StringBuilder sb = new StringBuilder();
        String[] keyArray = keys.toArray(new String[keys.size()]);
        for (int i = 0; i < keyArray.length; i++) {
            sb.append(keyArray[i]);
        }
        String cardOrder = sb.toString();
        System.out.println(cardOrder);

        String[] straightsArray = {"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI", "FGHIJ", "GHIJK", "HIJKL", "IJKLM"};
        boolean hasStraight = false;
        for(String string : straightsArray){
            if (cardOrder.contains(string) || (cardOrder.contains("ABCD") && cardOrder.contains("M"))) {
                hasStraight = true;
            }
        }
        if(hasStraight){
            player.setStraight(true);
            System.out.println("Player has a straight!");
        }

        // Determine flush
        TreeMap<String, Integer> suitMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (suitMap.containsKey(card.getSuit())) {
                suitMap.put(card.getSuit(), suitMap.get(card.getSuit()) + 1);
            } else {
                suitMap.put(card.getSuit(), 1);
            }
        }
        System.out.println(suitMap);
        System.out.println();
    }

}
