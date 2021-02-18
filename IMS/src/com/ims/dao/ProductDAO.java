/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.db.MySQLConnection;
import com.ims.pojo.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kalad
 */
public class ProductDAO {

    private static final String SQL_INSERT = "INSERT INTO ims.product (product_id, product_name, product_desc, package_size) VALUES(?,?,?,?)";
    private static final String SQL_SELECT = "SELECT product_id, product_name, product_desc, package_size FROM ims.product";

    public void addProducts(List<Product> products) {

        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);

            for (Product product : products) {
                statement.setInt(1, product.getProductID());
                statement.setString(2, product.getProductName());
                statement.setString(3, product.getProductDesc());
                statement.setString(4, product.getPackageSize());

                statement.addBatch();

            }
            statement.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
    }
    
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT);

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    Product product = new Product();
                    product.setProductID(Integer.valueOf(resultSet.getString("product_id")));
                    product.setProductName(resultSet.getString("product_name"));
                    product.setProductDesc(resultSet.getString("product_desc"));
                    product.setPackageSize(resultSet.getString("package_size"));
                    products.add(product);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQLConnection.closeConnection();
        }
        return products;
    }

}
