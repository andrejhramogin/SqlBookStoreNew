package readDB;

import connectionDB.ConnectionDB;
import create_table.TableCreate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReadDB {
    public static ResultSet resultSet;


    //Вывод всей таблицы
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

    //Поиск по количеству страниц
    public static void findBooksByPages()throws SQLException{
        resultSet = TableCreate.statement.executeQuery("Select ID, Name, Pages from Books WHERE Pages > 600");
        while(resultSet.next()){
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            int pages = resultSet.getInt("Pages");

            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "pages = " + pages );

            System.out.println();
        }
    }

    //поиск по первым буквам в названии
    public static void findBooksByFirstLetter()throws SQLException{
        resultSet = TableCreate.statement.executeQuery("SELECT ID, Name FROM Books WHERE Name LIKE 'А%' OR NAME LIKE 'З%'");
        while(resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            System.out.println("ID = " + id);
            System.out.println("name = " + name);
            System.out.println();
        }
    }

}

