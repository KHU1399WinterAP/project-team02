/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.MyIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.Position;

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

    public static void setThemForLable(Color backgroundColor, Color foregroundColor, JLabel... lables) {

        for (JLabel lable : lables) {

            lable.setForeground(foregroundColor);
            lable.setBackground(backgroundColor);

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

}
