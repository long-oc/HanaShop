/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;
import ultis.MyConnection;

/**
 *
 * @author Long
 */
public class UserDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
 
    public UserDTO checklogin(String user, String pass) throws NamingException, SQLException, NoSuchAlgorithmException {
        con = MyConnection.getConnection();
        String query = "select userID ,userName,email ,roleID ,status from tblUsers where userName=? and password=?";
        ps = con.prepareStatement(query);
        ps.setString(1, user);
        // hash MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        ps.setString(2, myHash);
        rs = ps.executeQuery();
        if (rs.next()) {
            return new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
        }

        return null;

    }
}
