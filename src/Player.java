import javax.smartcardio.Card;
import java.util.*;
public class Player {
    private String username;
    private int playerNumOfCards;
    ArrayList<Card> playerHand;

    public Player(String name){
        this.username = name;
        playerHand = new ArrayList<Card>();
    }

    public String getUsername(){
        return username;
    }

    public void addCard(Card card){
        playerHand.add(card);
        this.playerNumOfCards++;
    }

    public int getHandSum(){
        int totSum = 0;
        for(Card countSum: playerHand){
            totSum = totSum + countSum.getRank();
        }
        return totSum;
    }

    public void getPlayerHand(boolean hideCards){
        System.out.println(this.username + "'s current hand.");
        for(int c = 0; c < playerNumOfCards; c++){
            if(c == 0 && !hideCards){
                System.out.println("[Hidden card]");
            } else {
                System.out.println(playerHand.get(c).toString());
            }
        }
    }
}
