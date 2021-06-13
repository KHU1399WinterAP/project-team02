package gui;

import app.Database;
import app.User;
import javax.swing.*;
import java.awt.*;

public class MultiPlayerFrame extends JFrame {
    private User activeUser = Database.getUser((Login.userName == null) ? Register.userName : Login.userName);


    public MultiPlayerFrame() {

        initUI();

    }

    private void initUI() {


        setVisible(true);
        setTitle(activeUser.getUserName());
        setSize(800, 600);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        MultiPlayerJPanel multiPlayerJPanel =new gui.MultiPlayerJPanel(this);
        add(multiPlayerJPanel);

        addKeyListener(multiPlayerJPanel);
        this.setResizable(false);



    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            gui.MultiPlayerFrame ex = new gui.MultiPlayerFrame();
            ex.setVisible(true);
        });


    }



}
