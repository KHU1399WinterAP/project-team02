/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.MyColor;
import app.WarShip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Amir reza
 */
public class Board1 extends JPanel implements ActionListener {

    private Timer timer;
    private WarShip warShip;
    private final int DELAY = 20;

    public Board1() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener((KeyListener) new TAdapter());
        setBackground(MyColor.black);
        setFocusable(true);
        setSize(800, 600);

        warShip = new WarShip();

        timer = new Timer(DELAY, this);

        //Starts the Timer, causing it to start sending action events to its listeners.  
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        this.setBackground(MyColor.GAMELAYOUTBACKGROUND);

        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(warShip.getImage(), warShip.getX(),
                warShip.getY(), this);
    }

    private void step() {
        this.setBackground(MyColor.black);

        warShip.move();

        repaint(warShip.getX() - 10, warShip.getY() - 10,
                warShip.getWidth() + 2, warShip.getHeight() + 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (warShip.getX() < 0 ) {
            warShip.x = 0;
        }
        if (warShip.getX() > 633) {
            warShip.x = 633;
        }
        if (warShip.getY() > 393) {
            warShip.y = 393;
        }
        
        if (warShip.getY() < 0) {
            warShip.y = 0;
        }
        
        this.setBackground(MyColor.GAMELAYOUTBACKGROUND);
        step();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            warShip.keyReleased(e);

        }

        @Override
        public void keyPressed(KeyEvent e) {
            warShip.keyPressed(e);

        }
    }

}
