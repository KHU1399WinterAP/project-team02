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

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import main.java.utils.Utility;

/**
 * @author Amir reza
 */
public class Dashboard extends javax.swing.JFrame {

    int x, y;

    private User activeUser = Database.getUser((Login.userName == null) ? Register.userName : Login.userName);

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        myInit();

    }

    private void myInit() {

        int[] FramePosition = Utility.centerLocation(this);
        x = FramePosition[0];
        y = FramePosition[1];
        them();
        setText();
        try {
            setFont();
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        }
        click();

    }

    public void setIcon() {
        iconLabel.setIcon(MyIcon.myIcon(Links.DASHBOARD_ICON, iconLabel, 0));
        setSpaceShipCharacter(activeUser, avatarLabel);
    }

    private static void setSpaceShipCharacter(User activeUser, JLabel avatarLable) {
        switch (activeUser.getAvatarId()) {

            case 1 -> avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR1, avatarLable, 0));

            case 2 -> avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR2, avatarLable, 0));
            case 3 -> avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR3, avatarLable, 0));
            case 4 -> avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR4, avatarLable, 0));
            case 5 -> avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR5, avatarLable, 0));
            case 6 -> avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR6, avatarLable, 0));
        }
    }

    private void setDarkIcon() {
        iconLabel.setIcon(MyIcon.myIcon(Links.DARK_DASHBOARD_ICON, iconLabel, 0));
        setSpaceShipCharacter(activeUser, avatarLabel);
    }

    private void setForeground() {
        //new Color(12, 174, 75)
        multiPlayerButton.setForeground(MyColor.white);
        singlePlayerButton.setForeground(MyColor.white);
        userNameLabel.setForeground(MyColor.white);
        logOutButton.setForeground(MyColor.white);
        themButton.setForeground(MyColor.white);
        appNameLabel.setForeground(MyColor.white);
        changeCharacter.setForeground(MyColor.white);
        totalLostsLabel.setForeground(MyColor.white);
        totalLostsNumber.setForeground(MyColor.white);
        totalWinsLabel.setForeground(MyColor.white);
        totalWinsNumber.setForeground(MyColor.white);

    }

    private void setDarkForeground() {
        multiPlayerButton.setForeground(MyColor.DARK_FONT);
        singlePlayerButton.setForeground(MyColor.DARK_FONT);
        userNameLabel.setForeground(MyColor.DARK_FONT);
        logOutButton.setForeground(MyColor.DARK_FONT);
        themButton.setForeground(MyColor.DARK_FONT);
        appNameLabel.setForeground(MyColor.DARK_FONT);
        changeCharacter.setForeground(MyColor.DARK_FONT);
        totalLostsLabel.setForeground(MyColor.DARK_FONT);
        totalLostsNumber.setForeground(MyColor.DARK_FONT);
        totalWinsLabel.setForeground(MyColor.DARK_FONT);
        totalWinsNumber.setForeground(MyColor.DARK_FONT);

    }

    private void them() {
        if (activeUser.getSettingId() == 0) {
            setForeground();
            setBackground();
            setIcon();
        } else {
            setDarkForeground();
            setDarkBackground();
            setDarkIcon();

        }

    }

    private void setBackground() {
        jPanel1.setBackground(MyColor.MY_RED);
        multiPlayerButton.setBackground(MyColor.MY_GREEN);
        singlePlayerButton.setBackground(MyColor.MY_GREEN);
        logOutButton.setBackground(MyColor.MY_GREEN);
        themButton.setBackground(MyColor.MY_GREEN);
        appNameLabel.setBackground(MyColor.MY_RED);
        changeCharacter.setBackground(MyColor.MY_GREEN);
        totalLostsLabel.setBackground(MyColor.MY_GREEN);
        totalLostsNumber.setBackground(MyColor.MY_GREEN);
        totalWinsLabel.setBackground(MyColor.MY_GREEN);
        totalWinsNumber.setBackground(MyColor.MY_GREEN);

    }

    private void setDarkBackground() {
        jPanel1.setBackground(MyColor.DARK_BACKGROUND);
        multiPlayerButton.setBackground(MyColor.DARK_BUTTON_COLOR);
        singlePlayerButton.setBackground(MyColor.DARK_BUTTON_COLOR);
        logOutButton.setBackground(MyColor.DARK_BUTTON_COLOR);
        themButton.setBackground(MyColor.DARK_BUTTON_COLOR);
        appNameLabel.setBackground(MyColor.DARK_BACKGROUND);
        changeCharacter.setBackground(MyColor.DARK_BUTTON_COLOR);
        totalLostsLabel.setBackground(MyColor.DARK_BUTTON_COLOR);
        totalLostsNumber.setBackground(MyColor.DARK_BUTTON_COLOR);
        totalWinsLabel.setBackground(MyColor.DARK_BUTTON_COLOR);
        totalWinsNumber.setBackground(MyColor.DARK_BUTTON_COLOR);

    }

    private void setText() {
        multiPlayerButton.setText("<html>Multi<br />Player</html>");
        logOutButton.setText("LogOut");
        userNameLabel.setText("username");
        singlePlayerButton.setText("<html>Single<br />Player</html>");
        themButton.setText("Them");
        appNameLabel.setText("Duall");
        iconLabel.setText("");
        changeCharacter.setText("Change Character");
        userNameLabel.setText(activeUser.getUserName());
        totalLostsLabel.setText("<html>Total<br />Losts</html>");
        totalWinsLabel.setText("<html>Total<br />Wins</html>");
        totalWinsNumber.setText(String.valueOf(activeUser.getTotalWins()));
        totalLostsNumber.setText(String.valueOf(activeUser.getTotalLosts()));

    }

    private void setFont() throws FontFormatException, IOException {
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 15, logOutButton);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 30, userNameLabel);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 40, singlePlayerButton);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 40, multiPlayerButton);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 15, themButton);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 20, changeCharacter);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 30, totalLostsLabel);
        MyFont.setMyFont(Links.MAIN_FONT, MyFont.PLAIN, 30, totalWinsLabel);
        appNameLabel.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
        totalWinsNumber.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
        totalLostsNumber.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
    }

    private void click() {
        avatarLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                PickAvatar pickAvatar = new PickAvatar(x, y, avatarLabel);

                pickAvatar.setVisible(true);

            }

        });

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        changeCharacter = new javax.swing.JButton();
        multiPlayerButton = new javax.swing.JButton();
        singlePlayerButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        themButton = new javax.swing.JButton();
        userNameLabel = new javax.swing.JLabel();
        appNameLabel = new javax.swing.JLabel();
        avatarLabel = new javax.swing.JLabel();
        totalWinsNumber = new javax.swing.JLabel();
        totalWinsLabel = new javax.swing.JLabel();
        totalLostsLabel = new javax.swing.JLabel();
        totalLostsNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(810, 600));

        iconLabel.setText("jLabel1");

        changeCharacter.setText("jButton5");
        changeCharacter.addActionListener(evt -> changeCharacterActionPerformed(evt));

        multiPlayerButton.setText("jButton4");

        singlePlayerButton.setText("jButton3");
        singlePlayerButton.addActionListener(evt -> singlePlayerButtonActionPerformed(evt));
        multiPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiPlayerButtonActionPerformed(evt);
            }
        });

        logOutButton.setText("jButton2");
        logOutButton.addActionListener(evt -> logOutButtonActionPerformed(evt));

        themButton.setText("jButton1");
        themButton.addActionListener(evt -> themButtonActionPerformed(evt));

        userNameLabel.setText("jLabel1");

        appNameLabel.setText("jLabel1");

        avatarLabel.setText("jLabel1");

        totalWinsNumber.setText("jLabel1");

        totalWinsLabel.setText("jLabel1");

        totalLostsLabel.setText("jLabel2");

        totalLostsNumber.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(379, 379, 379)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                                        .addComponent(appNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(totalWinsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(totalLostsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(totalWinsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(totalLostsNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(212, 212, 212)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(multiPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(singlePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(changeCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(380, 380, 380)
                                                                .addComponent(themButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(singlePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(totalWinsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(totalLostsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(totalLostsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(multiPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(changeCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(themButton)
                                        .addComponent(logOutButton))
                                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singlePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayerButtonActionPerformed


        main.java.gui.SinglePlayerFrame gamePlayFrame;
        this.dispose();
        gamePlayFrame = new main.java.gui.SinglePlayerFrame();
        gamePlayFrame.setVisible(true);


    }//GEN-LAST:event_singlePlayerButtonActionPerformed

    private void multiPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayerButtonActionPerformed


        MultiplayerLogin multiplayerLogin;
        this.dispose();
        multiplayerLogin = new MultiplayerLogin();
        multiplayerLogin.setVisible(true);


    }

    private void themButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themButtonActionPerformed

        if (activeUser.getSettingId() == 0) {
            activeUser.settingId = 1;
            Database.updateUser(activeUser);
            them();
        } else {

            activeUser.settingId = 0;
            Database.updateUser(activeUser);
            them();

        }


    }//GEN-LAST:event_themButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed

        String[] options = {"yes", "no"};
        int choice = JOptionPane.showOptionDialog(rootPane, "Are you sure?", "LogOut", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "no");

        if (choice == 0) {
            MainMenu menu = null;
            try {
                menu = new MainMenu();
            } catch (FontFormatException | IOException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.activeUser = null;
            Login.userName = null;
            this.dispose();
            menu.setVisible(true);

        }

    }//GEN-LAST:event_logOutButtonActionPerformed

    private void changeCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCharacterActionPerformed

        PickCharacter charactersFrame = new PickCharacter(x, y);
        charactersFrame.setVisible(true);

    }//GEN-LAST:event_changeCharacterActionPerformed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appNameLabel;
    private javax.swing.JLabel avatarLabel;
    private javax.swing.JButton changeCharacter;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton multiPlayerButton;
    private javax.swing.JButton singlePlayerButton;
    private javax.swing.JButton themButton;
    private javax.swing.JLabel totalLostsLabel;
    private javax.swing.JLabel totalLostsNumber;
    private javax.swing.JLabel totalWinsNumber;
    private javax.swing.JLabel totalWinsLabel;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
