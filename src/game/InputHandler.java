package game;


import display.Display;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputHandler implements MouseListener {
    public InputHandler(Display display) {
        display.getCanvas().addMouseListener(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int pressed = MouseEvent.MOUSE_CLICKED;
        Rectangle r= new Rectangle(e.getX(), e.getY(), 30, 30);
    }

}
