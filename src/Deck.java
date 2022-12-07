import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;
    private String[] suits = {}

    public Deck(String[] ranks, String[] suits, int[] points) {
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < suits.length; i++) {
            for (int j  = 0; j < ranks.length; j++) {
                Card c  = new Card(ranks[j], suits[i], points[j]);
                cards.add(c);
            }
        }
        this.cardsLeft = 52;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal (ArrayList<Card> cards) {
        if(isEmpty() == true) {
            shuffle();
        }
        cardsLeft--;
        return cards.get(cardsLeft);
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
