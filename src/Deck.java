import java.util.*;
public class Deck {

    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        Rank[] rank = {Rank.Ace, Rank.Deuce, Rank.Three, Rank.Four, Rank.Five, Rank.Six, Rank.Seven, Rank.Eight, Rank.Nine, Rank.Ten, Rank.Jack, Rank.Queen, Rank.King};
        Suit[] suit = {Suit.Hearts, Suit.Spades, Suit.Diamonds, Suit.Clubs};

        for (Suit s : suit) {
            for (Rank r : rank) {
                cards.add(new Card(r, s));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(i + 1);
            sb.append('/');
            sb.append(cards.size());
            sb.append(' ');
            sb.append(cards.get(i));
            sb.append('\n');
        }
        return sb.toString();
    }
}