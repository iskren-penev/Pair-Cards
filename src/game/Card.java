package game;


import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Card {
    private int cardSuit;
    private int cardValue;
    private int width, height;
    private BufferedImage image;
    private Rectangle boundingBox;

    public Card(int name, int value, BufferedImage image) {
        this.cardSuit = name;
        this.cardValue = value;
        this.image = image;
        this.width = 73;
        this.height = 98;
        this.boundingBox = new Rectangle(this.width, this.height);
    }

    public int getCardSuit() {
        return cardSuit;
    }

    public int getCardValue() {
        return cardValue;
    }

    public BufferedImage getImage() {
        return image;
    }




}
