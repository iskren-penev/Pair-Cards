package game;

import display.Display;
import graphics.ImageLoader;
import states.StateManager;

import java.awt.*;
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

    public Game(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;

    }

    public void init() {
        this.display = new Display(this.name, this.width, this.height);
        background = ImageLoader.loadImage("/background laurie-filtered.jpg");

    }

    public void tick() {
        if (StateManager.getState() != null) {
            StateManager.getState().tick();
        }
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
        if (isRunning){
            return;
        }
        this.isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!isRunning){
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}