package com.todoapp.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }
}
