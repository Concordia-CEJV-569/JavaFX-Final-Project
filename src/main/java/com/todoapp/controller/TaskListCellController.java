package com.todoapp.controller;

import com.todoapp.database.DBHandler;
import com.todoapp.model.Task;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TaskListCellController extends ListCell<Task> {

    @FXML
    private AnchorPane listCellAnchorPane;

    @FXML
    private ImageView taskImageView;

    @FXML
    private Label taskTitleLabel;

    @FXML
    private Label taskDescriptionLabel;

    @FXML
    private Label dateCreatedLabel;

    @FXML
    private ImageView deleteImageView;

    private FXMLLoader fxmlLoader;

    private DBHandler dbHandler;

    @FXML
    void initialize() {
        deleteImageView.setOnMouseClicked(mouseEvent -> {
            dbHandler = new DBHandler();
            dbHandler.deleteTask(AddItemController.userId, getItem().getId());
            getListView().getItems().remove(getItem());
        });
    }

    @Override
    protected void updateItem(Task task, boolean isEmpty) {
        super.updateItem(task, isEmpty);

        if (isEmpty || task == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/todoapp/taskListCell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            taskTitleLabel.setText(task.getTitle());
            taskDescriptionLabel.setText(task.getDescription());
            dateCreatedLabel.setText(task.getCreatedAt().toString());

            setText(null);
            setGraphic(listCellAnchorPane);
        }
    }
}
