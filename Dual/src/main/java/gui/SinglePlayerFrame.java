/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.gui;

import java.awt.EventQueue;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JFrame;

/**
 * @author Amir reza
 */
public class SinglePlayerFrame extends JFrame {
    private AudioInputStream audioInputStream;
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
        add(new main.java.gui.SinglePlayerJPanel(this));

        this.setResizable(false);


    }


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            main.java.gui.SinglePlayerFrame ex = new main.java.gui.SinglePlayerFrame();
            ex.setVisible(true);
        });


    }


}
