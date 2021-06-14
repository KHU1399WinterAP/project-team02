/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.app;

import java.awt.*;
import java.io.*;

/**
 * @author Amir reza
 */
public class MyFont extends Font {

    public MyFont(Font font) {
        super(font);
    }

    public static void setMyFont(String fontName, int style, int size, Component... components){
        for (Component component : components) {
            Font font = null;
            try {

                var stream = Links.class.getClassLoader().getResourceAsStream(Links.BASEFONT + fontName);
                if (stream == null)
                    throw new FileNotFoundException();

                font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(style, size);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }component.setFont(font);

        }

    }

}
