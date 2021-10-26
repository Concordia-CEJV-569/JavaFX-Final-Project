package com.todoapp.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.todoapp.database.DBHandler;
import com.todoapp.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    private DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        signupButton.setOnAction(actionEvent -> {
            // Go to signup screen
            signupButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/todoapp/signup.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        });

        loginButton.setOnAction(actionEvent -> {
            String username = usernameTextField.getText().trim();
            String password = passwordField.getText().trim();

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            ResultSet resultSet = dbHandler.getUser(user);

            try {
                if (resultSet != null && resultSet.next()) {
                    System.out.println("Welcome: " + resultSet.getString("first_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
