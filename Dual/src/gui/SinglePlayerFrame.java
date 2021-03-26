/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.Board;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Amir reza
 */
public class SinglePlayerFrame extends JFrame{
    
    
    public SinglePlayerFrame() {
        
        initUI();
    }
    
    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(800, 600);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SinglePlayerFrame ex = new SinglePlayerFrame();
            ex.setVisible(true);
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
