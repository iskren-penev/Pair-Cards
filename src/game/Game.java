package game;

import display.Display;
import graphics.Assets;
import graphics.ImageLoader;
import graphics.SpriteSheet;
import states.StateManager;

import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.util.List;

public class Game implements Runnable {
    private String name;
    private int width, height;

    private boolean isRunning = false;
    private Thread thread;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage background;
    private SpriteSheet sh;
    public static List<Card> gameCards = new ArrayList<>();


    public Game(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;

    }

    public void init() {
        this.display = new Display(this.name, this.width, this.height);
        this.background = ImageLoader.loadImage("/background2.jpg");
        this.sh = new SpriteSheet(ImageLoader.loadImage("/classic-playing-cards.png"));
        Assets.init();
        fillTheList(gameCards);


    }

    public void tick() {
        if (StateManager.getState() != null) {
            StateManager.getState().tick();
        }

        //cardtodraw.tick();
    }

    public void render() {
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs == null) {
            this.display.getCanvas().createBufferStrategy(2);
            this.bs = this.display.getCanvas().getBufferStrategy();
        }

        this.g = this.bs.getDrawGraphics();
        /*clear the screen at every frame*/
        this.g.clearRect(0, 0, this.width, this.height);

        g.drawImage(background, 0, 0, this.width, this.height, null);
        /*try the drawing of the cards in the right positions*/
        g.drawImage(gameCards.get(2).getImage(), 117, 129, null);
        gameCards.get(2).setPlayed(true);
        g.drawImage(gameCards.get(18).getImage(), 263, 129, null);
        gameCards.get(18).setPlayed(true);
        g.drawImage(gameCards.get(9).getImage(), 409, 129, null);
        gameCards.get(9).setPlayed(true);
        g.drawImage(gameCards.get(87).getImage(), 409, 251, null);
        gameCards.get(87).setPlayed(true);
        g.drawImage(gameCards.get(69).getImage(), 117, 251, null);
        gameCards.get(69).setPlayed(true);
        g.drawImage(gameCards.get(101).getImage(), 263, 251, null);
        gameCards.get(101).setPlayed(true);
        g.drawImage(gameCards.get(36).getImage(), 117, 373, null);
        gameCards.get(36).setPlayed(true);
        g.drawImage(gameCards.get(48).getImage(), 263, 373, null);
        gameCards.get(48).setPlayed(true);
        g.drawImage(gameCards.get(81).getImage(), 409, 373, null);
        gameCards.get(81).setPlayed(true);


        if (StateManager.getState() != null) {
            StateManager.getState().render(this.g);
        }
        bs.show();
        g.dispose();

    }

    @Override
    public void run() {
        this.init();

        int fps = 30;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1_000_000_000) {
                System.out.println("Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        this.stop();
    }

    public synchronized void start() {
        if (isRunning) {
            return;
        }
        this.isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*fill the list with the cards from 2 decks - add each suit twice*/
    public static void fillTheList(List<Card> list) {
        /*1 set of spades*/
        list.add(new Card("spadesA1", 1, Assets.spadesA));
        list.add(new Card("spades21", 2, Assets.spades2));
        list.add(new Card("spades31", 3, Assets.spades3));
        list.add(new Card("spades41", 4, Assets.spades4));
        list.add(new Card("spades51", 5, Assets.spades5));
        list.add(new Card("spades61", 6, Assets.spades6));
        list.add(new Card("spades71", 7, Assets.spades7));
        list.add(new Card("spades81", 8, Assets.spades8));
        list.add(new Card("spades91", 9, Assets.spades9));
        list.add(new Card("spades101", 10, Assets.spades10));
        list.add(new Card("spadesJ1", 11, Assets.spadesJ));
        list.add(new Card("spadesQ1", 12, Assets.spadesQ));
        list.add(new Card("spadesK1", 13, Assets.spadesK));
        /*2 set of spades*/
        list.add(new Card("spadesA2", 1, Assets.spadesA));
        list.add(new Card("spades22", 2, Assets.spades2));
        list.add(new Card("spades32", 3, Assets.spades3));
        list.add(new Card("spades42", 4, Assets.spades4));
        list.add(new Card("spades52", 5, Assets.spades5));
        list.add(new Card("spades62", 6, Assets.spades6));
        list.add(new Card("spades72", 7, Assets.spades7));
        list.add(new Card("spades82", 8, Assets.spades8));
        list.add(new Card("spades92", 9, Assets.spades9));
        list.add(new Card("spades102", 10, Assets.spades10));
        list.add(new Card("spadesJ2", 11, Assets.spadesJ));
        list.add(new Card("spadesQ2", 12, Assets.spadesQ));
        list.add(new Card("spadesK3", 13, Assets.spadesK));
        /*1 set of clubs*/
        list.add(new Card("clubsA1", 1, Assets.clubsA));
        list.add(new Card("clubs21", 2, Assets.clubs2));
        list.add(new Card("clubs31", 3, Assets.clubs3));
        list.add(new Card("clubs41", 4, Assets.clubs4));
        list.add(new Card("clubs51", 5, Assets.clubs5));
        list.add(new Card("clubs61", 6, Assets.clubs6));
        list.add(new Card("clubs71", 7, Assets.clubs7));
        list.add(new Card("clubs81", 8, Assets.clubs8));
        list.add(new Card("clubs91", 9, Assets.clubs9));
        list.add(new Card("clubs101", 10, Assets.clubs10));
        list.add(new Card("clubsJ1", 11, Assets.clubsJ));
        list.add(new Card("clubsQ1", 12, Assets.clubsQ));
        list.add(new Card("clubsK1", 13, Assets.clubsK));
        /*2 set of clubs*/
        list.add(new Card("clubsA2", 1, Assets.clubsA));
        list.add(new Card("clubs22", 2, Assets.clubs2));
        list.add(new Card("clubs32", 3, Assets.clubs3));
        list.add(new Card("clubs42", 4, Assets.clubs4));
        list.add(new Card("clubs52", 5, Assets.clubs5));
        list.add(new Card("clubs62", 6, Assets.clubs6));
        list.add(new Card("clubs72", 7, Assets.clubs7));
        list.add(new Card("clubs82", 8, Assets.clubs8));
        list.add(new Card("clubs92", 9, Assets.clubs9));
        list.add(new Card("clubs102", 10, Assets.clubs10));
        list.add(new Card("clubsJ2", 11, Assets.clubsJ));
        list.add(new Card("clubsQ2", 12, Assets.clubsQ));
        list.add(new Card("clubsK2", 13, Assets.clubsK));
        /*1 set of diamonds*/
        list.add(new Card("diamondA1", 1, Assets.diamondsA));
        list.add(new Card("diamond21", 2, Assets.diamonds2));
        list.add(new Card("diamond31", 3, Assets.diamonds3));
        list.add(new Card("diamond41", 4, Assets.diamonds4));
        list.add(new Card("diamond51", 5, Assets.diamonds5));
        list.add(new Card("diamond61", 6, Assets.diamonds6));
        list.add(new Card("diamond71", 7, Assets.diamonds7));
        list.add(new Card("diamond81", 8, Assets.diamonds8));
        list.add(new Card("diamond91", 9, Assets.diamonds9));
        list.add(new Card("diamond101", 10, Assets.diamonds10));
        list.add(new Card("diamondJ1", 11, Assets.diamondsJ));
        list.add(new Card("diamondQ1", 12, Assets.diamondsQ));
        list.add(new Card("diamondK1", 13, Assets.diamondsK));
        /*2 set of diamonds*/
        list.add(new Card("diamondA2", 1, Assets.diamondsA));
        list.add(new Card("diamond22", 2, Assets.diamonds2));
        list.add(new Card("diamond32", 3, Assets.diamonds3));
        list.add(new Card("diamond42", 4, Assets.diamonds4));
        list.add(new Card("diamond52", 5, Assets.diamonds5));
        list.add(new Card("diamond62", 6, Assets.diamonds6));
        list.add(new Card("diamond72", 7, Assets.diamonds7));
        list.add(new Card("diamond82", 8, Assets.diamonds8));
        list.add(new Card("diamond92", 9, Assets.diamonds9));
        list.add(new Card("diamond102", 10, Assets.diamonds10));
        list.add(new Card("diamondJ2", 11, Assets.diamondsJ));
        list.add(new Card("diamondQ2", 12, Assets.diamondsQ));
        list.add(new Card("diamondK2", 13, Assets.diamondsK));
        /*1 set of hearts*/
        list.add(new Card("heartA1", 1, Assets.heartsA));
        list.add(new Card("heart21", 2, Assets.hearts2));
        list.add(new Card("heart31", 3, Assets.hearts3));
        list.add(new Card("heart41", 4, Assets.hearts4));
        list.add(new Card("heart51", 5, Assets.hearts5));
        list.add(new Card("heart61", 6, Assets.hearts6));
        list.add(new Card("heart71", 7, Assets.hearts7));
        list.add(new Card("heart81", 8, Assets.hearts8));
        list.add(new Card("heart91", 9, Assets.hearts9));
        list.add(new Card("heart101", 10, Assets.hearts10));
        list.add(new Card("heartJ1", 11, Assets.heartsJ));
        list.add(new Card("heartQ1", 12, Assets.heartsQ));
        list.add(new Card("heartK1", 13, Assets.heartsK));
        /*2 set of hearts*/
        list.add(new Card("heartA2", 1, Assets.heartsA));
        list.add(new Card("heart22", 2, Assets.hearts2));
        list.add(new Card("heart32", 3, Assets.hearts3));
        list.add(new Card("heart42", 4, Assets.hearts4));
        list.add(new Card("heart52", 5, Assets.hearts5));
        list.add(new Card("heart62", 6, Assets.hearts6));
        list.add(new Card("heart72", 7, Assets.hearts7));
        list.add(new Card("heart82", 8, Assets.hearts8));
        list.add(new Card("heart92", 9, Assets.hearts9));
        list.add(new Card("heart102", 10, Assets.hearts10));
        list.add(new Card("heartJ2", 11, Assets.heartsJ));
        list.add(new Card("heartQ2", 12, Assets.heartsQ));
        list.add(new Card("heartK2", 13, Assets.heartsK));
        /*shuffle the cards*/
        Collections.shuffle(list);
    }
}