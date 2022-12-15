import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] points) {
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < suits.length; i++) {
            for (int j  = 0; j < ranks.length; j++) {
                Card c  = new Card(ranks[j], suits[i], points[j]);
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
