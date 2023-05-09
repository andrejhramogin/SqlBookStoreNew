package org.example;

import connectionDB.ConnectionDB;
import create_table.TableCreate;
import data_filling.DataFilling;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionDB.conn();
        TableCreate.createDB();
        DataFilling.fillTableAuthors();
        DataFilling.fillTableBooks();

        ConnectionDB.connectionClose();
        TableCreate.statementClose();
    }
}