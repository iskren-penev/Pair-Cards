package game;


import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Card {
    private String cardSuit;
    private int cardValue;
    private int width, height;
    private BufferedImage image;
    private boolean isPlayed;
    private Rectangle boundingBox;

    public Card(String name, int value, BufferedImage image) {
        this.cardSuit = name;
        this.cardValue = value;
        this.image = image;
        this.width = 73;
        this.height = 98;
        this.boundingBox = new Rectangle(this.width, this.height);
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public int getCardValue() {
        return cardValue;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }

    /*public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(Assets.diamondsA, 300, 400, null);
    }*/
}
