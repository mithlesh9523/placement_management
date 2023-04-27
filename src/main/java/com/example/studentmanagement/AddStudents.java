package com.example.studentmanagement;

import com.example.studentmanagement.util.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddStudents implements Initializable {



    public TextField studentnametf;
    public TextField emailtf;
    public TextField phonetf;
    public TextField sessiontf;
    public DatePicker dateofbirthdp;
    public TextField fatherNametf;
    public TextField villegetf;
    public TextField districttf;
    public TextField statetf;
    @FXML
    public ComboBox<String> gendercb;
    public ComboBox<String> courseCb;
    private ShowAlertBox showAlertBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAlertBox = new ShowAlertBox();

        gendercb.setItems(LocalDb.getStudentGender());
        courseCb.setItems(LocalDb.getCourseList());
    }

    public void resetbt(ActionEvent actionEvent) {
        studentnametf.setText("");
        emailtf.setText("");
        phonetf.setText("");
        fatherNametf.setText("");
        villegetf.setText("");
        districttf.setText("");
        statetf.setText("");
        sessiontf.setText("");
      //  courseCb.setItems(LocalDb.getCourseList());
        dateofbirthdp.cancelEdit();

        if (!courseCb.getSelectionModel().isEmpty()){
            courseCb.getSelectionModel().clearSelection();

        }
        if (!gendercb.getSelectionModel().isEmpty()){
            gendercb.getSelectionModel().clearSelection();

        }

    }
    public void submitbt(ActionEvent actionEvent) {
        String Name = studentnametf.getText();
        String Email = emailtf.getText();
        String Phone = phonetf.getText();
        String Session = sessiontf.getText();
        String FatherName = fatherNametf.getText();
        String State = statetf.getText();
        String District = districttf.getText();
        String Village = villegetf.getText();
        String Course = courseCb.getSelectionModel().getSelectedItem();
        String gender = gendercb.getSelectionModel().getSelectedItem();
        String dateOfBirth = dateofbirthdp.getEditor().getText();

         if (Name.isEmpty()) {
            showAlertBox.showAlertBox("Name Is Empty", "Please Enter Name", Alert.AlertType.WARNING);
            return;
        } else if (Email.isEmpty()) {
            showAlertBox.showAlertBox("Email Is Empty", "Please Enter Email", Alert.AlertType.WARNING);
            return;
        } else if (Phone.isEmpty()) {
            showAlertBox.showAlertBox("Phone Is Empty", "Please Enter Phone", Alert.AlertType.WARNING);
            return;
        } else if (Session.isEmpty()) {
            showAlertBox.showAlertBox("Session Is Empty", "Please Enter Session", Alert.AlertType.WARNING);
            return;
        } else if (Course.isEmpty()) {
            showAlertBox.showAlertBox("Course Is Empty", "Please Enter Course", Alert.AlertType.WARNING);
            return;
        } else if (gender.isEmpty()) {
            showAlertBox.showAlertBox("Gender Is Empty", "Please Enter Gender", Alert.AlertType.WARNING);
            return;
        } else if (dateOfBirth.isEmpty()) {
            showAlertBox.showAlertBox("Date Of Birth Is Empty", "Please Enter Date Of Birth", Alert.AlertType.WARNING);
            return;
        } else if (FatherName.isEmpty()) {
            showAlertBox.showAlertBox("FatherName Is Empty", "please Enter FatherName", Alert.AlertType.WARNING);
            return;
        } else if (Village.isEmpty()) {
            showAlertBox.showAlertBox("Village Is Empty", "Please Enter Village", Alert.AlertType.WARNING);
            return;
        } else if (District.isEmpty()) {
            showAlertBox.showAlertBox("District Is Empty", "Please Enter District", Alert.AlertType.WARNING);
            return;
        } else if (State.isEmpty()) {
            showAlertBox.showAlertBox("State Is Empty", "Please Enter State", Alert.AlertType.WARNING);
            return;
        }

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DbConnection.getConnection();

            String query = """
                    
                    INSERT INTO STUDENTS(STUDENT_NAME, EMAIL, PHONE,
                                        COURSE, GENDER, DATE_OF_BIRTH, FATHER_NAME,
                                         VILLAGE, DISTRICT, STATE,session) VALUES (?,?,?,?,?,?,?,?,?,?,?)
                    
                    """;

            ps = connection.prepareStatement(query);
            ps.setString(1,Name);
            ps.setString(2,Email);
            ps.setString(3,Phone);
            ps.setString(4,Course);
            ps.setString(5,gender);
            ps.setString(6,dateOfBirth);
            ps.setString(7,FatherName);
            ps.setString(8,Village);
            ps.setString(9,District);
            ps.setString(10,State);
            ps.setString(11,Session);

            int res = ps.executeUpdate();

            if (res >0){
                resetbt(null);
                showAlertBox.showAlertBox("success","Successfully Added",
                        Alert.AlertType.CONFIRMATION);

                System.out.println("success");
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
