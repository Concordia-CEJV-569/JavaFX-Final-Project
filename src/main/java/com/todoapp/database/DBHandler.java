package com.todoapp.database;

import com.todoapp.model.User;

import java.sql.*;

public class DBHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    public void signUpUser(User user) {
        String query = "INSERT INTO " + Const.USERS_TABLE + "(" +
                Const.USERS_FIRST_NAME + "," +
                Const.USERS_LAST_NAME + "," +
                Const.USERS_USERNAME + "," +
                Const.USERS_PASSWORD + ") VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resultSet = null;

        if (!user.getUsername().equals("") && !user.getPassword().equals("")) {
            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=?" + " AND " + Const.USERS_PASSWORD + "=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);

                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());

                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Please enter your credentials");
        }

        return resultSet;
    }
}
