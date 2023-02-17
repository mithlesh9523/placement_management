package com.example.studentmanagement;

import javafx.scene.control.Alert;

public class ShowAlertBox {

    public void showAlertBox(String title , String massage, Alert.AlertType warning){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(massage);
        alert.show();
    }

}

