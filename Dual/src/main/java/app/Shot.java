/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.app;


import java.awt.*;

/**
 * @author Amir reza
 */
public class Shot {

    public int x;
    public int y;
    private int dy;
    private Image image;
    private int directChoose;

    public Shot(int x, int y, Image image, int directChoose) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.directChoose = directChoose;
        if (this.directChoose == 0) {
            this.dy = -8;


        } else {
            this.dy = 8;
        }
    }

    public int getWidth() {
        return image.getWidth(null);
    }


    public int getHeight() {
        return image.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDy() {
        return dy;
    }

    public Image getImage() {
        return image;
    }


    public void move() {

        this.y += dy;

    }

    public boolean checkCollision(main.java.app.Opponet other) {
        Rectangle myRect = new Rectangle();
        Rectangle otherRect = new Rectangle();
        myRect.setBounds(x, y, getWidth(), getHeight());
        otherRect.setBounds(other.getX(), other.getY(),
                other.getWidth(), other.getHeight());

        return myRect.intersects(otherRect);
    }

    public boolean checkCollision(main.java.app.WarShip other) {
        Rectangle myRect = new Rectangle();
        Rectangle otherRect = new Rectangle();
        myRect.setBounds(x, y, getWidth(), getHeight());
        otherRect.setBounds(other.getX(), other.getY(),
                other.getWidth(), other.getHeight());

        return myRect.intersects(otherRect);
    }

}
