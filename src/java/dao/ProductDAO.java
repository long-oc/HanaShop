/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CateDTO;
import dto.ProductAdminDTO;
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
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
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
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return list;
    }

    public ArrayList<CateDTO> getCateByID(int Id) throws NamingException, SQLException {
        ArrayList<CateDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            String query = "select cateID,cateName,status from tblCategorys c where c.cateID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Id);
            rs = ps.executeQuery();

            if (rs.next()) {
                list.add(new CateDTO(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return list;
    }

    public ArrayList<ProductAdminDTO> getProductWithPageing(int pageIndex) throws NamingException, SQLException {
        ArrayList<ProductAdminDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();

            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,p.cateID,c.cateName,p.status from tblProducts p,tblCategorys c \n"
                    + "where p.cateID=c.cateID\n"
                    + "               ORDER BY p.createDate\n"
                    + "                OFFSET ? ROWS\n"
                    + "                FETCH NEXT 100 ROWS ONLY";

            ps = con.prepareStatement(query);
            ps.setInt(1, pageIndex);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductAdminDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getTimestamp(8), rs.getInt(9), rs.getString(10), rs.getBoolean(11)));
            }

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws SQLException, NamingException {
        System.out.println(new ProductDAO().getListProductRecomment(2));
    }
    public ArrayList<Integer> getListProductRecomment(int productID) throws NamingException, SQLException {
        ArrayList<Integer> listIDproductRecomment = new ArrayList<>();
        try {
            con = MyConnection.getConnection();

            String query = "select top 3  productRecommentID from tblRecommendations where productID = ? and status = 1 and productID != productRecommentID\n"
                    + "order by NEWID()";
            ps = con.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {        
                listIDproductRecomment.add(rs.getInt(1));
            }

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return listIDproductRecomment;
    }

    public boolean updateItem(ProductAdminDTO productAdminDTO) {
        try {
            con = MyConnection.getConnection();
            String query = "UPDATE tblProducts\n"
                    + " SET productName=?,productPrice=?,cateID=?,decription=?,image=?,madeIn=?,quantity=?,status=?\n"
                    + " WHERE productID = ?;";
            ps = con.prepareStatement(query);
            ps.setString(1, productAdminDTO.getProductName());
            ps.setFloat(2, productAdminDTO.getProductPrice());
            ps.setInt(3, productAdminDTO.getCateID());
            ps.setString(4, productAdminDTO.getDecription());
            ps.setString(5, productAdminDTO.getImage());
            ps.setString(6, productAdminDTO.getMadeIn());
            ps.setInt(7, productAdminDTO.getQuantity());
            ps.setBoolean(8, productAdminDTO.isStatus());
            ps.setInt(9, productAdminDTO.getProductID());
            boolean rs;
            if (rs = ps.executeUpdate() > 0) {
                return true;
            }
        } catch (NamingException ex) {

        } catch (SQLException ex) {

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return false;

    }

    public ArrayList<ProductDTO> getProductDefault(int cateID) throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,cateID,status from tblProducts p where p.cateID=? \n"
                    + "ORDER BY p.createDate\n"
                    + "OFFSET 0 ROWS\n"
                    + "FETCH NEXT 4 ROWS ONLY;";

            ps = con.prepareStatement(query);
            ps.setInt(1, cateID);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getTimestamp(8), rs.getInt(9), rs.getBoolean(10)));
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return list;
    }

    public ArrayList<ProductDTO> getProductSearchWithOutPrice(int pageIndex, int idCate, String searchKey) throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();

            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,p.cateID,p.status from tblProducts p,tblCategorys c \n"
                    + "where p.cateID=c.cateID and c.cateID=? and( p.productName like ? or c.cateName like ? )\n"
                    + "               ORDER BY p.createDate\n"
                    + "                OFFSET ? ROWS\n"
                    + "                FETCH NEXT 4 ROWS ONLY";

            ps = con.prepareStatement(query);
            ps.setInt(1, idCate);

            ps.setString(2, "%" + searchKey + "%");
            ps.setString(3, "%" + searchKey + "%");
            ps.setInt(4, pageIndex);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getTimestamp(8), rs.getInt(9), rs.getBoolean(10)));
            }

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return list;
    }

    public ArrayList<ProductDTO> getProductWithFilter(int pageIndex, int idCate, float price, String searchKey) throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();

            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,p.cateID,p.status from tblProducts p,tblCategorys c \n"
                    + "where p.cateID=c.cateID and c.cateID=? and p.productPrice <= ? and( p.productName like ? or c.cateName like ? )\n"
                    + "               ORDER BY p.createDate\n"
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
                list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getTimestamp(8), rs.getInt(9), rs.getBoolean(10)));
            }

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return list;
    }

    public ArrayList<ProductDTO> getMoreProductWithCate(int pageindex, int cateID) throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,cateID,status from tblProducts p where p.cateID=? \n"
                    + "ORDER BY p.createDate\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 4 ROWS ONLY;";

            ps = con.prepareStatement(query);
            ps.setInt(1, cateID);
            ps.setInt(2, pageindex);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getTimestamp(8), rs.getInt(9), rs.getBoolean(10)));
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return list;
    }

    public ProductDTO getProductByID(int productID) throws NamingException, SQLException {

        try {
            con = MyConnection.getConnection();
            String query = "select productID,productName,productPrice, madeIn,image,decription,quantity,createDate,cateID,status from tblProducts p where p.productID=? \n"
                    + "ORDER BY p.createDate\n";
            ps = con.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getTimestamp(8), rs.getInt(9), rs.getBoolean(10));
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
        return null;
    }

}
