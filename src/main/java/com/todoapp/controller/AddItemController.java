package com.todoapp.controller;

import com.todoapp.animation.Shaker;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class AddItemController {
    @FXML
    private ImageView addImageView;

    @FXML
    private Label noTaskLabel;

    @FXML
    void initialize() {
        addImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Shaker(addImageView).shake();

            FadeTransition imageViewFadeTransition = new FadeTransition(Duration.millis(2000), addImageView);
            FadeTransition noTaskLabelFadeTransition = new FadeTransition(Duration.millis(2000), noTaskLabel);

            addImageView.relocate(0, 20);
            noTaskLabel.relocate(0, 85);

            addImageView.setOpacity(0);
            noTaskLabel.setOpacity(0);

            imageViewFadeTransition.setFromValue(1f);
            imageViewFadeTransition.setToValue(0f);
            imageViewFadeTransition.setAutoReverse(false);
            imageViewFadeTransition.play();

            noTaskLabelFadeTransition.setFromValue(1f);
            noTaskLabelFadeTransition.setToValue(0f);
            noTaskLabelFadeTransition.setAutoReverse(false);
            noTaskLabelFadeTransition.play();
        });
    }
}
