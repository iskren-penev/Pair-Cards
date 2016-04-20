package game;


import java.awt.*;

public class Slot1 {
    private static final int x = 117;
    private static final int y = 129;
    private Rectangle boundingBox = new Rectangle(73,98);
    private Card currentCard;


    public Slot1(Deck deck) {
        this.currentCard = deck.drawFromDeck();
        this.boundingBox.setBounds(x, y , 73, 98);
    }

    public boolean isClicked(Rectangle r){
        if (this.boundingBox.contains(r)|| r.contains(this.boundingBox)){
            return true;
        }
        return false;
    }

    public void tick(){


    }
    public void render(Graphics g){
        g.drawImage(currentCard.getImage(), x, y, null);
    }
}
