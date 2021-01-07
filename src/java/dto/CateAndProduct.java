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
public class CateAndProduct {
    ArrayList<CateDTO> cate;
    ArrayList<ProductDTO> product;

    public CateAndProduct(ArrayList<CateDTO> cate, ArrayList<ProductDTO> product) {
        this.cate = cate;
        this.product = product;
    }

    public ArrayList<CateDTO> getCate() {
        return cate;
    }

    public void setCate(ArrayList<CateDTO> cate) {
        this.cate = cate;
    }

    public ArrayList<ProductDTO> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<ProductDTO> product) {
        this.product = product;
    }
    
    
   
    
    
}
