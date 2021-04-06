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
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utils.Utility;

/**
 *
 * @author Amir reza
 */
public class Login extends javax.swing.JFrame {

    private JFrame mainFrame;
    public static String userName;

    /**
     * Creates new form Login
     *
     * @param jf
     */
    public Login(JFrame jf) {
        initComponents();
        myInit();
        this.mainFrame = jf;

    }

    public Login() {

    }

    private void myInit() {

        setIcon();
        setThem();
        setText();
        setFrameCenter();
        try {
            setFont();
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void setIcon() {
        iconLable.setIcon(MyIcon.myIcon(Links.MAINREGISTERLOGINICON, iconLable, 0));
    }

    private void setFrameCenter() {
        Utility.centerLocation(this);

    }

    private void setThem() {
        Utility.setThemForButton(MyColor.WHITE, MyColor.BLACK, loginButton, backToMainButton);
        Utility.setThemForLable(MyColor.MYGREEN, MyColor.BLACK, usernameLable, passwordLable);
        Utility.setThemForPanel(MyColor.MYGREEN, jPanel2);
    }

    private void setText() {
        loginButton.setText("Login");
        backToMainButton.setText("Back");
        usernameLable.setText("username");
        passwordLable.setText("password");
        userNameFeild.setText("");
        passwordFeild.setText("");

    }

    private void setFont() throws FontFormatException, IOException {
        MyFont.setMyFont(Links.MAINFONT, MyFont.PLAIN, 30, loginButton, usernameLable, passwordLable, backToMainButton);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        usernameLable = new javax.swing.JLabel();
        passwordLable = new javax.swing.JLabel();
        passwordFeild = new javax.swing.JPasswordField();
        userNameFeild = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        backToMainButton = new javax.swing.JButton();
        iconpanel = new javax.swing.JPanel();
        iconLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        usernameLable.setText("username");

        passwordLable.setText("password");

        passwordFeild.setText("jPasswordField1");

        userNameFeild.setText("jTextField1");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        backToMainButton.setText("Login");
        backToMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(backToMainButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(usernameLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(passwordLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(backToMainButton)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        iconpanel.setPreferredSize(new java.awt.Dimension(400, 600));

        iconLable.setText("jLabel1");

        javax.swing.GroupLayout iconpanelLayout = new javax.swing.GroupLayout(iconpanel);
        iconpanel.setLayout(iconpanelLayout);
        iconpanelLayout.setHorizontalGroup(
            iconpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconLable, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );
        iconpanelLayout.setVerticalGroup(
            iconpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(iconpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        userName = userNameFeild.getText();
        
        int check = Database.countUser(userName);
        String password = String.valueOf(passwordFeild.getPassword());

        switch (check) {

            case 0 -> {

                JOptionPane.showMessageDialog(rootPane, "There is no account with this username!");
                userNameFeild.setText("");
                passwordFeild.setText("");
                
                
                
                break;

            }

            case 1 -> {
                int checkPassword = Database.checkPassword(userName, password);

                if (checkPassword == 0) {
                    JOptionPane.showMessageDialog(rootPane, "The password is wrong!");
                userNameFeild.setText("");
                passwordFeild.setText("");
                } else {
                Dashboard dashboard = new Dashboard();
                this.dispose();
                dashboard.setVisible(true);
                }
                
                break;
            }
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    private void backToMainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainButtonActionPerformed
        this.dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_backToMainButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMainButton;
    private javax.swing.JLabel iconLable;
    private javax.swing.JPanel iconpanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordFeild;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JTextField userNameFeild;
    private javax.swing.JLabel usernameLable;
    // End of variables declaration//GEN-END:variables

}
