package com.todoapp.database;

import com.todoapp.model.Task;
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

    public void insertTask(Task task) {
        String query = "INSERT INTO " + Const.TASKS_TABLE + "(" +
                Const.TASKS_USER_ID + "," +
                Const.TASKS_TITLE + "," +
                Const.TASKS_DESCRIPTION + "," +
                Const.TASKS_CREATED_AT + ") VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, task.getUserId());
            preparedStatement.setString(2, task.getTitle());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setTimestamp(4, task.getCreatedAt());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfTasks(int userId) {
        String query = "SELECT COUNT(*) FROM " + Const.TASKS_TABLE + " WHERE " + Const.TASKS_USER_ID + "=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet getTasks(int userId) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + Const.TASKS_TABLE + " WHERE " + Const.TASKS_USER_ID + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void deleteTask(int userId, int taskId) {
        String query = "DELETE FROM " + Const.TASKS_TABLE + " WHERE " + Const.TASKS_USER_ID + "=? AND " + Const.TASK_ID + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, taskId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
