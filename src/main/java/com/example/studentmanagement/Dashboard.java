package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
    public StackPane containArea;
    ShowScreen showScreen;
    private ActionEvent actionEvent;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        showScreen = new ShowScreen();


    }


    void replaceScene(String fileName) {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource(fileName));
            containArea.getChildren().removeAll();
            containArea.getChildren().setAll(parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void placementbt(ActionEvent actionEvent) {
        replaceScene("Placement.fxml");
    }

    public void applieddrives(ActionEvent actionEvent) {
        replaceScene("ApplideDrives.fxml.");
    }

    public void questionsbt(ActionEvent actionEvent) {
        replaceScene("questions.fxml");
    }


    public void homebt(ActionEvent actionEvent) {
        replaceScene("Home.fxml");
    }

    public void Student(ActionEvent actionEvent) {
        replaceScene("Students.fxml");
    }
}



