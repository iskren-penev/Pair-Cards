package game;

import display.Display;
import graphics.Assets;
import graphics.ImageLoader;
import graphics.SpriteSheet;
import states.StateManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.*;

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
    private InputHandler inputHandler;
    public static Deck cardDeck;
    public static Slot1 slot1;
    public static Slot2 slot2;
    public static Slot3 slot3;
    public static Slot4 slot4;
    public static Slot5 slot5;
    public static Slot6 slot6;
    public static Slot7 slot7;
    public static Slot8 slot8;
    public static Slot9 slot9;




    private int score = 0;


    public Game(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;

    }

    public void init() {
        this.display = new Display(this.name, this.width, this.height);
        this.background = ImageLoader.loadImage("/background2.jpg");
        this.sh = new SpriteSheet(ImageLoader.loadImage("/classic-playing-cards.png"));

        this.inputHandler = new InputHandler(this.display);


        Assets.init();

        cardDeck= new Deck();
        slot1 = new Slot1(cardDeck);
        slot2 = new Slot2(cardDeck);
        slot3 = new Slot3(cardDeck);
        slot4 = new Slot4(cardDeck);
        slot5 = new Slot5(cardDeck);
        slot6 = new Slot6(cardDeck);
        slot7 = new Slot7(cardDeck);
        slot8 = new Slot8(cardDeck);
        slot9 = new Slot9(cardDeck);

    }

    public void tick() {
        int[] value = new int[2];



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

        slot1.render(g);
        slot2.render(g);
        slot3.render(g);
        slot4.render(g);
        slot5.render(g);
        slot6.render(g);
        slot7.render(g);
        slot8.render(g);
        slot9.render(g);

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
}