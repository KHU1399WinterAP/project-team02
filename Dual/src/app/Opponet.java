/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.*;
import java.util.Random;
import gui.SinglePlayerJPanel;

/**
 *
 * @author Amir reza
 */
public class Opponet {

    private int x;
    private int y;
    private int dy;
    private int dx;
    private Image image;
    private SinglePlayerJPanel game;
    Random random;

    public Opponet(int x, int y, Image image, SinglePlayerJPanel game) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.game = game;
        random = new Random();
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    // ��������Ʈ�� ���� ���̸� ��ȯ�Ѵ�.
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

    public SinglePlayerJPanel getGame() {
        return game;
    }

    public void move() {

        if (random.nextInt(2) == 0) {
            dy = random.nextInt(6) + 20;
        } else {
            dy = -1 * (random.nextInt(6) + 24);
        }

        if (random.nextInt(2) == 0) {
            dx = random.nextInt(6) + 20;
        } else {
            dx = -1 * (random.nextInt(6) + 24);
        }

        if ((getX() <= 11 && dx < 0 )|| (getX() >= 630 && dx >0)) {
            dx *= -1;
        }
        if ((getY() <= -393 && dy < 0) || (getY() >= -250 && dy > 0)) {
            dy *= -1;
        }
        // game over, if enemy hit the margin line
        //if (y > 600) {
        //	game.endGame();
        //}

        x += dx;
        y += dy;
        /*((dx < 0) && (x < 10)) || ((dx > 0) && (x > 780))
                633) {
                warShip.x = 633;
            }
            if (warShip.getY() > 393 */
    }
}
