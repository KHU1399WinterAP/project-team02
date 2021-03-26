/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

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
public class Board extends JPanel implements ActionListener{
    
    private Timer timer;
    private WarShip warShip;
    private final int DELAY = 10;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener((KeyListener) new TAdapter());
        setBackground(MyColor.black);
	setFocusable(true);

        warShip = new WarShip();

        timer = new Timer(DELAY, this);
        
      //Starts the Timer, causing it to start sending action events to its listeners.  
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
                        this.setBackground(MyColor.black);

        super.paintComponent(g);

        doDrawing(g);
        
       Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(warShip.getImage(), warShip.getX(), 
            warShip.getY(), this);
    }
    
   // @Override
   /// public void actionPerformed(ActionEvent e) {
        
     //  
    //}
    
    private void step() {
                this.setBackground(MyColor.black);

        warShip.move();
        
        repaint(warShip.getX()-1, warShip.getY()-1, 
                warShip.getWidth()+2, warShip.getHeight()+2);     
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
                this.setBackground(MyColor.black);
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
