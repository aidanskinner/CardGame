import java.util.ArrayList;
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

    public void addCard(Card name)
    {
        hand.add(name);
    }

    public String toString(){
        return name +" has " + points +"points\n" + name + "’s cards: " + hand;
    }
}

