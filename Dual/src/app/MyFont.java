/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.*;
import java.io.*;

/**
 *
 * @author Amir reza
 */
public class MyFont extends Font {

    public MyFont(Font font) {
        super(font);
    }

    public static void  setMyFont(String fontName, int style, int size, Component... components) throws FontFormatException, IOException {
        for (Component component : components) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(MyFont.class.getResource(Links.BASEFONT+fontName).getFile())).deriveFont(style, size);
            component.setFont(font);

        }

    }

}
