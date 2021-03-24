/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


public class User {
    public String username;
    public String password;
    public int settingid;
    public int totallosts;
    public int totalwins;
    
    public User(String username, char[] password, int settingid, int totalwins, int totallosts) {
        this.username = username;
        this.password = String.valueOf(password);
        this.settingid = settingid;
        this.settingid = settingid;
        this.totallosts = totallosts;
        this.totalwins = totalwins;
    }

    public int getTotallosts() {
        return totallosts;
    }

    public int getTotalwins() {
        return totalwins;
    }

    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSettingid() {
        return settingid;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", settingid=" + settingid + '}';
    }

    
    

    
    
    
}