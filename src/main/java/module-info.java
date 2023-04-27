module com.example.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.studentmanagement to javafx.fxml;
    exports com.example.studentmanagement;

    opens com.example.studentmanagement.model to javafx.fxml;
    exports com.example.studentmanagement.model;

}