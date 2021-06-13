/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

/**
 *
 * @author Amir reza
 */
public class SinglePlayerFrame extends JFrame{
    private Clip clip;
    private AudioInputStream audioInputStream;
    private File audioFile;
    private JFrame frame;
    public SinglePlayerFrame() {
        
        initUI();
         frame = this;
    }
    
    private void initUI() {


        setVisible(true);
        setTitle("Duall");
        setSize(800, 600);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                add(new gui.SinglePlayerJPanel(this));
                
        this.setResizable(false);

        
        
    }

    
	

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            gui.SinglePlayerFrame ex = new gui.SinglePlayerFrame();
            ex.setVisible(true);
        });
        
	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
