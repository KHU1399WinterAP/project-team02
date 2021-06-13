/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import gui.Login;
import gui.Register;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Amir reza
 */
public class WarShip {
    private User activeUser = Database.getUser((Login.userName == null) ? Register.userName : Login.userName);
    public int dx;
    public int dy;
    public int x = 170;
    public int y = 290;
    private int w;
    private int h;
    private Image image;

    public WarShip() {

        System.err.println(activeUser);
        loadImage();
    }

    private void loadImage() {

        ImageIcon icon; 
        switch(activeUser.getCharacterId()){
        case 1 -> {
            icon = new ImageIcon(getClass().getResource(Links.BASECHARACTERICON + Links.CHARACTER1));
            image = icon.getImage();
            }
        case 2 -> {
            icon = new ImageIcon(getClass().getResource(Links.BASECHARACTERICON + Links.CHARACTER2));
            image = icon.getImage();
            }
        case 3 -> {
            icon = new ImageIcon(getClass().getResource(Links.BASECHARACTERICON + Links.CHARACTER3));
            image = icon.getImage();
            }
        case 4 -> {
            icon = new ImageIcon(getClass().getResource(Links.BASECHARACTERICON + Links.CHARACTER4));
            image = icon.getImage();
            }
        case 5 -> {
            icon = new ImageIcon(getClass().getResource(Links.BASECHARACTERICON + Links.CHARACTER5));
            image = icon.getImage();
            }
        case 6 -> {
            icon = new ImageIcon(getClass().getResource(Links.BASECHARACTERICON + Links.CHARACTER6));
            image = icon.getImage();
            }
        
        }


        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {

        x += dx;
        y += dy;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }

    public Image getImage() {

        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -4;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 4;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -4;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 4;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

   
}
