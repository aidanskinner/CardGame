// Aidan Skinner
import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
   private Game blackJack;

    private Player p1;
    private Player dealer;
    private final static int WINDOW_WIDTH = 600;
    private final static int WINDOW_HEIGHT = 700;

    private final Image backSideCard;
    private final Image pokerChips;
    public Image[][] cardImages;
    public GameViewer(Player p1, Player dealer, Game BJ) {
        this.blackJack = BJ;
        this.p1 = p1;
        this.dealer = dealer;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Black Jack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        // Creates the flipped over card
        backSideCard = new ImageIcon("Resources/Cards/back.png").getImage();
        pokerChips = new ImageIcon("Resources/chips.png").getImage();
        cardImages = new Image[13][4];
        // Initializes the array of Images in the correct order
        cardImages[0][0] = new ImageIcon("Resources/Cards/1.png").getImage();
        cardImages[0][1] = new ImageIcon("Resources/Cards/2.png").getImage();
        cardImages[0][2] = new ImageIcon("Resources/Cards/3.png").getImage();
        cardImages[0][3] = new ImageIcon("Resources/Cards/4.png").getImage();
        cardImages[1][0] = new ImageIcon("Resources/Cards/5.png").getImage();
        cardImages[1][1] = new ImageIcon("Resources/Cards/6.png").getImage();
        cardImages[1][2] = new ImageIcon("Resources/Cards/7.png").getImage();
        cardImages[1][3] = new ImageIcon("Resources/Cards/8.png").getImage();
        cardImages[2][0] = new ImageIcon("Resources/Cards/9.png").getImage();
        cardImages[2][1] = new ImageIcon("Resources/Cards/10.png").getImage();
        cardImages[2][2] = new ImageIcon("Resources/Cards/11.png").getImage();
        cardImages[2][3] = new ImageIcon("Resources/Cards/12.png").getImage();
        cardImages[3][0] = new ImageIcon("Resources/Cards/13.png").getImage();
        cardImages[3][1] = new ImageIcon("Resources/Cards/14.png").getImage();
        cardImages[3][2] = new ImageIcon("Resources/Cards/15.png").getImage();
        cardImages[3][3] = new ImageIcon("Resources/Cards/16.png").getImage();
        cardImages[4][0] = new ImageIcon("Resources/Cards/17.png").getImage();
        cardImages[4][1] = new ImageIcon("Resources/Cards/18.png").getImage();
        cardImages[4][2] = new ImageIcon("Resources/Cards/19.png").getImage();
        cardImages[4][3] = new ImageIcon("Resources/Cards/20.png").getImage();
        cardImages[5][0] = new ImageIcon("Resources/Cards/21.png").getImage();
        cardImages[5][1] = new ImageIcon("Resources/Cards/22.png").getImage();
        cardImages[5][2] = new ImageIcon("Resources/Cards/23.png").getImage();
        cardImages[5][3] = new ImageIcon("Resources/Cards/24.png").getImage();
        cardImages[6][0] = new ImageIcon("Resources/Cards/25.png").getImage();
        cardImages[6][1] = new ImageIcon("Resources/Cards/26.png").getImage();
        cardImages[6][2] = new ImageIcon("Resources/Cards/27.png").getImage();
        cardImages[6][3] = new ImageIcon("Resources/Cards/28.png").getImage();
        cardImages[7][0] = new ImageIcon("Resources/Cards/29.png").getImage();
        cardImages[7][1] = new ImageIcon("Resources/Cards/30.png").getImage();
        cardImages[7][2] = new ImageIcon("Resources/Cards/31.png").getImage();
        cardImages[7][3] = new ImageIcon("Resources/Cards/32.png").getImage();
        cardImages[8][0] = new ImageIcon("Resources/Cards/33.png").getImage();
        cardImages[8][1] = new ImageIcon("Resources/Cards/34.png").getImage();
        cardImages[8][2] = new ImageIcon("Resources/Cards/35.png").getImage();
        cardImages[8][3] = new ImageIcon("Resources/Cards/36.png").getImage();
        cardImages[9][0] = new ImageIcon("Resources/Cards/37.png").getImage();
        cardImages[9][1] = new ImageIcon("Resources/Cards/38.png").getImage();
        cardImages[9][2] = new ImageIcon("Resources/Cards/39.png").getImage();
        cardImages[9][3] = new ImageIcon("Resources/Cards/40.png").getImage();
        cardImages[10][0] = new ImageIcon("Resources/Cards/41.png").getImage();
        cardImages[10][1] = new ImageIcon("Resources/Cards/42.png").getImage();
        cardImages[10][2] = new ImageIcon("Resources/Cards/43.png").getImage();
        cardImages[10][3] = new ImageIcon("Resources/Cards/44.png").getImage();
        cardImages[11][0] = new ImageIcon("Resources/Cards/45.png").getImage();
        cardImages[11][1] = new ImageIcon("Resources/Cards/46.png").getImage();
        cardImages[11][2] = new ImageIcon("Resources/Cards/47.png").getImage();
        cardImages[11][3] = new ImageIcon("Resources/Cards/48.png").getImage();
        cardImages[12][0] = new ImageIcon("Resources/Cards/49.png").getImage();
        cardImages[12][1] = new ImageIcon("Resources/Cards/50.png").getImage();
        cardImages[12][2] = new ImageIcon("Resources/Cards/51.png").getImage();
        cardImages[12][3] = new ImageIcon("Resources/Cards/52.png").getImage();
    }


    public void paint(Graphics g) {
        // Prints out the green background
        g.setColor(new Color(53, 110, 77));
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.WHITE);
        // Prints out where each hand is on the window
        g.drawString("Your Hand", 275, 650);
        g.drawString("Dealer Hand", 275, 100);
        // Prints the back facing card in the middle
        g.drawImage(backSideCard,275, 300,75, 125, this);
        // Prints out poker chips in the window
        g.drawImage(pokerChips,25,50, 75, 100, this);
        g.drawImage(pokerChips,25,550, 75, 100, this);
        g.drawImage(pokerChips,500,50, 75, 100, this);
        g.drawImage(pokerChips,500,550, 75, 100, this);

        // Calls the draw method
        draw(g);
        // If the dealer wins, print out the dealer won
        if (blackJack.isDealerWin()) {
            g.setColor(Color.WHITE);
            g.drawString("Dealer Wins!", 250,275);
        }
        // If the player wins, print out the player won
        else if (blackJack.isPlayerWin()) {
            g.setColor(Color.WHITE);
            g.drawString("Player Wins!", 250, 275);
        }
        // Prints out that the game is a tie
        else if (blackJack.isGameTie()) {
            g.setColor(Color.WHITE);
            g.drawString("Tie Game!", 250, 275);
        }
    }

    public void draw(Graphics g) {
        // Starting x and y values for each the player and dealer cards
        int startingXP = 200;
        int startingYP = 450;
        int startingXD = 200;
        int startingYD = 150;
        // Gets the cards from the player and draws the cards
        for (int i = 0; i < p1.getHand().size(); i ++) {
            g.drawImage(p1.getHand().get(i).getImage(), startingXP, startingYP,75,100, this);
            startingXP += 75;
        }
        // Gets the cards from the dealer and draws the cards
        for (int i = 0; i < dealer.getHand().size(); i ++) {
            g.drawImage(dealer.getHand().get(i).getImage(), startingXD, startingYD,75,100, this);
            startingXD += 75;
        }
    }
}
