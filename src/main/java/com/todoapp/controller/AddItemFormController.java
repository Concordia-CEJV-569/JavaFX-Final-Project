package com.todoapp.controller;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.todoapp.animation.Shaker;
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

        saveTaskButton.setOnAction(actionEvent -> {
            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
            String taskTitle = taskTextField.getText().trim();
            String taskDescription = descriptionTextField.getText().trim();

            if (!taskTitle.equals("") && !taskDescription.equals("")) {
                dbHandler.insertTask(new Task(AddItemController.getUserId(), taskTitle, taskDescription, timestamp));
            } else {
                new Shaker(saveTaskButton).shake();
            }
        });
    }
}
