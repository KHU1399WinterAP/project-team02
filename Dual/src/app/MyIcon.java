/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Amir reza
 */
public class MyIcon {

    private static Icon ultimateImageIcon;
    private static BufferedImage iconImage;

    public static Icon myIcon(String iconName, Component component ,int choose) {
        if (choose == 0) {
            try {
            iconImage = ImageIO.read(new File(Links.BASEICON + iconName));
        } catch (IOException e) {
        }
        }else{
        try {
            iconImage = ImageIO.read(new File(Links.BASECHARACTERICON + iconName));
        } catch (IOException e) {
        }
        }

        Image scaledImageIcon = iconImage.getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH);
        ultimateImageIcon = new ImageIcon(scaledImageIcon);

        return ultimateImageIcon;

    }

}
