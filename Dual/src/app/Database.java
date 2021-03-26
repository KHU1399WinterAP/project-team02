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
public  class Database {
    private static Connection connection = null;

   
    static {

        try {

             connection = DriverManager.getConnection(Links.database_url, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);
                        System.err.println("1");
            
        } catch (SQLException e) {
                        System.err.println("2");

        }
    }
    
  public static int count_user(String username){
  
        try {
            int user = -1 ;
            ArrayList<Integer> users = new ArrayList<Integer>();
            Statement statement = connection.createStatement();
            String query = "SELECT COUNT(username) FROM users WHERE username = '" + username + "' ";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                user = resultSet.getInt("COUNT(username)");
                users.add(user);
                
            
            
            }
            
            return users.get(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
  
        
 }
  
  
  public static void insert_into_users(User user){
  
  Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO users (username,password,settingid,totalwins,totallosts,avatarid) VALUES('" + user.username + "' , '"
            + user.password + "', '" + user.settingid + "', '" + user.totalwins + "', '" + user.totallosts + "', '" + user.avatarid + "')";
            statement.executeUpdate(query);
            System.err.println("3");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("4");
        }
  
  }
  
  public static User get_user(String username){
  
                System.err.println("-1");
            

        try {
            System.err.println("0");
            System.err.println("5");

            String query = "SELECT * FROM users WHERE username = '" + username + "' ";

            Statement statement = connection.createStatement();
            
            
            System.err.println("2");
            ResultSet resultSet = statement.executeQuery(query);
            System.err.println("10");
                System.err.println(resultSet);
            String x = null,f;
            int z = 0;
            int g = 0;
            int l = 0;
            int h = 0;
            char[] y = null;
            while (resultSet.next())
                {
               x = resultSet.getString("username");
            System.err.println("11");
             f = resultSet.getString("password");
             y = f.toCharArray();
            System.err.println("13");
             z = resultSet.getInt("settingid");
             g = resultSet.getInt("totalwins");
             l = resultSet.getInt("totallosts");
             h = resultSet.getInt("avatarid");
            }

                 User user = new User(x, y , z, g, l, h);

            
            
            System.err.println(user);
            return user;
            
        } catch (SQLException ex) {
            System.err.println("8");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("7");
            return null;
        }
  
        
 }
  public static void update_user(User user){
  
  Statement statement;
        try {
            statement = connection.createStatement();
            String query = "UPDATE users SET password = '" + user.password + 
            "', settingid = '" + user.settingid + "' ,totalwins = '" + user.totalwins + "',totallosts = '" + 
            user.totallosts+ "',avatarid = '" + user.avatarid + "' WHERE username = '" + user.username + "' ";
            statement.executeUpdate(query);
            System.err.println("3");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("4");
        }
  
  
  }
  
  
}
