/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.db.MySQLConnection;
import com.ims.pojo.Product;
import com.ims.pojo.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kalad
 */
public class PurchaseDAO {

    private static final String SQL_INSERT = "INSERT INTO ims.purchase (product_id, quantity, purchase_date, purchase_price) VALUES(?,?,?,?)";

    private static final String SQL_SELECT = "SELECT product_id, quantity, "
            + "purchase_date, purchase_price FROM ims.purchase order by purchase_date desc";
    public void addPurchase(Purchase purchase) {

        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, purchase.getProductID());
            statement.setInt(2, purchase.getQuantity());
            statement.setDate(3, purchase.getPurchaseDate());
            statement.setDouble(4, purchase.getPurchasePrice());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

    public List<Purchase> getAllPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    Purchase purchase = new Purchase();
                    purchase.setProductID(Integer.valueOf(resultSet.getString("product_id")));
                    purchase.setQuantity(resultSet.getInt("quantity"));
                    purchase.setPurchaseDate(resultSet.getDate("purchase_date"));
                    purchase.setPurchasePrice(resultSet.getDouble("purchase_price"));
                    purchases.add(purchase);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
        return purchases;
    }

}
