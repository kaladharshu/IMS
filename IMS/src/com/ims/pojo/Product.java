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
public class Product {
    private Integer productID;
    private String productName;
    private String productDesc;
    private String packageSize;
    private Double retailPrice;
    private Double sellingPrice;

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
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
}
