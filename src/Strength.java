import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Strength {

//    public static Map rank(Player player) {
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
//        return rankMap;
    }

    //    public static Map rank(Player player) {
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
//        return rankMap;
    }

}
