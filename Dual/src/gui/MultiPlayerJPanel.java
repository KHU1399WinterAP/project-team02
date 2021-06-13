package gui;

import app.*;
import utils.Utility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

public class MultiPlayerJPanel extends JPanel implements KeyListener, ActionListener {
    private User activeUser = Database.getUser((Login.userName == null) ? Register.userName : Login.userName);

    long first;
    long second;

    private boolean close = false;
    private WarShip warShip;
    private ArrayList<Shot> shots;
    public static ArrayList<Shot> enemyShots;
    private Image shotImage;
    private Image alienImage;
    private static JFrame multiPlayerFrame;

    public MultiPlayerJPanel(MultiPlayerFrame multiPlayerFrame) {
        Thread threadGetFire = new Thread(new GetFire());
        threadGetFire.start();

        this.setSize(600, 800);

        this.setBackground(MyColor.GAMELAYOUTBACKGROUND);
        warShip = new WarShip();
        shotImage = new ImageIcon(getClass().getResource("/resources/game's/lazer.png")).getImage();
        alienImage = new ImageIcon(getClass().getResource("/resources/game's/lazer.png")).getImage();
        shots = new ArrayList<>();
        enemyShots = new ArrayList<>();
        this.multiPlayerFrame = multiPlayerFrame;

        Thread thread = new Thread(new ReePant(this));
        thread.start();


    }

    @Override
    public void paintComponent(Graphics g) {
        move();
        collisionHandling();
        super.paintComponent(g);

        this.setBackground(MyColor.GAMELAYOUTBACKGROUND);
        g.drawImage(warShip.getImage(), warShip.getX(), warShip.getY(), null);


       Utility.drawShots(this, g, shots, enemyShots);


    }


    public  void  move(){
        Utility.keepInTheSpaceShip(warShip, this);
        Utility.moveObjects(warShip, shots, enemyShots);

    }


    public void handleCollision(String status, Shot shot) {

        if (status.equalsIgnoreCase("LOST")){
        try {
            removeEnemyShot(shot);
            MultiplayerLogin.dataOutputStream.writeUTF("WON");
            MultiplayerLogin.dataOutputStream.writeUTF(MultiplayerLogin.opponentName);
            activeUser.totalLosts++;

        } catch (IOException e) {
            e.printStackTrace();
        }}

        else {
            activeUser.totalWins++;
        }
        Database.updateUser(activeUser);
        removeEnemyShot(shot);
        final JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setAlwaysOnTop(true);
        frame.setSize(500, 500);
        int x = multiPlayerFrame.getX();
        int y = multiPlayerFrame.getY();
        x = x + (multiPlayerFrame.getWidth()/2) - (frame.getWidth()/2);
        y = y + (multiPlayerFrame.getHeight()/2) - (frame.getHeight()/2);

        frame.setLocation(x, y);
        JPanel informPanel = new JPanel();
        frame.add(informPanel);
        informPanel.setSize(500, 500);
        JLabel informJLable = new JLabel();
        informJLable.setText("YOU "+ status + " !");
        informJLable.setSize(500,500);
        informPanel.add(informJLable);




               // JOptionPane optionPane = new JOptionPane("Option Pane");
              //  optionPane.showMessageDialog(frame, ); // if you put null instead of frame, the option pane will be behind the frame


        System.out.println("before frame");
        frame.setVisible(true);
        System.out.println("after frame");
        JOptionPane.showMessageDialog(null, "YOU "+ status + " !", "End", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("end");
        Utility.endGame(multiPlayerFrame, this);

    }


    private void removeEnemyShot(Shot shot) {
        enemyShots.remove(shot);
    }

    private void collisionHandling() {





        for (int p = 0; p < enemyShots.size(); p++) {

            Shot me = (Shot) enemyShots.get(p);
            WarShip other = (WarShip) warShip;

            if (me.checkCollision(other)) {
                handleCollision("LOST", me);
                close = true;

           break;

            }

        }

    }

    public void fire() {
        Shot shot = new Shot(warShip.getX() + 24, warShip.getY() - 30, shotImage, 0);
        shots.add(shot);
        try {
            System.out.println("sending fire to : " + MultiplayerLogin.opponentName);
            MultiplayerLogin.dataOutputStream.writeUTF("FIRE");
            MultiplayerLogin.dataOutputStream.writeUTF(MultiplayerLogin.opponentName);
            MultiplayerLogin.dataOutputStream.writeUTF(String.valueOf(shot.getX()));
            MultiplayerLogin.dataOutputStream.writeUTF(String.valueOf(shot.getY()));
            System.out.println("sending fire to : " + MultiplayerLogin.opponentName + " done");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    int i = 0;

    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println(e.getKeyCode() + " pressed");
        if (!close) {

            warShip.keyPressed(e);
            Utility.keepInTheSpaceShip(warShip, this);
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE){

            if (!close) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (i == 0) {
                    first = System.currentTimeMillis();
                    System.out.println(first);
                    i++;
                }
            }
        }
    }}

    @Override
    public void keyReleased(KeyEvent e) {
        if (!close) {
            warShip.keyReleased(e);

        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
        if (!close) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                second = System.currentTimeMillis();
                if (second - first >= 1000) {
                    fire();

                }
                i = 0;

            }
        }}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Utility.keepInTheSpaceShip(warShip, this);
    }


    class ReePant implements Runnable {

        private JPanel jPanel;
        public ReePant(JPanel jPanel) {
            this.jPanel = jPanel;
        }

        @Override
        public void run() {
            while (true){
            jPanel.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        }
    }
    class GetFire implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    if (MultiplayerLogin.dataInputStream.readUTF().equalsIgnoreCase("FIRE")) {
                        int x = Integer.parseInt(MultiplayerLogin.dataInputStream.readUTF());
                        int y = Integer.parseInt(MultiplayerLogin.dataInputStream.readUTF());

                        MultiPlayerJPanel.enemyShots.add(new Shot(x, y, shotImage, 1));
                        System.out.println("getting fire done");

                    }
                    else if (MultiplayerLogin.dataInputStream.readUTF().equalsIgnoreCase("WON")){
                        System.out.println("recived");
                        handleCollision("WON", new Shot(0,0,shotImage,1));

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
