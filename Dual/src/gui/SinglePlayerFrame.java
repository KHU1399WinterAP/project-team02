/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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

        add(new Board1());

        setTitle("Moving sprite");
        setSize(800, 600);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SinglePlayerFrame ex = new SinglePlayerFrame();
            ex.setVisible(true);
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
