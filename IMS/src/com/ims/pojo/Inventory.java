/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.pojo;

/**
 *
 * @author kalad
 */
public class Inventory {
    private Integer productID;
    private String ProductName;
    private String productDesc;
    private Integer onHandQty;
    private Double retailPrice;
    private Double sellingPrice;
    private String packageSize;
    private Double stockValue;

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
     * @return the ProductName
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * @param ProductName the ProductName to set
     */
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    /**
     * @return the productDesc
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * @param productDesc the productDesc to set
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * @return the onHandQty
     */
    public Integer getOnHandQty() {
        return onHandQty;
    }

    /**
     * @param onHandQty the onHandQty to set
     */
    public void setOnHandQty(Integer onHandQty) {
        this.onHandQty = onHandQty;
    }

    /**
     * @return the retailPrice
     */
    public Double getRetailPrice() {
        return retailPrice;
    }

    /**
     * @param retailPrice the retailPrice to set
     */
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * @return the sellingPrice
     */
    public Double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return the stockValue
     */
    public Double getStockValue() {
        calculateStockValue();
        return stockValue;
    }
    
    private void calculateStockValue() {
        this.stockValue = this.onHandQty * this.sellingPrice;
    }

    /**
     * @return the packageSize
     */
    public String getPackageSize() {
        return packageSize;
    }

    /**
     * @param packageSize the packageSize to set
     */
    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }
    
}
