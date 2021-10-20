package com.todoapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.todoapp.database.DBHandler;
import com.todoapp.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    void initialize() {

        signupButton.setOnAction(actionEvent -> {
            createUser();
        });
    }

    private void createUser() {
        DBHandler dbHandler = new DBHandler();

        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        String username = usernameTextField.getText().trim();
        String password = passwordField.getText().trim();

        User user = new User(firstName, lastName, username, password);

        dbHandler.signUpUser(user);
    }
}
