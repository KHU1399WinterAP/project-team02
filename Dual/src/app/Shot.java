/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import gui.Board1;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

/**
 *
 * @author Amir reza
 */
public class Shot {
    
    public int x;
    public int y;
    private int dy;
    private BufferedImage image;
    private int directChoose;
    public Shot(int x, int y, BufferedImage image, Board1 game, int directChoose) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.directChoose = directChoose;
        if (this.directChoose == 0) {
                    this.dy = -5;

            
        }
        else{
                    this.dy = 8;
        }
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

    public BufferedImage getImage() {
        return image;
    }

  
    public void move (){
    
    this.y += dy;
    
    }
    public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
    public boolean checkCollision(app.Opponet other) {
		Rectangle myRect = new Rectangle();
		Rectangle otherRect = new Rectangle();  
                System.err.println("shot : " + getX()+" "+getY());
                System.err.println("opponent : " + other.getX()+" "+other.getY());
		myRect.setBounds(x, y, getWidth(), getHeight());
		otherRect.setBounds(other.getX(), other.getY(),
				other.getWidth(), other.getHeight());

		return myRect.intersects(otherRect);
	}
    public boolean checkCollision(app.WarShip other) {
		Rectangle myRect = new Rectangle();
		Rectangle otherRect = new Rectangle();  
                System.err.println("shot : " + getX()+" "+getY());
                System.err.println("ship : " + other.getX()+" "+other.getY());
		myRect.setBounds(x, y, getWidth(), getHeight());
		otherRect.setBounds(other.getX(), other.getY(),
				other.getWidth(), other.getHeight());

		return myRect.intersects(otherRect);
	}
   
}
