// Aidan Skinner
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    private GameViewer x;

    // Uses the gameviewer to get the card images array
    public Deck(String[] ranks, String[] suits, int[] points, GameViewer x) {
        this.x = x;
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                // Creates a new card and adds to the deck with its card image
                Card c  = new Card(ranks[i], suits[j], points[i], x.cardImages[i][j]);
                cards.add(c);
            }
        }
        this.cardsLeft = ranks.length * suits.length;
    }

    public boolean isEmpty() {
        return cardsLeft == 0;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal () {
        if(isEmpty() == true) {
            return null;
        }
        cardsLeft--;
        //Gets card from the top of deck
        return cards.remove(0);
    }
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            Card copy = cards.get(i);
            int randCard = (int) (Math.random() * cards.size());
            cards.set(i, cards.get(randCard));
            cards.set(randCard, copy);
        }
        cardsLeft = cards.size();
    }
}
