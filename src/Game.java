import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    private Player p1;
    private Deck d1;

    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public Game(String name) {
        p1 = new Player(name);
        d1 = new Deck(ranks, suits, points);
    }
    public void printInstructions() {
        System.out.println("This Game is Black Jack. The goal of the game is to  ");
    }

    public void playGame() {
        printInstructions();



    }

    public static void main(String[] args) {
        Game n = new Game("Aidan");
        n.playGame();
    }
}
