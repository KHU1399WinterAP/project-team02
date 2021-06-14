package main.java.gui;

import main.java.app.Database;
import main.java.app.Links;
import main.java.app.MyColor;
import main.java.app.Opponet;
import main.java.app.Shot;
import main.java.app.User;
import main.java.app.WarShip;
import main.java.utils.Utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 * @author Amir reza
 */
public class SinglePlayerJPanel extends JPanel implements ActionListener, KeyListener {

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
    private File audioFile = new File(getClass().getResource("/main/resources/musics/playingmusic.wav").getFile());
    private Image shotImage;
    private Image alienImage;
    private Image enemyShotsImage;
    private Opponet opponent;

    public ArrayList<Shot> shots = new ArrayList();
    public ArrayList<Shot> enemyShots = new ArrayList();
    Thread enemyShotting = new Thread(new EnemyShots());

    public SinglePlayerJPanel(JFrame frame) {

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


        shotImage = new ImageIcon(getClass().getResource("/main/resources/game's/lazer.png")).getImage();
        alienImage = new ImageIcon(getClass().getResource(Links.BASE_CHARACTER_ICON + Links.CHARACTER1)).getImage();
        enemyShotsImage = new ImageIcon(getClass().getResource("/main/resources/game's/lazer.png")).getImage();


        opponent = new Opponet(170, -230, alienImage, this);
        audioFile = new File(getClass().getResource("/main/resources/musics/playingmusic.wav").getFile());
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
        this.setBackground(MyColor.GAME_LAYOUT_BACKGROUND);

        super.paintComponent(g);

        doDrawing(g);

        drawShots(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawShots(Graphics g) {

        Utility.drawShots(this, g, shots, enemyShots);

    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(warShip.getImage(), warShip.getX(), warShip.getY(), this);

        g2d.drawImage(opponent.getImage(), opponent.getX(), opponent.getY(), this);


    }

    public void handleCollision(main.java.app.Opponet other, Shot shot) {

        JOptionPane.showMessageDialog(null, "You Won !", "End", JOptionPane.INFORMATION_MESSAGE);

        activeUser.totalWins++;
        Database.updateUser(activeUser);
        removeShot(shot);
        Utility.endGame(frame, this);

    }

    public void handleCollision(main.java.app.WarShip other, Shot shot) {

        JOptionPane.showMessageDialog(null, "You Lost !", "End", JOptionPane.INFORMATION_MESSAGE);

        activeUser.totalLosts++;
        Database.updateUser(activeUser);
        removeEnemyShot(shot);
        Utility.endGame(frame, this);

    }

    private void step() {
        this.setBackground(MyColor.black);

        warShip.move();

        repaint(warShip.getX() - 10, warShip.getY() - 10,
                warShip.getWidth() + 2, warShip.getHeight() + 2);
    }

    public void removeShot(Shot sprite) {
        shots.remove(sprite);
    }

    public void removeEnemyShot(Shot sprite) {
        shots.remove(sprite);
    }

    private void moveSprites() {

        Utility.moveObjects(opponent, shots, enemyShots);

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

        if (audioFile != null) {

            if (!close) {

                if (clip.isActive()) {
                    //still playing
                } else {    // if music is stop, play again
                    try {
                        audioInputStream = AudioSystem
                                .getAudioInputStream(audioFile);
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public void gameLoop() {

        // move sprite
        moveSprites();

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
            Utility.keepInTheSpaceShip(warShip, this);

            this.setBackground(MyColor.GAME_LAYOUT_BACKGROUND);
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
                    i++;
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!close) {
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
        Shot shot = new Shot(warShip.getX() + 24, warShip.getY() - 30, shotImage, 0);
        shots.add(shot);
    }

    public void playSound() {
        try {
            if (audioFile != null) {
                audioInputStream = AudioSystem
                        .getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (Exception ex) {
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
     * @param args
     */
    public static void main(String args[]) {
        SinglePlayerJPanel g = new SinglePlayerJPanel(frame);
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
                Shot enemyShot = new Shot(opponent.getX() + 10, opponent.getY() + 10, enemyShotsImage, 1);
                enemyShots.add(enemyShot);
                if (close) {
                    break;
                }
            }
        }
    }

}