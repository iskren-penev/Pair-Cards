package display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String name;
    private int wight, height;

    public Display(String name, int width, int heigth) {
        this.name = name;
        this.wight = width;
        this.height = heigth;

        createDisplay();
    }

    private void createDisplay() {
        this.frame = new JFrame(name);
        this.frame.setPreferredSize(new Dimension(wight, height));
        this.frame.setMaximumSize(new Dimension(wight, height));
        this.frame.setMinimumSize(new Dimension(wight, height));
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setFocusable(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(wight, height));
        this.canvas.setMaximumSize(new Dimension(wight, height));
        this.canvas.setMinimumSize(new Dimension(wight, height));
        this.canvas.setFocusable(true);

        this.frame.add(canvas);
        this.frame.pack();
    }


    public Canvas getCanvas() {
        return this.canvas;
    }
}