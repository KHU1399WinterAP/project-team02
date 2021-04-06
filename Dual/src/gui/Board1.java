/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.Database;
import app.Links;
import app.MyColor;
import app.Opponet;
import app.Shot;
import app.User;
import app.WarShip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Amir reza
 */
public class Board1 extends JPanel implements ActionListener, KeyListener {

    private User activeUser = Database.getUser((Login.userName == null) ? Register.userName : Login.userName);
    long first;
    long second;
    private Timer timer;
    private WarShip warShip;
    private final int DELAY = 5;
    Random random;
    private boolean close = false;

    static JFrame frame;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private File audioFile = new File("playingmusic.wav").getAbsoluteFile();
    private BufferedImage shotImage;
    private BufferedImage alienImage;
    private BufferedImage enemyShotsImage;
    private Opponet opponent;

    public ArrayList<Shot> shots = new ArrayList();
    public ArrayList<Shot> enemyShots = new ArrayList();
    Thread enemyShotting = new Thread(new EnemyShots());

    public Board1(JFrame frame) {

        initBoard();
        myInit(frame);

    }

    private void initBoard() {

        addKeyListener((KeyListener) new TAdapter());
        setBackground(MyColor.black);
        setFocusable(true);
        setSize(800, 600);

        warShip = new WarShip();
        shots = new ArrayList<>();
        enemyShots = new ArrayList<>();
        timer = new Timer(DELAY, this);

        //Starts the Timer, causing it to start sending action events to its listeners.  
        timer.start();
    }

    private void myInit(JFrame frame) {
        this.frame = frame;
        random = new Random();

        audioFile = new File("playingmusic.wav").getAbsoluteFile();

        try {
            shotImage = ImageIO.read(new File("fire.png"));
            alienImage = ImageIO.read(new File(Links.BASECHARACTERICON + Links.CHARACTER1));
            enemyShotsImage = ImageIO.read(new File("lazer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        opponent = new Opponet(170, -230, alienImage, this);
        this.requestFocus();

        addKeyListener(this);
        playSound();

        try {
            Thread.sleep(17);
        } catch (Exception e) {
        }
        this.setFocusable(true);

        enemyShotting.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        this.setBackground(MyColor.GAMELAYOUTBACKGROUND);

        super.paintComponent(g);

        doDrawing(g);

        drawShots(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawShots(Graphics g) {

        for (int i = 0; i < shots.size(); i++) {
            Shot sprite = (Shot) shots.get(i);
            sprite.draw(g);
        }
        for (int i = 0; i < enemyShots.size(); i++) {
            Shot sprite = (Shot) enemyShots.get(i);
            sprite.draw(g);
        }

    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(warShip.getImage(), warShip.getX(), warShip.getY(), this);

        opponent.draw(g);

    }

    public void endGame() {
        Dashboard dashboard = new Dashboard();
        this.validate();
        this.disable();
        frame.setVisible(false);
        frame.dispose();
        dashboard.setVisible(true);

    }

    public void handleCollision(app.Opponet other, Shot shot) {

        JOptionPane.showMessageDialog(null, "You Won !", "End", JOptionPane.INFORMATION_MESSAGE);

        activeUser.totalWins++;
        Database.updateUser(activeUser);
        removeShot(shot);
        endGame();

    }

    public void handleCollision(app.WarShip other, Shot shot) {

        JOptionPane.showMessageDialog(null, "You Lost !", "End", JOptionPane.INFORMATION_MESSAGE);

        activeUser.totalLosts++;
        Database.updateUser(activeUser);
        removeEnemyShot(shot);
        endGame();

    }

    private void step() {
        this.setBackground(MyColor.black);

        warShip.move();

        repaint(warShip.getX() - 10, warShip.getY() - 10,
                warShip.getWidth() + 2, warShip.getHeight() + 2);
    }

    // assprites = alien, shot
    // lsprites = starship, lazer
    public void removeShot(Shot sprite) {
        shots.remove(sprite);
    }

    public void removeEnemyShot(Shot sprite) {
        shots.remove(sprite);
    }

    private void moveSprits() {

        opponent.move();
        opponent.move();
        for (int i = 0; i < shots.size(); i++) {
            shots.get(i).move();

        }

        for (int i = 0; i < enemyShots.size(); i++) {
            enemyShots.get(i).move();

        }

    }

    private void collisionHandling() {

        for (int p = 0; p < shots.size(); p++) {

            Shot me = (Shot) shots.get(p);
            Opponet other = (Opponet) opponent;

            if (me.checkCollision(other)) {
                handleCollision(other, me);
                close = true;
                timer.stop();
                if (clip.isActive()) {
                    clip.stop();

                }
                break;

            }

        }

        for (int p = 0; p < enemyShots.size(); p++) {

            Shot me = (Shot) enemyShots.get(p);
            WarShip other = (WarShip) warShip;

            if (me.checkCollision(other)) {
                handleCollision(other, me);
                close = true;
                timer.stop();
                if (clip.isActive()) {
                    clip.stop();

                }
                break;

            }

        }

    }

    private void musicReplay() {

        if (!close) {
            if (clip.isActive()) {
                System.out.println("still playin");
            } else {	// if music is stop, play again
                System.out.println("stopped");
                try {
                    audioInputStream = AudioSystem
                            .getAudioInputStream(audioFile);
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
            }
        }

    }

    public void gameLoop() {

        // move sprite
        moveSprits();

        // check collision between enemy and shot
        collisionHandling();

        // update sprite movement
        repaint();

        // music replay
        musicReplay();

        try {
            Thread.sleep(17);
        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!close) {
            if (warShip.getX() < 0) {
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
            gameLoop();
            step();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    int i = 0;

    @Override
    public void keyPressed(KeyEvent e) {
        if (!close) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (i == 0) {
                    first = System.currentTimeMillis();
                    System.out.println(first);
                    i++;
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!close) {
            System.err.println("Released");
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                second = System.currentTimeMillis();
                if (second - first >= 1000) {
                    fire();
                }
                i = 0;

            }
        }

    }

    public void fire() {
        Shot shot = new Shot(warShip.getX() + 24, warShip.getY() - 30, shotImage, this, 0);
        shots.add(shot);
    }

    public void playSound() {
        try {
            audioInputStream = AudioSystem
                    .getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if (!close) {
                warShip.keyReleased(e);
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!close) {
                warShip.keyPressed(e);
            }

        }

    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        Board1 g = new Board1(frame);
        g.gameLoop();
    }

    class EnemyShots implements Runnable {

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep((random.nextInt(3) * 1000) + 4);
                } catch (Exception e) {
                }
                Shot enemyShot = new Shot(opponent.getX() + 10, opponent.getY() + 10, enemyShotsImage, Board1.this, 1);
                enemyShots.add(enemyShot);
                if (close) {
                    break;
                }
            }
        }
    }

}
