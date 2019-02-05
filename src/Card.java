class Card {

    private String rank;
    private String rankDisplay;
    private String suit;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankDisplay() {
        return rankDisplay;
    }

    public void setRankDisplay(String rankDisplay) {
        this.rankDisplay = rankDisplay;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "{" + rankDisplay + " of " + suit + "}";
    }
}
