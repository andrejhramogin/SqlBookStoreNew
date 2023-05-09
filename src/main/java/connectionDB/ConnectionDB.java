package connectionDB;

import java.sql.*;

public class ConnectionDB {

    public static Connection connection;

    public static void conn() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection("jdbc:sqlite:bookshop.BookShop.s3db");
        System.out.println("База подключена!");
    }

    public static void connectionClose()throws SQLException{
        connection.close();
    }
}
