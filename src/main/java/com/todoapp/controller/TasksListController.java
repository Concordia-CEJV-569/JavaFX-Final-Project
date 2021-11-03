package com.todoapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

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

        tasksListView.setCellFactory(stringListView -> new TaskCell());
    }

    static class TaskCell extends ListCell<String> {
        // HBox = Horizontal Box
        HBox hBox = new HBox();
        Button button = new Button("Delete");
        Label taskTitleLabel = new Label();

        Pane pane = new Pane();
        Image addImage = new Image(this.getClass().getResourceAsStream("/com/todoapp/assets/outline_add_circle_white.png"));
        ImageView imageView = new ImageView(addImage);

        public TaskCell() {
            super();

            hBox.getChildren().addAll(imageView, taskTitleLabel, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
        }

        public void updateItem(String taskName, boolean isEmpty) {
            super.updateItem(taskName, isEmpty);
            setText(null);
            setGraphic(null);

            if (taskName != null && !isEmpty) {
                taskTitleLabel.setText(taskName);
                setGraphic(hBox);
            }
        }
    }

}

