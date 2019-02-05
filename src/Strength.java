import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Strength {

    public static void rankMap(Player player) {
        TreeMap<String, Integer> rankMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), rankMap.get(card.getRank()) + 1);
            } else {
                rankMap.put(card.getRank(), 1);
            }
        }
        System.out.println(rankMap);
        Set<String> keys = rankMap.keySet();
        String[] keyArray = keys.toArray(new String[keys.size()]);
        for (int i = 0; i < keyArray.length; i++) {
            System.out.print(keyArray[i]);
        }
        System.out.println();
    }

    public static void suitMap(Player player) {
        TreeMap<String, Integer> suitMap = new TreeMap<>();
        for (Card card : player.getCards()) {
            if (suitMap.containsKey(card.getSuit())) {
                suitMap.put(card.getSuit(), suitMap.get(card.getSuit()) + 1);
            } else {
                suitMap.put(card.getSuit(), 1);
            }
        }
        System.out.println(suitMap);
    }

}
