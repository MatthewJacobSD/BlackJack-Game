import java.util.Scanner;
public class BlackJackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        String input;

        //Ask for username
        System.out.println("@@What username would you like?@@");
        input = scanner.nextLine();
        username = input;

        //Main Game Loop
        boolean gameStatus = true;
        while (gameStatus) {

            //Reset function
            boolean gameEnded = false;

            //Game welcoming message
            System.out.println("\n~~~Welcome to BlackJack~~~\nA new game has begun\n");

            //Player & dealer set up
            Player p = new Player(username);
            Player d = new Player("Dealer");
            Deck deck = new Deck();
            deck.shuffle();

            //Give cards to player
            p.addCard(deck.draw());
            p.addCard(deck.draw());
            System.out.println(p.getPlayerHand(false));

            //Give cards to dealer
            d.addCard(deck.draw());
            d.addCard(deck.draw());
            System.out.println(d.getPlayerHand(true));

            //Start game
            do {
                //Player turn
                do {
                    System.out.println(STR."Would you like to bust or stay, \{p.getUsername()}?\n'Bust / Stay'");
                    input = scanner.nextLine();
                } while (!input.equalsIgnoreCase("Bust") && !input.equalsIgnoreCase("Stay"));

                //Player choose bust
                if (input.equalsIgnoreCase("Bust")) {
                    p.addCard(deck.draw());
                    Card playerDrawnCard = p.getLastDrawnCard();
                    System.out.println(STR."\{p.getUsername()} drew a card.\n - \{playerDrawnCard.toString()}");
                    if (p.getHandSum() > 21) {
                        System.out.println(STR."You busted and got a total of \{p.getHandSum()}");
                        gameEnded = true;
                    }
                }

                //Player choose stay
                if (input.equalsIgnoreCase("Stay")) {
                    System.out.println(STR."You have chosen to stay. Your hand \{p.getHandSum()}");
                }
            } while (input.equalsIgnoreCase("Bust") && !gameEnded);

            //Dealer turn
            if (!gameEnded) {
                System.out.println("Dealer turn");
                System.out.println(p.getPlayerHand(false));
            }

            while (!gameEnded) {
                if (d.getHandSum() <= 15) {

                    //Draw card
                    d.addCard(deck.draw());
                    Card dealerDrawnCard = d.getLastDrawnCard();
                    System.out.println(STR."\{d.getUsername()} drew another card - \{dealerDrawnCard.toString()}");
                    System.out.println(p.getPlayerHand(false));

                    //Dealer won
                    if (d.getHandSum() == 15) {
                        System.out.println("BlackJack! Dealer won.");
                    }

                    //Player won
                    if (d.getHandSum() > 21) {
                        System.out.println(STR."Dealer busted and got a total of \{d.getHandSum()}. \{p.getUsername()} wins the match!");
                    }
                } else {

                    //Dealer choose to stay
                    System.out.println("Dealer choose to stay");
                    int totDealerSum = d.getHandSum();
                    int totPlayerSum = p.getHandSum();

                    if (totDealerSum > totPlayerSum) {
                        System.out.println(STR."Both players has decided to stay. The winner is \{d.getUsername()} with a  total of \{totDealerSum}.");
                    } else {
                        System.out.println(STR."Both players has decided to stay. The winner is \{p.getUsername()} with a  total of \{totPlayerSum}.");
                    }
                }
                gameEnded = true;
            }

            //Start new game
            System.out.println(STR."\nWould you like to start a new game?...\n'Yes/No'");
            do {
                input = scanner.nextLine();
            } while (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));

            //Tiding Up
            if (input.equalsIgnoreCase("Yes")) {
                System.out.println("*******Cleaning the board*******\nStarting a new game");
            } else {
                System.out.println("@@Thank you for playing BlackJack!@@");
                gameStatus = false;
            }
        }
        scanner.close();
    }
}
