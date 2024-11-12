import java.util.*;
public class Player {
    private final String username;
    private final ArrayList<Card> playerHand;

    public Player(String name){
        this.username = name;
        playerHand = new ArrayList<>();
    }

    public String getUsername(){
        return username;
    }

    public void addCard(Card card){
        playerHand.add(card);
    }

    public int getHandSum(){
        int totHandSum = 0;
        for(Card card: playerHand){
            totHandSum += card.getRank().getRankValue();
        }
        return totHandSum;
    }

    public boolean getPlayerHand(boolean hideCards){
        System.out.println(STR."\{this.username}'s current hand.");
        for(int c = 0; c < playerHand.size(); c++){
            if(c == 0 && !hideCards){
                System.out.println("[Hidden card]");
            } else {
                System.out.println(STR."\{playerHand.get(c).toString()}---------------------\n");
            }
        }
        return hideCards;
    }

    public Card getLastDrawnCard() {
        return playerHand.getLast();
    }
}
