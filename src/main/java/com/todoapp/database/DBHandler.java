package com.todoapp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    public void signUpUser(String firstName, String lastName, String username, String password) {
        String query = "INSERT INTO " + Const.USERS_TABLE + "(" +
                Const.USERS_FIRST_NAME + "," +
                Const.USERS_LAST_NAME + "," +
                Const.USERS_USERNAME + "," +
                Const.USERS_PASSWORD + ") VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
