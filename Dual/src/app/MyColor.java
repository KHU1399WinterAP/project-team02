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
public class MyColor extends Color{

    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    private static Color mycolor (int r, int g, int b){
    
        return new Color(r, g, b);
    
    
    }
    public static final Color red = mycolor(227,38,92);
    public static final Color green = mycolor(12, 174, 75);
    public static final Color gray = mycolor(214, 217, 223);
    public static final Color darkfont = mycolor(49, 78, 82);
    public static final Color darkbackground = mycolor(30, 33, 45);
    public static final Color darkbuttoncolor = mycolor(65, 60, 105);
}
