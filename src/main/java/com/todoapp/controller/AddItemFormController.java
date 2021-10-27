package com.todoapp.controller;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.todoapp.database.DBHandler;
import com.todoapp.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddItemFormController {
    private int userId;

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

    private DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        Calendar calendar = Calendar.getInstance();
        saveTaskButton.setOnAction(actionEvent -> {
            dbHandler.insertTask(new Task(
                    taskTextField.getText().trim(),
                    descriptionTextField.getText().trim(),
                    new Timestamp(calendar.getTimeInMillis())
            ));
        });
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
