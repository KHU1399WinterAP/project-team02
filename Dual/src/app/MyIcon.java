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
    private static Icon imageicon;
    private static BufferedImage img;
    public static Icon myicon(String iconname , Component component){
    try {
        img = ImageIO.read(new File(Links.baseicon + iconname));
        } 
    catch (IOException e) {
        }
    
    
    Image dimg = img.getScaledInstance(component.getWidth(), component.getHeight(),Image.SCALE_SMOOTH);
       imageicon = new ImageIcon(dimg);
       
       return imageicon;
       
    }
    
    
    
    
    
}
