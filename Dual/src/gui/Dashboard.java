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
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amir reza
 */
public class Dashboard extends javax.swing.JFrame {

    int x,y;


    private User active_user = Database.get_user( (Login.username == null) ? Register.username : Login.username);
    /**
     * Creates new form Dashboard
     * 
     */
    public Dashboard() {
        initComponents();
        my_init();
        
        
    }
                                                                           
  
    private void my_init(){
    
    set_location();
    them();
    set_text();
    try {
        set_font();
        } 
    catch (FontFormatException | IOException e) {
        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        } 
    click();
    
    
    
    }
    
    
    
    
    
    public void set_location(){
    
    this.setLocationRelativeTo(null);
    Toolkit tk = this.getToolkit();
    Dimension dim = tk.getScreenSize();
    this.x = (int) dim.getWidth() / 2 - this.getWidth() / 2;
    this.y = (int) dim.getHeight() / 2 - this.getHeight() / 2;
    this.setLocation(x, y);
    
    
    
    
    }

       
       
    public void set_icon(){
        iconlable.setIcon(MyIcon.myicon(Links.dashboardicon, iconlable));
        switch(active_user.getAvatarid() ){
        
        case 1:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar1,avatarlable));
        
            break;
        
        case 2:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar2, avatarlable));
            break;
        case 3:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar3, avatarlable));
            break;
        case 4:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar4, avatarlable));
            break;
        case 5:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar5, avatarlable));
            break;
        case 6:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar6, avatarlable));
            break;
        }
    }
        

    private void set_dark_icon(){
        iconlable.setIcon(MyIcon.myicon(Links.darkdashboardicon, iconlable));
        switch(active_user.getAvatarid() ){
        
        case 1:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar1,avatarlable));
        
            break;
        
        case 2:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar2, avatarlable));
        
        case 3:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar3, avatarlable));
        
        case 4:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar4, avatarlable));
        
        case 5:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar5, avatarlable));
            
        case 6:
            avatarlable.setIcon(MyIcon.myicon(Links.avatar6, avatarlable));
        
        
        }
    }
    
    private void set_forground(){
        //new Color(12, 174, 75)
        multiplayerbutton.setForeground(MyColor.white);
        singleplayerbutton.setForeground(MyColor.white);
        usernamelable.setForeground(MyColor.white);
        logoutbutton.setForeground(MyColor.white);
        thembutton.setForeground(MyColor.white);
        appnamelable.setForeground(MyColor.white);
        change.setForeground(MyColor.white);
        totallostslable.setForeground(MyColor.white);
        totallostsnumber.setForeground(MyColor.white);
        totalwinslable1.setForeground(MyColor.white);
        totalwinsnumber.setForeground(MyColor.white);
        
    }
    
     private void set_dark_forground(){
        //new Color(12, 174, 75)
        multiplayerbutton.setForeground(MyColor.darkfont);
        singleplayerbutton.setForeground(MyColor.darkfont);
        usernamelable.setForeground(MyColor.darkfont);
        logoutbutton.setForeground(MyColor.darkfont);
        thembutton.setForeground(MyColor.darkfont);
        appnamelable.setForeground(MyColor.darkfont);
        change.setForeground(MyColor.darkfont);
        totallostslable.setForeground(MyColor.darkfont);
        totallostsnumber.setForeground(MyColor.darkfont);
        totalwinslable1.setForeground(MyColor.darkfont);
        totalwinsnumber.setForeground(MyColor.darkfont);
        
    }
    private void them(){
        if (active_user.getSettingid() == 0) {
            set_forground();
            set_backround();
            set_icon();
        }
    
        else{
        set_dark_forground();
        set_dark_backround();
        set_dark_icon();
        
        }
    
    
    
    }
    private void set_backround(){
        jPanel1.setBackground(MyColor.red);
        multiplayerbutton.setBackground(MyColor.green);
        singleplayerbutton.setBackground(MyColor.green);
        logoutbutton.setBackground(MyColor.green);
        thembutton.setBackground(MyColor.green);
        appnamelable.setBackground(MyColor.red);
        change.setBackground(MyColor.green);
        totallostslable.setBackground(MyColor.green);
        totallostsnumber.setBackground(MyColor.green);
        totalwinslable1.setBackground(MyColor.green);
        totalwinsnumber.setBackground(MyColor.green);
        
    }
    
    private void set_dark_backround(){
        jPanel1.setBackground(MyColor.darkbackground);
        multiplayerbutton.setBackground(MyColor.darkbuttoncolor);
        singleplayerbutton.setBackground(MyColor.darkbuttoncolor);
        logoutbutton.setBackground(MyColor.darkbuttoncolor);
        thembutton.setBackground(MyColor.darkbuttoncolor);
        appnamelable.setBackground(MyColor.darkbackground);
        change.setBackground(MyColor.darkbuttoncolor);
        totallostslable.setBackground(MyColor.darkbuttoncolor);
        totallostsnumber.setBackground(MyColor.darkbuttoncolor);
        totalwinslable1.setBackground(MyColor.darkbuttoncolor);
        totalwinsnumber.setBackground(MyColor.darkbuttoncolor);
        
    }
    
    private void set_text(){
        multiplayerbutton.setText("<html>Multi<br />Player</html>");
        logoutbutton.setText("LogOut");
        usernamelable.setText("username");
        singleplayerbutton.setText("<html>Single<br />Player</html>");
        thembutton.setText("Them");
        appnamelable.setText("Duall");
        iconlable.setText("");
        change.setText("Change Character");
        usernamelable.setText(active_user.getUsername());
        totallostslable.setText("<html>Total<br />Losts</html>");
        totalwinslable1.setText("<html>Total<br />Wins</html>");
        totalwinsnumber.setText(String.valueOf(active_user.getTotalwins()));
        totallostsnumber.setText(String.valueOf(active_user.getTotallosts()));
        
    }
    
    
    
    private void set_font() throws FontFormatException, IOException{
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 15, logoutbutton);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 30, usernamelable);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 40, singleplayerbutton);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 40, multiplayerbutton);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 15, thembutton);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 20, change);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 30, totallostslable);
        MyFont.set_myfont(Links.mainfont, MyFont.PLAIN, 30, totalwinslable1);
        appnamelable.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
        totalwinsnumber.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
        totallostsnumber.setFont(new Font(MyFont.MONOSPACED, Font.BOLD, 35));
        //appnamelable.setFont(MyFont.BOLD);
        //appnamelable.setSize(40);
    }
    
    
    
    private void click(){
    avatarlable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    PickAvatar pa = new PickAvatar(x, y, avatarlable);

                    pa.setVisible(true);
                    
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
        iconlable = new javax.swing.JLabel();
        change = new javax.swing.JButton();
        multiplayerbutton = new javax.swing.JButton();
        singleplayerbutton = new javax.swing.JButton();
        logoutbutton = new javax.swing.JButton();
        thembutton = new javax.swing.JButton();
        usernamelable = new javax.swing.JLabel();
        appnamelable = new javax.swing.JLabel();
        avatarlable = new javax.swing.JLabel();
        totalwinsnumber = new javax.swing.JLabel();
        totalwinslable1 = new javax.swing.JLabel();
        totallostslable = new javax.swing.JLabel();
        totallostsnumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(810, 600));

        iconlable.setText("jLabel1");

        change.setText("jButton5");

        multiplayerbutton.setText("jButton4");

        singleplayerbutton.setText("jButton3");
        singleplayerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleplayerbuttonActionPerformed(evt);
            }
        });

        logoutbutton.setText("jButton2");
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });

        thembutton.setText("jButton1");
        thembutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thembuttonActionPerformed(evt);
            }
        });

        usernamelable.setText("jLabel1");

        appnamelable.setText("jLabel1");

        avatarlable.setText("jLabel1");

        totalwinsnumber.setText("jLabel1");

        totalwinslable1.setText("jLabel1");

        totallostslable.setText("jLabel2");

        totallostsnumber.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avatarlable, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(usernamelable, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(379, 379, 379)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iconlable, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(appnamelable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalwinslable1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totallostslable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalwinsnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totallostsnumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(212, 212, 212)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(multiplayerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(singleplayerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(380, 380, 380)
                                .addComponent(thembutton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                .addComponent(appnamelable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconlable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usernamelable, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(avatarlable, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(singleplayerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalwinslable1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalwinsnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totallostslable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totallostsnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(multiplayerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thembutton)
                    .addComponent(logoutbutton))
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

    private void singleplayerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleplayerbuttonActionPerformed


        SinglePlayerFrame   spf = new SinglePlayerFrame();
        this.dispose();
        spf.setVisible(true);



    }//GEN-LAST:event_singleplayerbuttonActionPerformed

    private void thembuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thembuttonActionPerformed

        if (active_user.getSettingid() == 0) {
            active_user.settingid = 1;
            Database.update_user(active_user);
            them();
        }
        else{
        
            active_user.settingid = 0;
            Database.update_user(active_user);
            them();
        
        
        }

        
        
    }//GEN-LAST:event_thembuttonActionPerformed

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed

       
        
        
        String[] options = {"yes","no"};
        int choice = JOptionPane.showOptionDialog(rootPane, "Are you sure?", "LogOut", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,"no");

        System.err.println(choice);

        
        if (choice == 0) {
            MainMenu menu = null;
            try {
                menu = new MainMenu();
            } catch (FontFormatException | IOException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            menu.setVisible(true);
            
        }

    }//GEN-LAST:event_logoutbuttonActionPerformed

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
    private javax.swing.JLabel appnamelable;
    private javax.swing.JLabel avatarlable;
    private javax.swing.JButton change;
    private javax.swing.JLabel iconlable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JButton multiplayerbutton;
    private javax.swing.JButton singleplayerbutton;
    private javax.swing.JButton thembutton;
    private javax.swing.JLabel totallostslable;
    private javax.swing.JLabel totallostsnumber;
    private javax.swing.JLabel totalwinslable1;
    private javax.swing.JLabel totalwinsnumber;
    private javax.swing.JLabel usernamelable;
    // End of variables declaration//GEN-END:variables
}
