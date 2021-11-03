package com.todoapp.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javafx.fxml.FXML;
import com.todoapp.model.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.todoapp.animation.Shaker;
import com.todoapp.database.DBHandler;
import javafx.stage.Stage;

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

                int numberOfTasks = dbHandler.getNumberOfTasks(AddItemController.userId);

                successLabel.setVisible(true);
                taskCounterButton.setVisible(true);
                taskCounterButton.setText("My Todos: (" + numberOfTasks + ")");
                titleTextField.setText("");
                descriptionTextField.setText("");

                taskCounterButton.setOnAction(actionEvent1 -> {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/todoapp/tasksList.fxml"));

                    try {
                        fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = fxmlLoader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                });
            } else {
                new Shaker(saveTaskButton).shake();
            }
        });
    }
}
