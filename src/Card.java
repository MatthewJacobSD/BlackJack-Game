public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank cardRank, Suit cardSuit){
        this.rank = cardRank;
        this.suit = cardSuit;
    }

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public String toString(){
        return STR."\{rank} of \{suit}\n";
    }
}
