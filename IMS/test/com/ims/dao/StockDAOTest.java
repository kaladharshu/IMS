/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.pojo.Stock;

/**
 *
 * @author kalad
 */
public class StockDAOTest {
    
    public static void main(String args[]) {
    StockDAO stockDAO = new StockDAO();
    Stock stock = new Stock();
    stock.setProductID(101);
    stock.setQuantity(6);
    stock.setSellingPrice(17.50);
    
    stockDAO.addStock(stock);
    
    stock = new Stock();
    stock.setProductID(101);
    stock.setQuantity(2);
    stock.setSellingPrice(17.50);
    
    stockDAO.reduceStock(stock);
            
    }
}
