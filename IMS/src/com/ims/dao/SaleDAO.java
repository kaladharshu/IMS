/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.db.MySQLConnection;
import com.ims.pojo.Purchase;
import com.ims.pojo.Sale;
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
public class SaleDAO {
    
    private static final String SQL_INSERT = "INSERT INTO ims.sale (product_id, quantity, sale_date, sale_price) VALUES(?,?,?,?)";

    private static final String SQL_SELECT = "SELECT product_id, quantity, "
            + "sale_date, sale_price FROM ims.sale order by sale_date desc";
    public void addSale(Sale sale) {

        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, sale.getProductID());
            statement.setInt(2, sale.getQuantity());
            statement.setDate(3, sale.getSaleDate());
            statement.setDouble(4, sale.getSalePrice());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    Sale sale = new Sale();
                    sale.setProductID(Integer.valueOf(resultSet.getString("product_id")));
                    sale.setQuantity(resultSet.getInt("quantity"));
                    sale.setSaleDate(resultSet.getDate("sale_date"));
                    sale.setSalePrice(resultSet.getDouble("sale_price"));
                    sales.add(sale);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
        return sales;
    }

}
