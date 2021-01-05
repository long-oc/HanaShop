/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Long
 */
public class MyConnection {

    public static void main(String[] args) throws NamingException, SQLException {
        System.out.print(MyConnection.getConnection());
    }

    public static Connection getConnection() throws NamingException, SQLException {
//	{
//		Connection conn=null;
//		Context context=new InitialContext();
//		Context end=(Context) context.lookup("java:comp/env");
//		DataSource ds=(DataSource) end.lookup("DBCon");
//		conn=ds.getConnection();
//		return conn;
//	}

        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HanaShop";
            conn = DriverManager.getConnection(url, "sa", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
