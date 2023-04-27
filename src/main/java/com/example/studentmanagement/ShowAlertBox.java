package com.example.studentmanagement;

import javafx.scene.control.Alert;

public class ShowAlertBox {

    public void showAlertBox(String title , String massage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(massage);
        alert.show();
    }


    public void showAm(String s) {

    }
}

