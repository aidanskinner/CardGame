import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Player dealer;
    private Player p1;
    private Deck d1;

    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public Game() {
        p1 = new Player("Player 1");
        dealer = new Player("Dealer");
        d1 = new Deck(ranks, suits, points);
    }

    public void printInstructions() {
        System.out.println("This Game is Black Jack. The goal of the game is to get as close to 21 with cards, but " +
                "without going over 21, busting. You will be competing against the dealer. Good Luck!");
    }

    public void playGame() {
        Scanner s = new Scanner(System.in);
        printInstructions();
        //shuffles deck
        d1.shuffle();
        // Gives 2 cards to player and dealer and prints out values
        p1.addCard(d1.deal());
        p1.addCard(d1.deal());
        dealer.addCard(d1.deal());
        dealer.addCard(d1.deal());

        System.out.println(p1);
        System.out.println(dealer);
        // checks to see if their point count is over 21, and asks to hit or stay
        while (p1.totalPoints() < 21) {
            System.out.println("Player 1: Hit or Stay?");
            if (s.nextLine().equals("Hit")) ;
            {
                p1.addCard(d1.deal());
                System.out.println(p1);
            }
        }
        // if the dealer is lower than 17, add a card
        while (dealer.totalPoints() < 17) {
                dealer.addCard(d1.deal());
        }
        // if player gets 21, they win
        if (p1.totalPoints() == 21) {
            System.out.println("Player 1 wins with " + p1.totalPoints() + "!");
        }
        // lose if they bust
        else if(p1.totalPoints() > 21) {
            System.out.println("Player 1 bust, so the dealer wins!");
        }
        // tie scenario
        else if (dealer.totalPoints() == p1.totalPoints()) {
            System.out.println("Game was a tie!");
        }

        else if (dealer.totalPoints() < p1.totalPoints()) {
            System.out.println("Player 1 wins with " + p1.totalPoints() + "!");
        }

        else if (dealer.totalPoints() > p1.totalPoints()) {
            System.out.println("The dealer wins with " + dealer.totalPoints() + "!");
        }
    }

        public static void main (String[] args){
            Game n = new Game();
            n.playGame();
        }
    }
