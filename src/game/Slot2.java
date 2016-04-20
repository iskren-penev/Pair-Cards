package game;

import java.awt.*;

public class Slot2 {
    private static final int x = 263;
    private static final int y = 129;
    private Rectangle boundingBox = new Rectangle(73,98);
    private Card currentCard;
    public static boolean isClicked;

    public Slot2(Deck deck) {
        this.currentCard = deck.drawFromDeck();
        this.boundingBox.setBounds(x, y , 73, 98);
        isClicked = false;
    }

    public boolean isChosen(Rectangle r){
        if (this.boundingBox.contains(r)|| r.contains(this.boundingBox)){
            return true;
        }
        return false;
    }
    public int getValue() {
        return currentCard.getCardValue();
    }

    public void tick(Deck deck){
        this.currentCard = deck.drawFromDeck();

    }
    public void render(Graphics g){
        g.drawImage(currentCard.getImage(), x, y, null);
    }
}
