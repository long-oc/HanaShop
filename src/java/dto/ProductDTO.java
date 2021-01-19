/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Timestamp;



/**
 *
 * @author Long
 */
public class ProductDTO {
    int productID;
    String productName;
    float productPrice;
    String madeIn;
    String image;
    String decription;
    int quantity;
    Timestamp createDate;
    int cateID;
    boolean status;

    public ProductDTO(int productID, String productName, float productPrice, String madeIn, String image, String decription, int quantity, Timestamp createDate, int cateID, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.madeIn = madeIn;
        this.image = image;
        this.decription = decription;
        this.quantity = quantity;
        this.createDate = createDate;
        this.cateID = cateID;
        this.status = status;
    }

    public ProductDTO() {
        
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
