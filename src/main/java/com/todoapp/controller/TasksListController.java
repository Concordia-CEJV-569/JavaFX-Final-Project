package com.todoapp.controller;

import com.todoapp.database.DBHandler;
import com.todoapp.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    private ObservableList<Task> tasksObservableList = FXCollections.observableArrayList();

    private DBHandler dbHandler;

    @FXML
    void initialize() throws SQLException {
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
        tasksListView.setCellFactory(taskListView -> new TaskListCellController());
    }

}

