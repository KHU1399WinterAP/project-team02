/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amir reza
 */
public class Database {

    private static Connection connection = null;

    static {

        try {

            connection = DriverManager.getConnection(Links.DATABASEURL, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);

        } catch (SQLException e) {

        }
    }

    public static int count_user(String username) {

        try {
            int user = -1;
            ArrayList<Integer> users = new ArrayList<>();
            Statement statement = connection.createStatement();
            String query = "SELECT COUNT(username) FROM users WHERE username = '" + username + "' ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                user = resultSet.getInt("COUNT(username)");
                users.add(user);

            }

            return users.get(0);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public static void insertIntoUsers(User user) {

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO users (username,password,settingid,totalwins,totallosts,avatarid,characterid) VALUES('" + user.userName + "' , '"
                    + user.password + "', '" + user.settingId + "', '" + user.totalWins + "', '" + user.toatlLosts + "', '" + user.avatarId + "', '" + user.characterId + "')";
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static User getUser(String username) {

        try {

            String query = "SELECT * FROM users WHERE username = '" + username + "' ";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            String userNameTemp = null, passwordTempString;
            int settingIdTemp = 0;
            int totalWinsTemp = 0;
            int totalLosts = 0;
            int avatarIdTemp = 0;
            int characterIdTemp = 0;
            char[] passwordTemp = null;
            while (resultSet.next()) {
                userNameTemp = resultSet.getString("username");
                passwordTempString = resultSet.getString("password");
                passwordTemp = passwordTempString.toCharArray();
                settingIdTemp = resultSet.getInt("settingid");
                totalWinsTemp = resultSet.getInt("totalwins");
                totalLosts = resultSet.getInt("totallosts");
                avatarIdTemp = resultSet.getInt("avatarid");
                characterIdTemp = resultSet.getInt("characterid");
            }

            User user = new User(userNameTemp, passwordTemp, settingIdTemp, totalWinsTemp, totalLosts, avatarIdTemp, characterIdTemp);

            System.err.println(user);
            return user;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static void updateUser(User user) {

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "UPDATE users SET password = '" + user.password
                    + "', settingid = '" + user.settingId + "' ,totalwins = '" + user.totalWins + "',totallosts = '"
                    + user.toatlLosts + "',avatarid = '" + user.avatarId + "',characterid = '" + user.characterId + "' WHERE username = '" + user.userName + "' ";
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
