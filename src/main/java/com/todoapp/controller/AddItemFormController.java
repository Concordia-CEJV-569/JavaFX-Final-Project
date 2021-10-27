package com.todoapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddItemFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField taskTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button saveTaskButton;

    @FXML
    void initialize() {

    }
}
