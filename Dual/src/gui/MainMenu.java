/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import app.*;

import app.Links;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Amir reza
 */

public class MainMenu extends javax.swing.JFrame {
    private ImageIcon imageIcon;
    BufferedImage img = null;
    GraphicsEnvironment ge;
    /*
     * Creates new form MainMenu
     */
    public MainMenu() throws FileNotFoundException, FontFormatException, IOException, SQLException, ClassNotFoundException {
        
         initComponents();
       my_inint();
               


   
                
        
       
      

    }
    private void my_inint(){
    
    set_location();
    set_icon();
    set_forground();
    set_backround();
    set_text();
    try {
        set_font();
        } 
    catch (FontFormatException | IOException e) {
        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        } 
        registerbutton.setFocusable(false);
        loginbutton.setFocusable(false);
        exitbutton.setFocusable(false);
    
    }
    
    
    public void set_location(){
    
    this.setLocationRelativeTo(null);
    Toolkit tk = this.getToolkit();
    Dimension dim = tk.getScreenSize();
    int x = (int) dim.getWidth() / 2 - this.getWidth() / 2;
    int y = (int) dim.getHeight() / 2 - this.getHeight() / 2;
    this.setLocation(x, y);
    
    
    
    
    }

    
    
    
    
    
       
       
    private void set_icon(){
        mainiconlable.setIcon(MyIcon.myicon(Links.m_r_l_icon, mainiconlable));
    }
    
    private void set_forground(){
        //new Color(12, 174, 75)
        registerbutton.setForeground(MyColor.green);
        loginbutton.setForeground(MyColor.green);
        exitbutton.setForeground(MyColor.red);
    
    }
    
    private void set_backround(){
        mainiconpanel.setBackground(MyColor.WHITE);
        loginbutton.setBackground(MyColor.WHITE);
        mainoptionpanel.setBackground(MyColor.WHITE);
        mainoptionpanel.setBackground(MyColor.green);
        exitbutton.setBackground(MyColor.WHITE);
        registerbutton.setBackground(MyColor.WHITE);

    }
    
    private void set_text(){
        registerbutton.setText("Register");
        loginbutton.setText("Login");
        exitbutton.setText("Exit");
        
    
    }
    
    
    
    private void set_font() throws FontFormatException, IOException{
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 40, registerbutton);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 40, loginbutton);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 40, exitbutton);
        
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainiconpanel = new javax.swing.JPanel();
        mainiconlable = new javax.swing.JLabel(imageIcon);
        mainoptionpanel = new javax.swing.JPanel();
        registerbutton = new javax.swing.JButton();
        loginbutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(810, 600));
        setResizable(false);

        mainiconpanel.setPreferredSize(new java.awt.Dimension(400, 600));

        mainiconlable.setText("jLabel1");

        javax.swing.GroupLayout mainiconpanelLayout = new javax.swing.GroupLayout(mainiconpanel);
        mainiconpanel.setLayout(mainiconpanelLayout);
        mainiconpanelLayout.setHorizontalGroup(
            mainiconpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainiconlable, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        mainiconpanelLayout.setVerticalGroup(
            mainiconpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainiconlable, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        mainoptionpanel.setPreferredSize(new java.awt.Dimension(400, 600));

        registerbutton.setText("Register");
        registerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbuttonActionPerformed(evt);
            }
        });

        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        exitbutton.setText("Register");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainoptionpanelLayout = new javax.swing.GroupLayout(mainoptionpanel);
        mainoptionpanel.setLayout(mainoptionpanelLayout);
        mainoptionpanelLayout.setHorizontalGroup(
            mainoptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainoptionpanelLayout.createSequentialGroup()
                .addGroup(mainoptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainoptionpanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(mainoptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainoptionpanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        mainoptionpanelLayout.setVerticalGroup(
            mainoptionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainoptionpanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(registerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainiconpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainoptionpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainiconpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainoptionpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbuttonActionPerformed
        this.setVisible(false);
        Register register = new Register(this);
        register.setVisible(true);
        
    }//GEN-LAST:event_registerbuttonActionPerformed

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        this.setVisible(false);
        Login login = new Login(this);
        login.setVisible(true);
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbuttonActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainMenu().setVisible(true);
            } catch (FontFormatException | IOException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbutton;
    private javax.swing.JButton loginbutton;
    private javax.swing.JLabel mainiconlable;
    private javax.swing.JPanel mainiconpanel;
    private javax.swing.JPanel mainoptionpanel;
    private javax.swing.JButton registerbutton;
    // End of variables declaration//GEN-END:variables
}
