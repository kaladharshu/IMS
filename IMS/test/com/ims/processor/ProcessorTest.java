/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.processor;

import com.ims.pojo.Purchase;
import com.ims.pojo.Sale;
import java.sql.Date;

/**
 *
 * @author kalad
 */
public class ProcessorTest {
    
    public static void main(String args[]) {
        
        Processor processor = new Processor();

//        Purchase purchase = new Purchase();
//        purchase.setProductID(107);
//        purchase.setQuantity(10);
//        purchase.setPurchasePrice(30.00);
//        purchase.setPurchaseDate(new Date(121,2,17));
//        
//        processor.processPurchase(purchase);
        Sale sale = new Sale();
        sale.setProductID(107);
        sale.setQuantity(5);
        sale.setSalePrice(35.00);
        sale.setSaleDate(new Date(121,1,17));
        processor.processSale(sale);
    }
}
