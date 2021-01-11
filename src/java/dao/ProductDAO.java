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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public int getNumberProductWithCateID(int cate) {
        try {
            con = MyConnection.getConnection();
            String query = "select count(productID) from tblProducts p where p.cateID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, cate);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return 0;
    }

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

    public ArrayList<ProductDTO> getProductDefault(int cateID) throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,cateID,status from tblProducts p where p.cateID=? \n"
                    + "ORDER BY p.productID\n"
                    + "OFFSET 0 ROWS\n"
                    + "FETCH NEXT 4 ROWS ONLY;";

            ps = con.prepareStatement(query);
            ps.setInt(1, cateID);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9), rs.getBoolean(10)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) throws NamingException, SQLException {
        new ProductDAO().getProductWithFilter(0, 2, 999999, "a");
    }

    public ArrayList<ProductDTO> getProductWithFilter(int pageIndex, int idCate, float price, String searchKey) throws NamingException, SQLException {
        con = MyConnection.getConnection();
        ArrayList<ProductDTO> list = new ArrayList<>();
        String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,p.cateID,p.status from tblProducts p,tblCategorys c \n"
                + "where p.cateID=c.cateID and c.cateID=? and p.productPrice <= ? and( p.productName like ? or c.cateName like ? )\n"
                + "               ORDER BY p.productID\n"
                + "                OFFSET ? ROWS\n"
                + "                FETCH NEXT 4 ROWS ONLY";

        ps = con.prepareStatement(query);
        ps.setInt(1, idCate);
        ps.setFloat(2, price);
        ps.setString(3, "%" + searchKey + "%");
        ps.setString(4, "%" + searchKey + "%");
        ps.setInt(5, pageIndex);
        rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9), rs.getBoolean(10)));
        }
        return list;
    }

    public ArrayList<ProductDTO> getMoreProductWithCate(int pageindex, int cateID) throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,cateID,status from tblProducts p where p.cateID=? \n"
                    + "ORDER BY p.productID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 4 ROWS ONLY;";

            ps = con.prepareStatement(query);
            ps.setInt(1, cateID);
            ps.setInt(2, pageindex);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9), rs.getBoolean(10)));
            }

        } catch (Exception e) {
        }
        return list;
    }

}
