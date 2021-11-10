package com.todoapp.controller;

import com.todoapp.database.DBHandler;
import com.todoapp.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TasksListController {
    @FXML
    private ListView<Task> tasksListView;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button saveTaskButton;

    @FXML
    private ImageView refreshImageView;

    private ObservableList<Task> tasksObservableList = FXCollections.observableArrayList();

    private DBHandler dbHandler;

    @FXML
    void initialize() throws SQLException {
        tasksObservableList = FXCollections.observableArrayList();

        refreshList();

        tasksListView.setCellFactory(taskListView -> new TaskListCellController());

        saveTaskButton.setOnAction(actionEvent -> addNewTask());

        refreshImageView.setOnMouseClicked(mouseEvent -> {
            try {
                refreshList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void addNewTask() {
        if (!titleTextField.getText().equals("") && !descriptionTextField.getText().equals("")) {
            Task newTask = new Task(
                    AddItemController.userId,
                    titleTextField.getText().trim(),
                    descriptionTextField.getText().trim(),
                    null
            );

            dbHandler.insertTask(newTask);

            titleTextField.setText("");
            descriptionTextField.setText("");

//            tasksObservableList.add(newTask);
//            tasksListView.setItems(tasksObservableList);
            try {
                initialize();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshList() throws SQLException {
        dbHandler = new DBHandler();
        ResultSet resultSet = dbHandler.getTasks(AddItemController.userId);

        tasksObservableList = FXCollections.observableArrayList();

        while (resultSet.next()) {
            Task task = new Task(
                    resultSet.getInt("id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getTimestamp("created_at")
            );
            tasksObservableList.add(task);
        }

        tasksListView.setItems(tasksObservableList);
    }

}

