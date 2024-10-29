import java.util.*;
public class Deck {

    private Card[] deck;
    private static final Random r = new Random();

    private int nowCard;
    private static int cardNum = 52;

    public Deck() {
        Rank[] rank = {Rank.ace, Rank.deuce, Rank.three, Rank.four, Rank.five, Rank.six, Rank.seven, Rank.eight, Rank.nine, Rank.ten, Rank.jack, Rank.queen, Rank.king};
        Suit[] suit = {Suit.clubsGrp, Suit.heartsGrp, Suit.diamondsGrp, Suit.spadesGrp};
        deck = new Card[cardNum];
        nowCard = 0;

        for (int first = 0; first < cardNum; first++) {
            int second = r.nextInt(cardNum);

            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealNxtCard(){
        Card topCard = this.deck[0];

        for(int nowCard = 1; nowCard < cardNum; nowCard++) {
            this.deck[nowCard] = this.deck[nowCard - 1];
        }
        this.deck[cardNum - 1] = null;

        cardNum--;

        return topCard;
    }
}
