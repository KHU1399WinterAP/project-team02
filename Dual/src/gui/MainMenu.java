/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.*;

import app.Links;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import utils.Utility;

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

    private void my_inint() {

        setLocation();
        setMyIcon();
        setMyThem();
        setMyText();

        try {
            setMyFont();
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        }
        registerButton.setFocusable(false);
        loginButton.setFocusable(false);
        exitButton.setFocusable(false);

    }

    public void setLocation() {

        Utility.centerLocation(this);

    }

    private void setMyIcon() {
        mainIconLable.setIcon(MyIcon.myIcon(Links.MAINREGISTERLOGINICON, mainIconLable, 0));
    }

    private void setMyThem() {
        Utility.setThemForButton(MyColor.WHITE, MyColor.MYGREEN, registerButton, loginButton);
        Utility.setThemForButton(MyColor.WHITE, MyColor.MYRED, exitButton);
        Utility.setThemForPanel(MyColor.MYGREEN, mainOptionPanel);

    }

    private void setMyText() {
        registerButton.setText("Register");
        loginButton.setText("Login");
        exitButton.setText("Exit");

    }

    private void setMyFont() throws FontFormatException, IOException {
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 40, registerButton, loginButton, exitButton);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainIconPanel = new javax.swing.JPanel();
        mainIconLable = new javax.swing.JLabel(imageIcon);
        mainOptionPanel = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(810, 600));
        setResizable(false);

        mainIconPanel.setPreferredSize(new java.awt.Dimension(400, 600));

        mainIconLable.setText("jLabel1");

        javax.swing.GroupLayout mainIconPanelLayout = new javax.swing.GroupLayout(mainIconPanel);
        mainIconPanel.setLayout(mainIconPanelLayout);
        mainIconPanelLayout.setHorizontalGroup(
            mainIconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainIconLable, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        mainIconPanelLayout.setVerticalGroup(
            mainIconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainIconLable, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        mainOptionPanel.setPreferredSize(new java.awt.Dimension(400, 600));

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Register");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainOptionPanelLayout = new javax.swing.GroupLayout(mainOptionPanel);
        mainOptionPanel.setLayout(mainOptionPanelLayout);
        mainOptionPanelLayout.setHorizontalGroup(
            mainOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainOptionPanelLayout.createSequentialGroup()
                .addGroup(mainOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainOptionPanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(mainOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainOptionPanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        mainOptionPanelLayout.setVerticalGroup(
            mainOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainOptionPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainIconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainOptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainIconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainOptionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        this.setVisible(false);
        Register register = new Register(this);
        register.setVisible(true);

    }//GEN-LAST:event_registerButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        this.setVisible(false);
        Login login = new Login(this);
        login.setVisible(true);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

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
    private javax.swing.JButton exitButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel mainIconLable;
    private javax.swing.JPanel mainIconPanel;
    private javax.swing.JPanel mainOptionPanel;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
