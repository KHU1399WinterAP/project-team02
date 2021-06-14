/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.gui;

import main.java.app.Database;
import main.java.app.Links;
import main.java.app.MyColor;
import main.java.app.MyFont;
import main.java.app.MyIcon;
import main.java.app.User;

import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Amir reza
 */
public class Register extends javax.swing.JFrame {

    private ImageIcon imageIcon;
    private JFrame mainFrame;
    public static String userName;

    /*
     * Creates new form Register
     */
    public Register(JFrame jf) {

        initComponents();
        myInit();
        this.mainFrame = jf;
    }

    public Register() {
        initComponents();
        myInit();

    }

    private void myInit() {

        setLocation();
        setIcon();
        setForeground();
        setBackground();
        setText();
        try {
            setFont();
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void setLocation() {

        this.setLocationRelativeTo(null);
        Toolkit tk = this.getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (int) dim.getWidth() / 2 - this.getWidth() / 2;
        int y = (int) dim.getHeight() / 2 - this.getHeight() / 2;
        this.setLocation(x, y);

    }

    private void setIcon() {
        iconLable.setIcon(MyIcon.myIcon(Links.MAIN_REGISTER_LOGIN_ICON, iconLable, 0));
    }

    private void setForeground() {
        //new Color(12, 174, 75)
        registerButton.setForeground(MyColor.BLACK);
        BackToMainButton.setForeground(MyColor.BLACK);
        userNameLable.setForeground(MyColor.BLACK);
        passwordLable.setForeground(MyColor.BLACK);
    }

    private void setBackground() {
        registerButton.setBackground(MyColor.WHITE);
        passwordFeild.setBackground(MyColor.WHITE);
        userNameFeild.setBackground(MyColor.WHITE);
        BackToMainButton.setBackground(MyColor.WHITE);
        jPanel2.setBackground(MyColor.MY_GREEN);

    }

    private void setText() {
        registerButton.setText("Register");
        BackToMainButton.setText("Back");
        userNameLable.setText("username");
        passwordLable.setText("password");
        userNameFeild.setText("");
        passwordFeild.setText("");

    }

    private void setFont() throws FontFormatException, IOException {
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 30, registerButton);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 30, userNameLable);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 30, passwordLable);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 30, BackToMainButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconPanel = new javax.swing.JPanel();
        iconLable = new javax.swing.JLabel(imageIcon);
        jPanel2 = new javax.swing.JPanel();
        userNameLable = new javax.swing.JLabel();
        passwordLable = new javax.swing.JLabel();
        passwordFeild = new javax.swing.JPasswordField();
        userNameFeild = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        BackToMainButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        iconPanel.setPreferredSize(new java.awt.Dimension(400, 600));

        iconLable.setText("jLabel1");

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
                iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(iconLable, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );
        iconPanelLayout.setVerticalGroup(
                iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(iconLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        userNameLable.setText("username");

        passwordLable.setText("password");

        passwordFeild.setText("jPasswordField1");
        passwordFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFeildActionPerformed(evt);
            }
        });

        userNameFeild.setText("jTextField1");

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        BackToMainButton.setText("Login");
        BackToMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMainButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(userNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(121, 121, 121)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(userNameFeild)
                                                                .addComponent(passwordFeild, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                                .addComponent(passwordLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(150, 150, 150)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                                                .addComponent(BackToMainButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(userNameLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userNameFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(passwordLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(registerButton)
                                .addGap(18, 18, 18)
                                .addComponent(BackToMainButton)
                                .addContainerGap(201, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        userName = userNameFeild.getText();
        int check = Database.countUser(userName);

        switch (check) {

            case 0 -> {

                Database.insertIntoUsers(new User(userNameFeild.getText(), passwordFeild.getPassword(), 0, 0, 0, 1, 1));
                JOptionPane.showMessageDialog(rootPane, "You successfully have registered!");
                this.dispose();
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);

            }

            case 1 -> {
                JOptionPane.showMessageDialog(rootPane, "This username is not available!");
                userNameFeild.setText("");
                passwordFeild.setText("");
            }
        }


    }//GEN-LAST:event_registerButtonActionPerformed

    private void BackToMainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMainButtonActionPerformed
        this.dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_BackToMainButtonActionPerformed

    private void passwordFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFeildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFeildActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToMainButton;
    private javax.swing.JLabel iconLable;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordFeild;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField userNameFeild;
    private javax.swing.JLabel userNameLable;
    // End of variables declaration//GEN-END:variables
}