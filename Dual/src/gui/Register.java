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
 *
 * @author Amir reza
 */

public class Register extends javax.swing.JFrame {
    private ImageIcon imageIcon;
    private JFrame jf;
    static String username;
    /*
     * Creates new form Register
     */
    public Register(JFrame jf) {
        
        initComponents();
        my_inint();
        this.jf = jf;
    }

    public Register() {
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
        iconlable.setIcon(MyIcon.myicon(Links.m_r_l_icon, iconlable));
    }
    
    private void set_forground(){
        //new Color(12, 174, 75)
        registerbutton.setForeground(MyColor.BLACK);
        backtomainbutton.setForeground(MyColor.BLACK);
        usernamelable.setForeground(MyColor.BLACK);
        passwordlable.setForeground(MyColor.BLACK);
    }
    
    private void set_backround(){
        registerbutton.setBackground(MyColor.WHITE);
        passwordfeild.setBackground(MyColor.WHITE);
        usernamefeild.setBackground(MyColor.WHITE);
        backtomainbutton.setBackground(MyColor.WHITE);
        jPanel2.setBackground(MyColor.green);

    }
    
    private void set_text(){
        registerbutton.setText("Register");
        backtomainbutton.setText("Back");
        usernamelable.setText("username");
        passwordlable.setText("password");
        
    }
    
    
    
    private void set_font() throws FontFormatException, IOException{
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 30, registerbutton);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 30, usernamelable);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 30, passwordlable);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 30, backtomainbutton);
    }
    
    private boolean input_check(){
    
        
    
    
    
    return true;
    }
    
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconpanel = new javax.swing.JPanel();
        iconlable = new javax.swing.JLabel(imageIcon);
        jPanel2 = new javax.swing.JPanel();
        usernamelable = new javax.swing.JLabel();
        passwordlable = new javax.swing.JLabel();
        passwordfeild = new javax.swing.JPasswordField();
        usernamefeild = new javax.swing.JTextField();
        registerbutton = new javax.swing.JButton();
        backtomainbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        iconpanel.setPreferredSize(new java.awt.Dimension(400, 600));

        iconlable.setText("jLabel1");

        javax.swing.GroupLayout iconpanelLayout = new javax.swing.GroupLayout(iconpanel);
        iconpanel.setLayout(iconpanelLayout);
        iconpanelLayout.setHorizontalGroup(
            iconpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconlable, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );
        iconpanelLayout.setVerticalGroup(
            iconpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconlable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        usernamelable.setText("username");

        passwordlable.setText("password");

        passwordfeild.setText("jPasswordField1");

        usernamefeild.setText("jTextField1");

        registerbutton.setText("Register");
        registerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbuttonActionPerformed(evt);
            }
        });

        backtomainbutton.setText("Login");
        backtomainbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtomainbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernamelable, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernamefeild)
                                .addComponent(passwordfeild, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(passwordlable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(registerbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(backtomainbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(usernamelable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamefeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(passwordlable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordfeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(registerbutton)
                .addGap(18, 18, 18)
                .addComponent(backtomainbutton)
                .addContainerGap(201, Short.MAX_VALUE))
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

    private void registerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbuttonActionPerformed

        username = usernamefeild.getText();
        int check = Database.select_allusers(username);

        switch(check){
            
            case 0 -> {
                
                Database.insert_into_users(new User(usernamefeild.getText(), passwordfeild.getPassword(), 0, 0, 0));
                JOptionPane.showMessageDialog(rootPane, "You successfully have registered!");
                        this.dispose();
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                
                
            }
        
            case 1 ->{ JOptionPane.showMessageDialog(rootPane, "This username is not available!");
            usernamefeild.setText("");
            passwordfeild.setText("");
                    }
        }
               
        
    }//GEN-LAST:event_registerbuttonActionPerformed

    private void backtomainbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtomainbuttonActionPerformed
        this.dispose();
        jf.setVisible(true);
    }//GEN-LAST:event_backtomainbuttonActionPerformed

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
    private javax.swing.JButton backtomainbutton;
    private javax.swing.JLabel iconlable;
    private javax.swing.JPanel iconpanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordfeild;
    private javax.swing.JLabel passwordlable;
    private javax.swing.JButton registerbutton;
    private javax.swing.JTextField usernamefeild;
    private javax.swing.JLabel usernamelable;
    // End of variables declaration//GEN-END:variables
}
