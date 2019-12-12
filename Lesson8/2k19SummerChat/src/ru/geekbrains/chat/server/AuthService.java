package ru.geekbrains.chat.server;

import java.sql.*;
import java.util.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String login, String pass, String nick) {
        try {
            String query = "INSERT INTO main (login, password, nickname) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setInt(2, pass.hashCode());
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addToBlackList(Set<String> blackList, String nick){
        StringBuffer names = new StringBuffer();
        for(String s : blackList){
            names.append(s).append(" ");
        }
        try {
            String query = "UPDATE main SET blocked = '" + names.toString() + "' WHERE nickname = '" + nick + "';";
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname, password FROM main WHERE login = '" + login + "'");
            int myHash = pass.hashCode(); // 137
            if (rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);
                if (myHash == dbHash) {
                    return nick;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Set<String> getBlackList(String nick){
        Set<String> blackList = new LinkedHashSet<>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT blocked FROM main WHERE nickname = '" + nick + "';");
            if (rs.next())
            {
                String list = rs.getString(1);
                if(list != null)
                {
                    String[] tokens = list.split(" ");
                    blackList.addAll(Arrays.asList(tokens));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return blackList;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
