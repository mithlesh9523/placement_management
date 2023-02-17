package com.example.studentmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
        Scene scene = new Scene(parent);
        stage.setScene(scene);

        // stage.setTitle("LoginPage fxml");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}
