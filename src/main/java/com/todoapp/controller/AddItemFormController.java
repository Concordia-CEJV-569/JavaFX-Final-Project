package com.todoapp.controller;

import java.sql.Timestamp;
import java.util.Calendar;

import javafx.fxml.FXML;
import com.todoapp.model.Task;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.todoapp.animation.Shaker;
import com.todoapp.database.DBHandler;

public class AddItemFormController {
    @FXML
    private TextField titleTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button saveTaskButton;

    @FXML
    private Label successLabel;

    @FXML
    private Button taskCounterButton;

    private DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        saveTaskButton.setOnAction(actionEvent -> {
            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
            String taskTitle = titleTextField.getText().trim();
            String taskDescription = descriptionTextField.getText().trim();

            if (!taskTitle.equals("") && !taskDescription.equals("")) {
                dbHandler.insertTask(new Task(AddItemController.userId, taskTitle, taskDescription, timestamp));

                successLabel.setVisible(true);
                taskCounterButton.setVisible(true);
                taskCounterButton.setText("My Todos: (" + 2 + ")");
                titleTextField.setText("");
                descriptionTextField.setText("");

                taskCounterButton.setOnAction(actionEvent1 -> {
                    // send user to the list screen
                });
            } else {
                new Shaker(saveTaskButton).shake();
            }
        });
    }
}
