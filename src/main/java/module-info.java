module com.todoapp.finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.todoapp to javafx.fxml;
    exports com.todoapp;
    exports com.todoapp.controller;
    opens com.todoapp.controller to javafx.fxml;
}