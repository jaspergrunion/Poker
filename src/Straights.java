import java.util.ArrayList;
import java.util.List;

public class Straights {
    public static List build() {
        List<String> list = new ArrayList<>();
        String[] ranks = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
        for (int i = 0; i < ranks.length - 4; i++) {
            StringBuilder sb = new StringBuilder(5);
            for (int j = i; j < i + 5; j++) {
                sb.append(ranks[j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> straights = Straights.build();
        System.out.println(straights);
    }

}
