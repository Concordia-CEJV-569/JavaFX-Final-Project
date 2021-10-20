package com.todoapp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    void initialize() {
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

            if (!username.equals("") && !password.equals("")) {
                loginUser(username, password);
            } else {
                System.out.println("Invalid Credentials");
            }
        });
    }

    private void loginUser(String username, String password) {
        // Check if credentials are valid, if true, go to the addItem screen
    }
}
