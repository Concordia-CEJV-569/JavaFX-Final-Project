package com.todoapp.controller;

import com.todoapp.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TasksListController {
    @FXML
    private ListView<Task> tasksListView;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button saveTaskButton;

    ObservableList<Task> tasksObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        Task task = new Task(11, "Clean car", "Before it's too late!", Timestamp.valueOf(LocalDateTime.now()));
        Task task2 = new Task(11, "Clean other car", "Before it's winters", Timestamp.valueOf(LocalDateTime.now()));

        tasksObservableList = FXCollections.observableArrayList();
        tasksObservableList.add(task);
        tasksObservableList.add(task2);

        tasksListView.setItems(tasksObservableList);
        tasksListView.setCellFactory(taskListView -> new TaskListCellController());
    }

}

