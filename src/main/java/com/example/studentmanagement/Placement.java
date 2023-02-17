package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Placement  implements Initializable {

    public TextField studentidtf;
    public TextField studentnametf;
    public TextField emailtf;
    public TextField phonetf;
    public TextField sessiontf;
    public TextField coursetf;
    public TextField companynametf;
    public TextField jobcitytf;
    public ComboBox<String> gendercb;
    private ShowAlertBox showAlertBox;

    public void addplacemantstudentbt(ActionEvent actionEvent) {
        new CustomFxmlDialog().Show("placementstudent.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {showAlertBox = new ShowAlertBox();

    }

    public void resetbt(ActionEvent actionEvent) {
        studentidtf.setText("");
        studentnametf.setText("");
        emailtf.setText("");
        phonetf.setText("");
        sessiontf.setText("");
        coursetf.setText("");
        companynametf.setText("");
        jobcitytf.setText("");
        gendercb.getSelectionModel().isEmpty();
    }

    public void submitbt(ActionEvent actionEvent) {
        String studentId = studentidtf.getText();
        String studentName = studentnametf.getText();
        String email = emailtf.getText();
        String phone = phonetf.getText();
        String session = sessiontf.getText();
        String course = coursetf.getText();
        String companyName = companynametf.getText();
        String jobCity = jobcitytf.getText();
        String gender = gendercb.getSelectionModel().getSelectedItem();

        if (studentId.isEmpty()){
            showAlertBox.showAlertBox("StudentId Is Empty", "please Enter StudentId", Alert.AlertType.WARNING);
        } else if (studentName.isEmpty()) {
            showAlertBox.showAlertBox("StudentName Is Empty", "please Enter StudentName", Alert.AlertType.WARNING);
        } else if (email.isEmpty()) {
            showAlertBox.showAlertBox("Email Is Empty", "please Enter Email", Alert.AlertType.WARNING);
        } else if (phone.isEmpty()) {
            showAlertBox.showAlertBox("Phone Is Empty", "please Enter Phone", Alert.AlertType.WARNING);
        } else if (session.isEmpty()) {
            showAlertBox.showAlertBox("Session Is Empty", "please Enter Session", Alert.AlertType.WARNING);
        } else if (course.isEmpty()) {
            showAlertBox.showAlertBox("Course Is Empty", "please Enter Course", Alert.AlertType.WARNING);
        } else if (companyName.isEmpty()) {
            showAlertBox.showAlertBox("CompanyName Is Empty", "please Enter CompanyName", Alert.AlertType.WARNING);
        } else if (jobCity.isEmpty()) {
            showAlertBox.showAlertBox("JobCity Is Empty", "please Enter JobCity", Alert.AlertType.WARNING);
        } else if (gender.isEmpty()) {
            showAlertBox.showAlertBox("Gender Is Empty", "please Enter Gender", Alert.AlertType.WARNING);
        }
    }
}