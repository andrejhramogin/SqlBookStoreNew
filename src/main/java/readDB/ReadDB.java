package readDB;

import connectionDB.ConnectionDB;
import create_table.TableCreate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReadDB {
    public static ResultSet resultSet;

    public static void readDB() throws SQLException {
        resultSet = TableCreate.statement.executeQuery("Select * from Books");
        while(resultSet.next()){
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            int pages = resultSet.getInt("Pages");
            double price = resultSet.getDouble("Price");

            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "pages = " + pages );
            System.out.println("price = " + price);
            System.out.println();
        }
    }

    public static void findBooksByPages()throws SQLException{
        resultSet = TableCreate.statement.executeQuery("Select Name, Pages from Books WHERE Pages > 600");
        while(resultSet.next()){
//            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            int pages = resultSet.getInt("Pages");

//            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "pages = " + pages );

            System.out.println();
        }

    }

}

