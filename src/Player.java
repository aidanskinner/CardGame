// Aidan Skinner
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int points;
    private String name;

    public Player(String name)
    {
        this.name = name;
        this.points = 0;
    }
    public Player(String name, ArrayList<Card> hand)
    {
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public int getPoints() {
        return this.points;
    }

    public String getName() {
        return this.name;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    // Used to get the points the dealer and player receives
    public int totalPoints() {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getPoint();
        }
        return total;
    }

    public void addCard(Card name)
    {
        hand.add(name);

    }

    public String toString(){
        return name +" has " + totalPoints() +" points\n" + name + "’s cards: " + hand;
    }
}

