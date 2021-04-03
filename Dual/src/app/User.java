/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


public class User {
    public String userName;
    public String password;
    public int settingId;
    public int toatlLosts;
    public int totalWins;
    public int avatarId;
    public int characterId;
    public User(String username, char[] password, int settingId, int totalWins, int totalLosts, int avatarId, int characterId) {
        this.userName = username;
        this.password = String.valueOf(password);
        this.settingId = settingId;
        this.toatlLosts = totalLosts;
        this.totalWins = totalWins;
        this.avatarId = avatarId;
        this.characterId = characterId;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public int getToatlLosts() {
        return toatlLosts;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getCharacterId() {
        return characterId;
    }

    
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getSettingId() {
        return settingId;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", settingId=" + settingId + ", toatlLosts=" + toatlLosts + ", totalWins=" + totalWins + ", avatarId=" + avatarId + ", characterId=" + characterId + '}';
    }

   
 

   
    

    
    

    
    
    
}