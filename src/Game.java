// Aidan Skinner
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
public class Game {
    private Player dealer;
    private Player p1;
    private Deck d1;

    private static final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    private GameViewer window;
    private boolean dealerWin = false;
    private boolean playerWin = false;

    private boolean gameTie= false;

    public Game() {
        p1 = new Player("Player 1");
        dealer = new Player("Dealer");
        // Creates the backside with the player and dealer as the inputs
        window = new GameViewer(p1, dealer, this);
        d1 = new Deck(ranks, suits, points, window);
    }

    public boolean isGameTie() {
        return gameTie;
    }

    public boolean isDealerWin() {
        return dealerWin;
    }

    public boolean isPlayerWin() {
        return playerWin;
    }

    public void printInstructions() {
        System.out.println("This Game is Black Jack. The goal of the game is to get as close to 21 with cards, but " +
                "without going over 21, busting. You will be competing against the dealer. Good Luck!");
    }

    public void playGame() {
        window.repaint();
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
        window.repaint();
        System.out.println(dealer);
        window.repaint();
        // checks to see if their point count is over 21, and asks to hit or stay
        while (p1.totalPoints() < 21) {
            System.out.println("Player 1: Hit or Stay?");
            if (s.nextLine().equals("Hit") || s.nextLine().equals("hit"))
            {
                p1.addCard(d1.deal());
                System.out.println(p1);
                window.repaint();
            }
            else {
                break;
            }
        }
        // if the dealer is lower than 17, add a card
        while (dealer.totalPoints() < 17) {
                dealer.addCard(d1.deal());
                window.repaint();
        }
        // if player gets 21, they win
        if (p1.totalPoints() == 21) {
            System.out.println("Player 1 wins with " + p1.totalPoints() + "!");
            playerWin = true;
        }
        // lose if they bust
        else if(p1.totalPoints() > 21) {
            System.out.println("Player 1 bust, so the dealer wins!");
            dealerWin = true;
        }
        // tie scenario
        else if (dealer.totalPoints() == p1.totalPoints()) {
            System.out.println("Game was a tie!");
        }

        else if (dealer.totalPoints() < p1.totalPoints()) {
            System.out.println("Player 1 wins with " + p1.totalPoints() + "!");
            playerWin = true;
        }

        else if (dealer.totalPoints() > p1.totalPoints() && (dealer.totalPoints() < 21)) {
            System.out.println("The dealer wins with " + dealer.totalPoints() + "!");
            dealerWin = true;
        }
    }

        public static void main (String[] args){
            Game n = new Game();
            n.playGame();
        }
    }
