public class Card {
    private final Rank rank;
    private final Suit suit;
    int tot = 0;

    public Card(Rank cardRank, Suit cardSuit){
        this.rank = cardRank;
        this.suit = cardSuit;
    }

    public int getRank(){
        return rank.getRankValue();
    }

    public String getSuit(){
        return suit.getSuitGroup();
    }

    public String toString(){
        return rank + " of " + suit;
    }
}
