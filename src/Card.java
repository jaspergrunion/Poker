class Card {

    private String rank;
    private String rankHidden;
    private String suit;

    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] ranksHidden = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
        int rankIndex = -1;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i].equals(rank)){
                rankIndex = i;
                break;
            }
        }
        this.rankHidden = ranksHidden[rankIndex];
    }

    public String getRankHidden() {
        return rankHidden;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
//        return "{" + rank + " (" + rankHidden + ")" + " of " + suit + "}";
        return "{" + rank + " of " + suit + "}";
    }
}
