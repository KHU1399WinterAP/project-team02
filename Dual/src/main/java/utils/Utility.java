/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.utils;

import main.java.app.*;
import main.java.gui.Dashboard;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Amir reza
 */
public class Utility {

    public static int[] centerLocation(JFrame frame) {

        frame.setLocationRelativeTo(null);
        Toolkit toolKit = frame.getToolkit();
        Dimension dim = toolKit.getScreenSize();
        int x = (int) dim.getWidth() / 2 - frame.getWidth() / 2;
        int y = (int) dim.getHeight() / 2 - frame.getHeight() / 2;
        frame.setLocation(x, y);
        int[] anw = {x,y};
        return anw;

    }

    public static void setThemForButton(Color backgroundColor, Color foregroundColor, JButton... buttons) {

        for (JButton button : buttons) {

            button.setForeground(foregroundColor);
            button.setBackground(backgroundColor);

        }

    }

    public static void setThemForLabel(Color backgroundColor, Color foregroundColor, JLabel... labels) {

        for (JLabel label : labels) {

            label.setForeground(foregroundColor);
            label.setBackground(backgroundColor);

        }

    }

    public static void setThemForPanel(Color backgroundColor, JPanel... panels) {

        for (JPanel panel : panels) {

            panel.setBackground(backgroundColor);

        }

    }

    public static void setMyFont(Color backgroundColor, JPanel... panels) {

        for (JPanel panel : panels) {

            panel.setBackground(backgroundColor);

        }

    }

    public static void setMyIcon(String[] iconsName,int i, JLabel... labels) {

        int j = 0;
        for (JLabel label : labels) {

            label.setIcon(MyIcon.myIcon(iconsName[j], label, i));
            j++;
        }

    }
    public static void keepInTheSpaceShip(WarShip warShip, JPanel panel){
        if (warShip.getX() < 0) {
            warShip.x = 0;
        }
        if (warShip.getX() > panel.getWidth() - warShip.getWidth()) {
            warShip.x = panel.getWidth() - warShip.getWidth();
        }
        if (warShip.getY() > panel.getHeight() - warShip.getHeight()) {
            warShip.y = panel.getHeight() - warShip.getHeight();
        }

        if (warShip.getY() < 0) {
            warShip.y = 0;
        }

    }

    public static void moveObjects(WarShip spaceShip, ArrayList<Shot> shots, ArrayList<Shot> enemyShots){
        spaceShip.move();
        for (int i = 0; i < shots.size(); i++) {
            shots.get(i).move();

        }
        for (int i = 0; i < enemyShots.size(); i++) {
            enemyShots.get(i).move();

        }
    }public static void moveObjects(Opponet spaceShip, ArrayList<Shot> shots, ArrayList<Shot> enemyShots){
        spaceShip.move();
        for (int i = 0; i < shots.size(); i++) {
            shots.get(i).move();

        }
        for (int i = 0; i < enemyShots.size(); i++) {
            enemyShots.get(i).move();

        }
    }

    public static void drawShots(JPanel jPanel,Graphics g, ArrayList<Shot> shots, ArrayList<Shot> enemyShots){
        for (int i = 0; i < shots.size(); i++) {
            Shot sprite = (Shot) shots.get(i);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), jPanel);

            //sprite.draw(g);
        }
        for (int i = 0; i < enemyShots.size(); i++) {
            Shot sprite = (Shot) enemyShots.get(i);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), jPanel);

            //sprite.draw(g);
        }

    }

    public static void endGame(JFrame frame, JPanel panel) {
        Dashboard dashboard = new Dashboard();
        panel.validate();
        panel.setEnabled(false);
        frame.setVisible(false);
        frame.dispose();
        dashboard.setVisible(true);

    }

}
