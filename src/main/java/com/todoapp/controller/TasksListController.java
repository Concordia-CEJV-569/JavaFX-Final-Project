package com.todoapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TasksListController {
    @FXML
    private ListView<String> tasksListView;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button saveTaskButton;

    ObservableList<String> tasksObservableList = FXCollections.observableArrayList(
            "John",
            "Samantha",
            "Jacob",
            "Clark"
    );

    @FXML
    void initialize() {
        tasksListView.setItems(tasksObservableList);
    }
}
