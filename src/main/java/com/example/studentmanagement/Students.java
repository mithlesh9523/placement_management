package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Students implements Initializable {

    public TextField statetf;
    public TextField districttf;
    public DatePicker dateofbirthdp;
    public ComboBox<String> coursecb;
    public TextField sessiontf;
    public TextField phonetf;
    public TextField emailtf;
    public TextField nametf;
    public TextField studentidtf;
    public TextField fatherNametf;
    public TextField villegetf;
    public ComboBox<String> gendercb;
    private ShowAlertBox showAlertBox;

    public void addStudent(ActionEvent actionEvent) {
        new CustomFxmlDialog().Show("Studentdetails.fxml");
    }

    public void resetbt(ActionEvent actionEvent) {
        studentidtf.setText("");
        nametf.setText("");
        emailtf.setText("");
        phonetf.setText("");
        fatherNametf.setText("");
        villegetf.setText("");
        districttf.setText("");
        statetf.setText("");
        sessiontf.setText("");
        dateofbirthdp.getDayCellFactory();


        if (!coursecb.getSelectionModel().isEmpty()){
            coursecb.getSelectionModel().clearSelection();

        }
    }

    public void submitbt(ActionEvent actionEvent) {
        String Name = nametf.getText();
        String StudentId = studentidtf.getText();
        String Email = emailtf.getText();
        String Phone = phonetf.getText();
        String Session = sessiontf.getText();
        String FatherName = fatherNametf.getText();
        String State = statetf.getText();
        String District = districttf.getText();
        String Village = villegetf.getText();
        String Course = coursecb.getSelectionModel().getSelectedItem();
        String gender = gendercb.getSelectionModel().getSelectedItem();
        DatePicker DateOfBirth = dateofbirthdp;


        if (StudentId.isEmpty()) {
            showAlertBox.showAlertBox("StudentId Is Empty", "please Enter StudentId", Alert.AlertType.WARNING);
        } else if (Name.isEmpty()) {
            showAlertBox.showAlertBox("Name Is Empty", "please Enter Name", Alert.AlertType.WARNING);
        } else if (Email.isEmpty()) {
            showAlertBox.showAlertBox("Email Is Empty", "please Enter Email", Alert.AlertType.WARNING);
        } else if (Phone.isEmpty()) {
            showAlertBox.showAlertBox("Phone Is Empty", "please Enter Phone", Alert.AlertType.WARNING);
        } else if (Session.isEmpty()) {
            showAlertBox.showAlertBox("Session Is Empty", "please Enter Session", Alert.AlertType.WARNING);
        } else if (Course.isEmpty()) {
            showAlertBox.showAlertBox("Course Is Empty", "please Enter Course", Alert.AlertType.WARNING);
        } else if (gender.isEmpty()) {
            showAlertBox.showAlertBox("Gender Is Empty", "please Enter Gender", Alert.AlertType.WARNING);
        } else if (DateOfBirth.isShowWeekNumbers()) {
            showAlertBox.showAlertBox("Date Of Birth Is Empty", "please Enter Date Of Birth", Alert.AlertType.WARNING);
        } else if (FatherName.isEmpty()) {
            showAlertBox.showAlertBox("FatherName Is Empty", "please Enter FatherName", Alert.AlertType.WARNING);
        } else if (Village.isEmpty()) {
            showAlertBox.showAlertBox("Village Is Empty", "please Enter Village", Alert.AlertType.WARNING);
        } else if (District.isEmpty()) {
            showAlertBox.showAlertBox("District Is Empty", "please Enter District", Alert.AlertType.WARNING);
        } else if (State.isEmpty()) {
            showAlertBox.showAlertBox("State Is Empty", "please Enter State", Alert.AlertType.WARNING);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAlertBox = new ShowAlertBox();

    }
}
