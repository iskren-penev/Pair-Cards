package game;

import graphics.Assets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by TenYo on 4/18/16.
 */
public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        int index1, index2;

        Random genRandom = new Random();
        Card temp;
        int b = 1;
        for (int i = 1; i <= 52; i++) {
            cards.add(new Card(i, b, Assets.images.get(b - 1)));
            b++;
        }
        int size;

        for (int i = 0; i < 100; i++) {
            index1 = genRandom.nextInt(cards.size() - 1);
            index2 = genRandom.nextInt(cards.size() - 1);

            temp = cards.get(index2);
            cards.set(index2, cards.get(index1));
            cards.set(index1, temp);
        }
        Collections.shuffle(cards);
    }

    public Card drawFromDeck() {
        if (cards.size() != 0) {
            return cards.remove(cards.size() - 1);
        } else { //draw Joker when there are no more cards in the deck
            return new Card(5, 14, Assets.joker);
        }
    }
}