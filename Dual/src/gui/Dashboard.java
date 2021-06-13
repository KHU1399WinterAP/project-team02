/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.Database;
import app.Links;
import app.MyColor;
import app.MyFont;
import app.MyIcon;
import app.User;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import utils.Utility;
/**
 *
 * @author Amir reza
 */
public class Dashboard extends javax.swing.JFrame {

    int x, y;

    private User activeUser = Database.getUser((Login.userName == null) ? Register.userName : Login.userName);

    /**
     * Creates new form Dashboard
     *
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
        iconLable.setIcon(MyIcon.myIcon(Links.DASHBOARDICON, iconLable, 0));
        setSpaceShipCharacter(activeUser, avatarLable);
    }

    private static void setSpaceShipCharacter(User activeUser, JLabel avatarLable) {
        switch (activeUser.getAvatarId()) {

            case 1 ->
                avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR1, avatarLable, 0));

            case 2 ->
                avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR2, avatarLable, 0));
            case 3 ->
                avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR3, avatarLable, 0));
            case 4 ->
                avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR4, avatarLable, 0));
            case 5 ->
                avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR5, avatarLable, 0));
            case 6 ->
                avatarLable.setIcon(MyIcon.myIcon(Links.AVATAR6, avatarLable, 0));
        }
    }

    private void setDarkIcon() {
        iconLable.setIcon(MyIcon.myIcon(Links.DARKDASHBOARDICON, iconLable, 0));
        setSpaceShipCharacter(activeUser, avatarLable);
    }

    private void setForeground() {
        //new Color(12, 174, 75)
        multiPlayerButton.setForeground(MyColor.white);
        singlePlayerButton.setForeground(MyColor.white);
        userNameLable.setForeground(MyColor.white);
        logOutButton.setForeground(MyColor.white);
        themButton.setForeground(MyColor.white);
        appNameLable.setForeground(MyColor.white);
        changeCharacter.setForeground(MyColor.white);
        totalLostsLable.setForeground(MyColor.white);
        totalLostsNumber.setForeground(MyColor.white);
        totalwWinsLable.setForeground(MyColor.white);
        totalWinsNumber.setForeground(MyColor.white);

    }

    private void setDarkForeground() {
        multiPlayerButton.setForeground(MyColor.DARKFONT);
        singlePlayerButton.setForeground(MyColor.DARKFONT);
        userNameLable.setForeground(MyColor.DARKFONT);
        logOutButton.setForeground(MyColor.DARKFONT);
        themButton.setForeground(MyColor.DARKFONT);
        appNameLable.setForeground(MyColor.DARKFONT);
        changeCharacter.setForeground(MyColor.DARKFONT);
        totalLostsLable.setForeground(MyColor.DARKFONT);
        totalLostsNumber.setForeground(MyColor.DARKFONT);
        totalwWinsLable.setForeground(MyColor.DARKFONT);
        totalWinsNumber.setForeground(MyColor.DARKFONT);

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
        jPanel1.setBackground(MyColor.MYRED);
        multiPlayerButton.setBackground(MyColor.MYGREEN);
        singlePlayerButton.setBackground(MyColor.MYGREEN);
        logOutButton.setBackground(MyColor.MYGREEN);
        themButton.setBackground(MyColor.MYGREEN);
        appNameLable.setBackground(MyColor.MYRED);
        changeCharacter.setBackground(MyColor.MYGREEN);
        totalLostsLable.setBackground(MyColor.MYGREEN);
        totalLostsNumber.setBackground(MyColor.MYGREEN);
        totalwWinsLable.setBackground(MyColor.MYGREEN);
        totalWinsNumber.setBackground(MyColor.MYGREEN);

    }

    private void setDarkBackground() {
        jPanel1.setBackground(MyColor.DARKBACKGROUND);
        multiPlayerButton.setBackground(MyColor.DARKBUTTONCOLOR);
        singlePlayerButton.setBackground(MyColor.DARKBUTTONCOLOR);
        logOutButton.setBackground(MyColor.DARKBUTTONCOLOR);
        themButton.setBackground(MyColor.DARKBUTTONCOLOR);
        appNameLable.setBackground(MyColor.DARKBACKGROUND);
        changeCharacter.setBackground(MyColor.DARKBUTTONCOLOR);
        totalLostsLable.setBackground(MyColor.DARKBUTTONCOLOR);
        totalLostsNumber.setBackground(MyColor.DARKBUTTONCOLOR);
        totalwWinsLable.setBackground(MyColor.DARKBUTTONCOLOR);
        totalWinsNumber.setBackground(MyColor.DARKBUTTONCOLOR);

    }

    private void setText() {
        multiPlayerButton.setText("<html>Multi<br />Player</html>");
        logOutButton.setText("LogOut");
        userNameLable.setText("username");
        singlePlayerButton.setText("<html>Single<br />Player</html>");
        themButton.setText("Them");
        appNameLable.setText("Duall");
        iconLable.setText("");
        changeCharacter.setText("Change Character");
        userNameLable.setText(activeUser.getUserName());
        totalLostsLable.setText("<html>Total<br />Losts</html>");
        totalwWinsLable.setText("<html>Total<br />Wins</html>");
        totalWinsNumber.setText(String.valueOf(activeUser.getTotalWins()));
        totalLostsNumber.setText(String.valueOf(activeUser.getTotalLosts()));

    }

    private void setFont() throws FontFormatException, IOException {
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 15, logOutButton);
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 30, userNameLable);
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 40, singlePlayerButton);
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 40, multiPlayerButton);
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 15, themButton);
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 20, changeCharacter);
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 30, totalLostsLable);
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 30, totalwWinsLable);
        appNameLable.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
        totalWinsNumber.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
        totalLostsNumber.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
    }

    private void click() {
        avatarLable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                PickAvatar pickAvatar = new PickAvatar(x, y, avatarLable);

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
        iconLable = new javax.swing.JLabel();
        changeCharacter = new javax.swing.JButton();
        multiPlayerButton = new javax.swing.JButton();
        singlePlayerButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        themButton = new javax.swing.JButton();
        userNameLable = new javax.swing.JLabel();
        appNameLable = new javax.swing.JLabel();
        avatarLable = new javax.swing.JLabel();
        totalWinsNumber = new javax.swing.JLabel();
        totalwWinsLable = new javax.swing.JLabel();
        totalLostsLable = new javax.swing.JLabel();
        totalLostsNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(810, 600));

        iconLable.setText("jLabel1");

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

        userNameLable.setText("jLabel1");

        appNameLable.setText("jLabel1");

        avatarLable.setText("jLabel1");

        totalWinsNumber.setText("jLabel1");

        totalwWinsLable.setText("jLabel1");

        totalLostsLable.setText("jLabel2");

        totalLostsNumber.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avatarLable, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(userNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(379, 379, 379)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iconLable, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(appNameLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalwWinsLable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalLostsLable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(appNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconLable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(avatarLable, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(singlePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalwWinsLable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalWinsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalLostsLable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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

                
        gui.SinglePlayerFrame gamePlayFrame ;
        this.dispose();
        gamePlayFrame = new gui.SinglePlayerFrame();
        gamePlayFrame.setVisible(true);


    }//GEN-LAST:event_singlePlayerButtonActionPerformed

    private void multiPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayerButtonActionPerformed


        MultiplayerLogin multiplayerLogin ;
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
    private javax.swing.JLabel appNameLable;
    private javax.swing.JLabel avatarLable;
    private javax.swing.JButton changeCharacter;
    private javax.swing.JLabel iconLable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton multiPlayerButton;
    private javax.swing.JButton singlePlayerButton;
    private javax.swing.JButton themButton;
    private javax.swing.JLabel totalLostsLable;
    private javax.swing.JLabel totalLostsNumber;
    private javax.swing.JLabel totalWinsNumber;
    private javax.swing.JLabel totalwWinsLable;
    private javax.swing.JLabel userNameLable;
    // End of variables declaration//GEN-END:variables
}
