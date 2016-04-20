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
        Rectangle mouseClick = new Rectangle(e.getX(), e.getY(), 30, 30);
        if (Game.slot1.isChosen(mouseClick)) {
            Game.slot1.isClicked = true;
        } else if (Game.slot2.isChosen(mouseClick)) {
            Game.slot2.isClicked = true;
        } else if (Game.slot3.isChosen(mouseClick)) {
            Game.slot3.isClicked = true;
        } else if (Game.slot4.isChosen(mouseClick)) {
            Game.slot4.isClicked = true;
        } else if (Game.slot5.isChosen(mouseClick)) {
            Game.slot5.isClicked = true;
        } else if (Game.slot6.isChosen(mouseClick)) {
            Game.slot6.isClicked = true;
        } else if (Game.slot7.isChosen(mouseClick)) {
            Game.slot7.isClicked = true;
        } else if (Game.slot8.isChosen(mouseClick)) {
            Game.slot8.isClicked = true;
        } else if (Game.slot9.isChosen(mouseClick)) {
            Game.slot9.isClicked = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Rectangle mouseClick = new Rectangle(e.getX(), e.getY(), 30, 30);
        if (Game.slot1.isChosen(mouseClick)) {
            Game.slot1.isClicked = true;
        } else if (Game.slot2.isChosen(mouseClick)) {
            Game.slot2.isClicked = true;
        } else if (Game.slot3.isChosen(mouseClick)) {
            Game.slot3.isClicked = true;
        } else if (Game.slot4.isChosen(mouseClick)) {
            Game.slot4.isClicked = true;
        } else if (Game.slot5.isChosen(mouseClick)) {
            Game.slot5.isClicked = true;
        } else if (Game.slot6.isChosen(mouseClick)) {
            Game.slot6.isClicked = true;
        } else if (Game.slot7.isChosen(mouseClick)) {
            Game.slot7.isClicked = true;
        } else if (Game.slot8.isChosen(mouseClick)) {
            Game.slot8.isClicked = true;
        } else if (Game.slot9.isChosen(mouseClick)) {
            Game.slot9.isClicked = true;
        }

    }

}
