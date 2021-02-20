/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.db.MySQLConnection;
import com.ims.pojo.Product;
import com.ims.pojo.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kalad
 */
public class UserAccountDAO {

    private static final String SQL_INSERT = "INSERT INTO ims.user_account (user, pass) VALUES(?,?)";
    private static final String SQL_SELECT = "SELECT user, pass FROM ims.user_account where user=? and pass=?";

    public Boolean login(UserAccount userAccount) {
        Boolean isLoginSuccess = false;
        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);

            statement.setString(1, userAccount.getUser());
            statement.setString(2, userAccount.getPass());

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                isLoginSuccess = true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
        return isLoginSuccess;
    }
    
    public Boolean register(UserAccount userAccount) {
        Boolean isLoginSuccess = true;
        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);

            statement.setString(1, userAccount.getUser());
            statement.setString(2, userAccount.getPass());

            statement.executeUpdate();

        } catch (SQLException ex) {
            isLoginSuccess = false;
            Logger.getLogger(UserAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
        return isLoginSuccess;
    }
}
