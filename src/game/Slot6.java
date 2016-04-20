package game;


import java.awt.*;

public class Slot6 {
    private static final int x = 409;
    private static final int y = 251;
    private Rectangle boundingBox = new Rectangle(73,98);
    private Card currentCard;

    public Slot6(Deck deck) {
        this.currentCard = deck.drawFromDeck();
        this.boundingBox.setBounds(x, y , 73, 98);
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.drawImage(currentCard.getImage(), x, y, null);
    }
}
