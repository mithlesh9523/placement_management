package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class login implements Initializable {
    public TextField usernametf;
    public PasswordField passwordpf;
    private ShowAlertBox showAlertBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAlertBox = new ShowAlertBox();
    }


    public void loginbt(ActionEvent actionEvent) {
        String userName = usernametf.getText();
        String Password = usernametf.getText();
        if (userName.isEmpty()) {
            showAlertBox.showAlertBox("UserName is Empty", "Please Enter userName", Alert.AlertType.WARNING);
            return;
        }else if (Password.isEmpty()) {
            showAlertBox.showAlertBox("UserName is Empty", "Please Enter userName", Alert.AlertType.WARNING);
            return;
        }

        // after successfully login
    }
}

