/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author Long
 */
public class ProductAndCount {
    int count;
    ArrayList<ProductDTO> product;

    public ProductAndCount() {
    }

    public ProductAndCount(int count, ArrayList<ProductDTO> product) {
        this.count = count;
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<ProductDTO> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<ProductDTO> product) {
        this.product = product;
    }

    
    
    
   
    
    
}
