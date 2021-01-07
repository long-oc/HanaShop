/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CateDTO;
import dto.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import ultis.MyConnection;

/**
 *
 * @author Long
 */
public class ProductDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<CateDTO> getAllCate() throws NamingException, SQLException {
        ArrayList<CateDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            String query = "select cateID,cateName,status from tblCategorys";
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CateDTO(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<ProductDTO> getAllPeoduct() throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,cateID,status from tblProducts";
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9), rs.getBoolean(10)));
            }

        } catch (Exception e) {
        }
        return list;
    }
}
