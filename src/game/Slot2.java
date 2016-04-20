package game;

import java.awt.*;

public class Slot2 {
    private static final int x = 263;
    private static final int y = 129;
    private Rectangle boundingBox = new Rectangle(73,98);
    private Card currentCard;

    public Slot2(Deck deck) {
        this.currentCard = deck.drawFromDeck();
        this.boundingBox.setBounds(x, y , 73, 98);
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.drawImage(currentCard.getImage(), x, y, null);
    }
}
