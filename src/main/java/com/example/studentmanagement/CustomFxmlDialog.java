package com.example.studentmanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomFxmlDialog {

    public void Show(String fileName) {
        Stage stage = new Stage();
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Dashboard");

        stage.show();
    }
}
