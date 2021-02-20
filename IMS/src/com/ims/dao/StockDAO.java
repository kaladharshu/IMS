/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.db.MySQLConnection;
import com.ims.pojo.Inventory;
import com.ims.pojo.Product;
import com.ims.pojo.Stock;
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
public class StockDAO {

    private static final String SQL_ADD_STOCK = "insert into ims.stock \n"
            + "values ( ? , ? , ? ) \n"
            + "on DUPLICATE KEY UPDATE \n"
            + " quantity = quantity + values(quantity), selling_price = values(selling_price)";

    private static final String SQL_REDUCE_STOCK = "insert into ims.stock \n"
            + "values ( ? , ? , ? ) \n"
            + "on DUPLICATE KEY UPDATE \n"
            + " quantity = quantity - values(quantity), selling_price = values(selling_price)";
    
    private static final String SQL_SELECT = "SELECT s.product_id, p.product_name, "
            + "p.product_desc, p.package_size, s.quantity, p.retail_price, s.selling_price "
            + "from ims.stock s "
            + "join ims.product p on p.product_id = s.product_id\n";
    
    public List<Inventory> getAllStock() {
        List<Inventory> products = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    Inventory product = new Inventory();
                    product.setProductID(Integer.valueOf(resultSet.getString("product_id")));
                    product.setProductName(resultSet.getString("product_name"));
                    product.setProductDesc(resultSet.getString("product_desc"));
                    product.setOnHandQty(resultSet.getInt("quantity"));
                    product.setPackageSize(resultSet.getString("package_size"));
                    product.setRetailPrice(resultSet.getDouble("retail_price"));
                    product.setSellingPrice(resultSet.getDouble("selling_price"));
                    products.add(product);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
        return products;
    }

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
