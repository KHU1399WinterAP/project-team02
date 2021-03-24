/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Amir reza
 */
public class MyFont extends Font{

    public MyFont(Font font) {
        super(font);
    }
    
    public static void set_myfont(String fontname, int style, int size, Component component) throws FontFormatException, IOException{
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(Links.basefont + fontname));
        font = font.deriveFont(style, size);
        component.setFont(font);
     }
    
    
    
    
    
    
    
    
    
    
}
