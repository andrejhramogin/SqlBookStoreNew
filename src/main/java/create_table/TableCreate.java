package create_table;
import connectionDB.ConnectionDB;

import java.sql.*;

public class TableCreate {

    public static Statement statement;

    public static void createDB() throws ClassNotFoundException, SQLException{

        statement = ConnectionDB.connection.createStatement();

        statement.execute("Create table if not exists 'Authors'(" +
                "'ID' integer primary key autoincrement not null," +
                "'Name' navchar max not null check (trim (Name) != '')," +
                "'Surname' nvarchar max not null check(trim (Surname) != '')," +
                "'CountryID' integer not null," +
                "FOREIGN KEY (CountryID) references Countries(Id) );");

        statement.execute("Create table if not exists 'Books'(" +
                "'ID' integer primary key autoincrement not null," +
                "'Name' nvarchar max not null check (trim(Name) != '')," +
                "'Pages' int not null check (Pages >= 0)," +
                "'Price' money not null check (Price > 0)," +
                "'PublishDate' date not null check (PublishDate <= CURRENT_DATE)," +
                "'AuthorId' int not null," +
                "'ThemeId' int not null," +
                "Foreign key (AuthorId) references Authors(Id), foreign key (ThemeId) references Themes(Id));");

        statement.execute("Create table if not exists 'Countries'(" +
                "'Id' integer primary key autoincrement not null," +
                "'Name' nvarchar (50) not null unique check(trim(Name) != ''));");

        statement.execute("Create table if not exists 'Sales'(" +
                "'Id' integer primary key autoincrement not null," +
                "'Price' money not null check(Price >= 0)," +
                "'Quantity' int not null check (Quantity > 0)," +
                "'SaleDate' date not null default CURRENT_DATE check (SaleDate <= CURRENT_DATE)," +
                "'BookId' int not null," + //проданная книга
                "'ShopId' int not null," + //Магазин, в котором была сделана продажа
                "Foreign key (BookId) references Books(Id), foreign key (ShopId) references Shops(Id));");

        statement.execute("Create table if not exists 'Shops'(" +
                "'Id' integer primary key autoincrement not null," +
                "'Name' nvarchar max not null check(trim(Name) != '')," +
                "'CountryID' int not null," +
                "FOREIGN KEY (CountryID) references Countries(Id) );");

        statement.execute("Create table if not exists 'Themes'(" +
                "'Id' integer primary key autoincrement not null," +
                "'Name' nvarchar (100) not null unique check(trim(Name) != ''));");

    }

    public static void statementClose() throws SQLException{
        statement.close();
    }
}
