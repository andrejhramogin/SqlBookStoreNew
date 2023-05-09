package data_filling;

import connectionDB.ConnectionDB;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class DataFilling {
    public static Statement statement;
    private static final Scanner scan = new Scanner(System.in);
    private static String name, surname;
    private static int countryID, authorID, themeID, pages;
    private static String date;
    private static Double price;

    static {
        try {
            statement = ConnectionDB.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillTableAuthors() throws SQLException {

        System.out.println("Для выхода нажмите \"q\", для продолжения - любую клавишу.");
        if (scan.nextLine().equals("q")) return;

        System.out.println("Enter the author name:");
        name = scan.nextLine();
        System.out.println("Enter the author surname:");
        surname = scan.nextLine();
        System.out.println("Enter the author country ID:");
        countryID = scan.nextInt();
        scan.nextLine();

        statement.execute(String.format("INSERT into 'Authors' ('Name', 'Surname', 'CountryID') values ('%s', '%s', %d)",
                name, surname, countryID));
        fillTableAuthors();
    }

    public static void fillTableBooks() throws SQLException {
        LocalDate date;
        System.out.println("Для выхода нажмите \"q\", для продолжения - любую клавишу.");
        if (scan.nextLine().equals("q")) return;
        System.out.println("Enter the book title:");
        name = scan.nextLine();
        System.out.println("Enter the number of pages (>0):");
        pages = scan.nextInt();
        System.out.println("Enter rhe price (>0):");
        price = scan.nextDouble();
        date = setData();
        System.out.println("Enter the author ID:");
        authorID = scan.nextInt();
        System.out.println("Enter the theme ID:");
        themeID = scan.nextInt();

        statement.execute(String.format("Insert into 'Books' ('Name', 'Pages', 'Price', 'PublishDate'," +
                        "'AuthorId', 'ThemeId') values ('%s', '%d', '%f', '" + date + "', '%d', '%d')", name, pages, price,
                authorID, themeID));
        fillTableBooks();
    }

    public static LocalDate setData() {
        System.out.println("Enter the publishing date: year, month, day: ");
        int year = scan.nextInt();
        int month = scan.nextInt();
        int day = scan.nextInt();
        return LocalDate.of(year, month, day);
    }
}
