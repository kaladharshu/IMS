/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.pojo.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kalad
 */
public class ProductDAOTest {
    public static void main(String args[]) {
        
    ProductDAO productDAO = new ProductDAO();
    List<Product> products;
    
    //Retrieve all products
    products = productDAO.getAllProducts();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        
    //Add a product
//    products = new ArrayList<Product>();
//    Product product = new Product();
//    product.setProductID(107);
//    product.setProductName("Mrianda");
//    product.setProductDesc("soft drinks");
//    product.setPackageSize("0.5L");

//    products.add(product);

//    productDAO.addProducts(products);
    
    }
}
 