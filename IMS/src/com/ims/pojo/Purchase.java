/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.pojo;

import java.sql.Date;

/**
 *
 * @author kalad
 */
public class Purchase {
    private Integer productID;
    private Integer quantity;
    private Date purchaseDate;
    private Double purchasePrice;

    /**
     * @return the productID
     */
    public Integer getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the purchaseDate
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @param purchaseDate the purchaseDate to set
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * @return the purchasePrice
     */
    public Double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * @param purchasePrice the purchasePrice to set
     */
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
}
