/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.processor;

import com.ims.dao.PurchaseDAO;
import com.ims.dao.SaleDAO;
import com.ims.dao.StockDAO;
import com.ims.pojo.Purchase;
import com.ims.pojo.Sale;
import com.ims.pojo.Stock;

/**
 *
 * @author kalad
 */
public class Processor {
    
    private PurchaseDAO purchaseDAO = new PurchaseDAO();
    private SaleDAO saleDAO = new SaleDAO();
    private StockDAO stockDAO = new StockDAO();
    
    public void processPurchase(Purchase purchase) {
        purchaseDAO.addPurchase(purchase);
        Stock stock = new Stock();
        stock.setProductID(purchase.getProductID());
        stock.setQuantity(purchase.getQuantity());
        stock.setSellingPrice(purchase.getPurchasePrice()*1.15); // 15% Margin
        stockDAO.addStock(stock);
    }
    
    public void processSale(Sale sale) {
        saleDAO.addSale(sale);
        Stock stock = new Stock();
        stock.setProductID(sale.getProductID());
        stock.setQuantity(sale.getQuantity());
        stock.setSellingPrice(sale.getSalePrice()); // retain the sales price
        stockDAO.reduceStock(stock);
    }
}
