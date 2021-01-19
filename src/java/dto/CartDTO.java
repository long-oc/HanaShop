/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Long
 */
public class CartDTO implements Serializable{

     String customerName;
     Map<Integer, Purchased> cart;

    public CartDTO() {
        this.customerName = "";
        cart = new HashMap<>();
    }

    public CartDTO(String customerName, Map<Integer, Purchased> cart) {
        this.customerName = customerName;
        this.cart = cart;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<Integer, Purchased> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Purchased> cart) {
        this.cart = cart;
    }

    public boolean add(Purchased dto) {
        if (cart == null) {
            this.cart = new HashMap<>();
        }

        for (Map.Entry<Integer, Purchased> entry : cart.entrySet()) {
            Integer key = entry.getKey();
            Purchased value = entry.getValue();
            if (key == dto.getId()) {
                value.setQuantity(value.getQuantity() + 1);
                return true;
            }
            
        }
        cart.put(dto.getId(), dto);
        return true;
    }
}
