/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.db.MySQLConnection;
import com.ims.pojo.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kalad
 */
public class StockDAO {

    private static final String SQL_ADD_STOCK = "insert into ims.stock \n"
            + "values ( ? , ? , ? ) \n"
            + "on DUPLICATE KEY UPDATE \n"
            + " quantity = quantity + values(quantity), selling_price = values(selling_price)";

    private static final String SQL_REDUCE_STOCK = "insert into ims.stock \n"
            + "values ( ? , ? , ? ) \n"
            + "on DUPLICATE KEY UPDATE \n"
            + " quantity = quantity - values(quantity), selling_price = values(selling_price)";
    
    public void addStock(Stock stock) {

        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_STOCK);
            statement.setInt(1, stock.getProductID());
            statement.setInt(2, stock.getQuantity());
            statement.setDouble(3, stock.getSellingPrice());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
    }
        
    public void reduceStock(Stock stock) {

        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_REDUCE_STOCK);
            statement.setInt(1, stock.getProductID());
            statement.setInt(2, stock.getQuantity());
            statement.setDouble(3, stock.getSellingPrice());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

}
