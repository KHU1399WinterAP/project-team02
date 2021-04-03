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

/**
 *
 * @author Amir reza
 */
public class MyFont extends Font {

    public MyFont(Font font) {
        super(font);
    }

    public static void setMyFont(String fontName, int style, int size, Component... components) throws FontFormatException, IOException {
        for (Component component : components) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(Links.BASEFONT + fontName));
            font = font.deriveFont(style, size);
            component.setFont(font);
        }

    }

}
