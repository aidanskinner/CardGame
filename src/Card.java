// Aidan Skinner
import javax.swing.*;
import java.awt.*;
public class Card {
    private String suit;
    private String rank;
    private int point;
    private Image x;

    public Card(String suit, String rank, int point, Image x) {
        this.suit = suit;
        this.rank = rank;
        this.point = point;
        this.x = x;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    // Returns the image of the card
    public Image getImage() {
        return this.x;
    }
}
