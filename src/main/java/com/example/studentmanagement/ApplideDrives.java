package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplideDrives implements Initializable {


    public TextField studentidtf;
    public TextField emailtf;
    public TextField phonetf;
    public DatePicker dateofbirthdp;
    public TextField addresstf;
    public ComboBox<String> gendercb;
    public TextField markstentf;
    public DatePicker passingtyeartendp;
    public TextField markstweltf;
    public DatePicker passinyeartwedp;
    public ComboBox<String> coursecb;
    public TextField sessiontf;
    public TextField studentNametf;
    private ShowAlertBox showAlertBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAlertBox = new ShowAlertBox();
        gendercb.setItems(LocalDb.getGenderList());
        coursecb.setItems(LocalDb.getCourseList());
    }


    public void savebt(ActionEvent actionEvent) {
       String studentName = studentNametf.getText();
       String studentId = studentidtf.getText();
       String email = emailtf.getText();
       String phone = phonetf.getText();
       String dateOfBirth = dateofbirthdp.getEditor().getText();
       String address = addresstf.getText();
       String gender = gendercb.getSelectionModel().getSelectedItem();
       String marksTen = markstentf.getText();
       String passingYearTen = passingtyeartendp.getEditor().getText();
       String marksTwelve = markstweltf.getText();
       String passingYearTwelve = passinyeartwedp.getEditor().getText();
       String Course = coursecb.getSelectionModel().getSelectedItem();
       String Session = sessiontf.getText();

                if (studentName.isEmpty()){
                    showAlertBox.showAlertBox("StudentName Is Empty","Please Enter StudentName", Alert.AlertType.WARNING);
               return;
                } else if (studentId.isEmpty()) {
                    showAlertBox.showAlertBox("StudentId Is Empty","Please Enter StudentId", Alert.AlertType.WARNING);
               return;
                } else if (email.isEmpty()) {
                    showAlertBox.showAlertBox("Email Is Empty","Please Enter Email", Alert.AlertType.WARNING);
                    return;
                } else if (phone.isEmpty()) {
                    showAlertBox.showAlertBox("Phone Is Empty","Please Enter Phone", Alert.AlertType.WARNING);
                    return;
                } else if (dateOfBirth.isEmpty()) {
                    showAlertBox.showAlertBox("Date Of Birth Is Empty","Please Enter DateOfBirth", Alert.AlertType.WARNING);
                    return;
                } else if (address.isEmpty()) {
                    showAlertBox.showAlertBox("Address Is Empty","Please Enter Address", Alert.AlertType.WARNING);
                    return;
                } else if (gender.isEmpty()) {
                    showAlertBox.showAlertBox("Gender Is Empty","Please Enter Gender", Alert.AlertType.WARNING);
                    return;
                } else if (marksTen.isEmpty()) {
                    showAlertBox.showAlertBox("10th marks Is Empty","Please Enter 10th Marks", Alert.AlertType.WARNING);
                    return;
                } else if (passingYearTen.isEmpty()) {
                    showAlertBox.showAlertBox("Passing Year Is Empty","Please Enter Passing Year", Alert.AlertType.WARNING);
                    return;
                } else if (marksTwelve.isEmpty()) {
                    showAlertBox.showAlertBox("12th Marks Is Empty","Please Enter 12th Marks", Alert.AlertType.WARNING);
                    return;
                } else if (passingYearTwelve.isEmpty()) {
                    showAlertBox.showAlertBox("Passing Year Is Empty","Please Enter Passing Year", Alert.AlertType.WARNING);
                } else if (Course.isEmpty()) {
                    showAlertBox.showAlertBox("Course Is Empty","Please Enter Course", Alert.AlertType.WARNING);
                    return;
                } else if (Session.isEmpty()) {
                    showAlertBox.showAlertBox("Session  Is Empty","Please Enter Session", Alert.AlertType.WARNING);
                }
    }

    public void resetbt(ActionEvent actionEvent) {
        studentNametf.setText(" ");
        studentidtf.setText(" ");
        emailtf.setText(" ");
        phonetf.setText(" ");
        dateofbirthdp.cancelEdit();
        addresstf.setText(" ");
        gendercb.getSelectionModel().getSelectedItem();
        markstentf.setText(" ");
        passingtyeartendp.cancelEdit();
        markstweltf.setText(" ");
        passinyeartwedp.cancelEdit();
        coursecb.getSelectionModel().getSelectedItem();
        sessiontf.setText(" ");

    }
}
