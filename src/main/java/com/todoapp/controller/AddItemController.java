package com.todoapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.todoapp.animation.Shaker;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addImageView;

    @FXML
    void initialize() {
        addImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Shaker(addImageView).shake();
        });
    }
}
