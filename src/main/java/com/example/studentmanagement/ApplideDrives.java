package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import jdk.internal.icu.text.UnicodeSet;
import jdk.internal.icu.util.CodePointMap;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplideDrives implements Initializable {


    public TextField nametf;
    public TextField studentidtf;
    public TextField phonetf;
    public DatePicker dateofbirthdp;
    public TextField addresstf;
    public TextField markstentf;
    public TextField markstweltf;
    public DatePicker passingtyeartendp;
    public DatePicker passinyeartwedp;
    public ComboBox<String> coursecb;
    public TextField sessiontf;
    private ShowAlertBox showAlertBox;


    public void savebt(ActionEvent actionEvent) {
        String stuName = nametf.getText();
        String stuId = studentidtf.getText();
        String phoneNo = phonetf.getText();
        String courseName = coursecb.getSelectionModel().getSelectedItem();
        String session = sessiontf.getText();
        String tenMarks = markstentf.getText();
       String twelveMarks = markstweltf.getText();




        if (stuName.isEmpty()){
            showAlertBox.showAlertBox("Student Is Empty","Please Enter Student Name", Alert.AlertType.WARNING);
        } else if (stuId.isEmpty()) {
            showAlertBox.showAlertBox("StudentId Is Empty","Please Enter StudentId Name", Alert.AlertType.WARNING);
        } else if (phoneNo.isEmpty()) {
            showAlertBox.showAlertBox("phoneNo Is Empty","Please Enter PhoneNo", Alert.AlertType.WARNING);
        } else if (courseName.isEmpty()) {
            showAlertBox.showAlertBox("Course Is Empty","Please Enter Course", Alert.AlertType.WARNING);
        } else if (session.isEmpty()) {
            showAlertBox.showAlertBox("Session Is Empty","Please Enter Session", Alert.AlertType.WARNING);
        } else if (tenMarks.isEmpty()) {
            showAlertBox.showAlertBox("marksh Is Empty","Please Enter 10th Marks", Alert.AlertType.WARNING);
        } else if (twelveMarks.isEmpty()) {
            showAlertBox.showAlertBox("Marks Is Empty","Please Enter 12th Marks", Alert.AlertType.WARNING);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAlertBox = new ShowAlertBox();


    }
    public void resetbt(ActionEvent actionEvent) {
        studentidtf.setText("");


        if (!coursecb.getSelectionModel().isEmpty()){
            coursecb.getSelectionModel().clearSelection();

        }
    }

}
