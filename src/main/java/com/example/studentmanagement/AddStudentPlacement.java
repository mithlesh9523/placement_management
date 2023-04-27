package com.example.studentmanagement;

import com.example.studentmanagement.util.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AddStudentPlacement implements Initializable {

    public TextField studentnametf;
    public TextField emailtf;
    public TextField phonetf;
    public TextField sessiontf;
    public TextField companynametf;
    public TextField jobcitytf;
    public ComboBox<String> gendercb;
    public ComboBox<String> cbCourse;

    private ShowAlertBox showAlertBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAlertBox = new ShowAlertBox();
        gendercb.setItems(LocalDb.getGenderList());
        cbCourse.setItems(LocalDb.getCourseList());

    }

    public void resetbt(ActionEvent actionEvent) {
        studentnametf.setText("");
        emailtf.setText("");
        phonetf.setText("");
        sessiontf.setText("");
        companynametf.setText("");
        jobcitytf.setText("");

        if (!cbCourse.getSelectionModel().isEmpty()){
            cbCourse.getSelectionModel().clearSelection();

        }
        if (!gendercb.getSelectionModel().isEmpty()){
            gendercb.getSelectionModel().clearSelection();

        }

    }

    public void submitbt(ActionEvent actionEvent) {
        String studentName = studentnametf.getText();
        String email = emailtf.getText();
        String phone = phonetf.getText();
        String session = sessiontf.getText();
        String course = cbCourse.getSelectionModel().getSelectedItem();
        String companyName = companynametf.getText();
        String jobCity = jobcitytf.getText();
        String gender = gendercb.getSelectionModel().getSelectedItem();

        if (studentName.isEmpty()) {
            showAlertBox.showAlertBox("StudentName Is Empty", "Please Enter StudentNamew", Alert.AlertType.WARNING);
            return;
        } else if (email.isEmpty()) {
            showAlertBox.showAlertBox("Email Is Empty", "Please Enter Email", Alert.AlertType.WARNING);
            return;
        } else if (phone.isEmpty()) {
            showAlertBox.showAlertBox("Phone Is Empty", "Please Enter Phone", Alert.AlertType.WARNING);
            return;
        } else if (session.isEmpty()) {
            showAlertBox.showAlertBox("Session Is Empty", "Please Enter Session", Alert.AlertType.WARNING);
            return;
        } else if (course.isEmpty()) {
            showAlertBox.showAlertBox("Course Is Empty", "Please Enter Course", Alert.AlertType.WARNING);
            return;
        } else if (companyName.isEmpty()) {
            showAlertBox.showAlertBox("CompanyName Is Empty", "Please Enter CompanyName", Alert.AlertType.WARNING);
            return;
        } else if (jobCity.isEmpty()) {
            showAlertBox.showAlertBox("JobCity Is Empty", "Please Enter JobCIty", Alert.AlertType.WARNING);
            return;
        } else if (gender.isEmpty()) {
            showAlertBox.showAlertBox("Gender Is Empty", "Please Enter Gender", Alert.AlertType.WARNING);
            return;
        }
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnection.getConnection();

            String query = """
                    INSERT INTO PLACEMENT_TABLE(
                                                 STUDENT_NAME,EMAIL, PHONE, SESSION, COURSE,
                                                COMPANY_NAME, JOB_CITY, GENDER )VALUES (?,?,?,?,?,?,?,?)
                    """;
            ps = connection.prepareStatement(query);


            ps.setString(1,studentName);
            ps.setString(2,email);
            ps.setString(3,phone);
            ps.setString(4,session);
            ps.setString(5,course);
            ps.setString(6,companyName);
            ps.setString(7,jobCity);
            ps.setString(8,gender);

            int res = ps.executeUpdate();

            if (res > 0) {
                resetbt(null);
                showAlertBox.showAlertBox("success","Successfully Added",
                        Alert.AlertType.INFORMATION);

                System.out.println("success");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}

