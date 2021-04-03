/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;

/**
 *
 * @author Amir reza
 */
public class MyColor extends Color {

    public MyColor(int red, int green, int blue) {
        super(red, green, blue);
    }

    private static Color mycolor(int red, int green, int blue) {

        return new Color(red, green, blue);

    }
    public static final Color MYRED = mycolor(227, 38, 92);
    public static final Color MYGREEN = mycolor(12, 174, 75);
    public static final Color MYGRAY = mycolor(214, 217, 223);
    public static final Color DARKFONT = mycolor(49, 78, 82);
    public static final Color DARKBACKGROUND = mycolor(30, 33, 45);
    public static final Color DARKBUTTONCOLOR = mycolor(65, 60, 105);
    public static final Color GAMELAYOUTBACKGROUND = mycolor(61, 66, 122);
}
