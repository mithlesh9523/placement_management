package com.example.studentmanagement;

import com.example.studentmanagement.model.PlacementTableModel;
import com.example.studentmanagement.model.StudentsModel;
import com.example.studentmanagement.util.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class PlacementTable implements Initializable {
    public TableView<PlacementTableModel> tableview;
    public TableColumn<PlacementTableModel,String> colId;
    public TableColumn<PlacementTableModel,String> colName;
    public TableColumn<PlacementTableModel,String> colEmail;
    public TableColumn<PlacementTableModel,String> colPhone;
    public TableColumn<PlacementTableModel,String> colSession;
    public TableColumn<PlacementTableModel,String> colCourse;
    public TableColumn<PlacementTableModel,String> colCompanyName;
    public TableColumn<PlacementTableModel,String> colJobCity;
    public TableColumn<PlacementTableModel,String> colGender;
    public TableColumn<PlacementTableModel,String> colAction;
    private ShowAlertBox showAlertBox;
    private final ObservableList<PlacementTableModel> placementlist = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAlertBox = new ShowAlertBox();
        getAllStudent();
    }
    private void setOptionalCell() {
        Callback<TableColumn<PlacementTableModel, String>, TableCell<PlacementTableModel, String>>
                cellFactory = (TableColumn<PlacementTableModel, String> param) -> new TableCell<>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    Button edit = new Button("EDIT");
                    Button delete = new Button("DELETE");

                    edit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            selectTable(tableview, getIndex());
                            PlacementTableModel bm = tableview.getSelectionModel().getSelectedItem();
                            Main.primaryStage.setUserData(bm);
                            new ShowAlertBox().showAm("");

                            // receive

                        }

                    });

                    delete.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            selectTable(tableview, getIndex());
                            PlacementTableModel dm = tableview.getSelectionModel().getSelectedItem();



                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning ");
                            alert.setHeaderText("Are you sure you want to delete is PlacementStudent?");
                            alert.initModality(Modality.APPLICATION_MODAL);
                            alert.initOwner(Main.primaryStage);
                            Optional<ButtonType> result = alert.showAndWait();
                            ButtonType button = result.orElse(ButtonType.CANCEL);
                            if (button == ButtonType.OK) {
                                deleteStudent(dm.getStudent_id());
                            } else {
                                alert.close();
                            }


                        }


                    });

                    edit.setStyle("-fx-background-color: #006666;-fx-text-fill: white;-fx-font-weight: bold;-fx-cursor: hand");
                    delete.setStyle("-fx-background-color: red;-fx-text-fill: white;-fx-font-weight: bold;-fx-cursor: hand");
                    HBox managebtn = new HBox(edit, delete);
                    HBox.setMargin(delete, new Insets(5, 5, 5, 20));
                    managebtn.setStyle("-fx-alignment:center");

                    setGraphic(managebtn);
                    setText(null);

                }
            }

            private void deleteStudent(int studentId) {
                Connection connection = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    connection = new DbConnection().getConnection();
                    String query = "delete from PLACEMENT_TABLE where STUDENT_ID = ?";
                    ps = connection.prepareStatement(query);
                    ps.setInt(1, studentId);
                    int res = ps.executeUpdate();

                    if (res > 0) {
                        getAllStudent();
                        showAlertBox.showAlertBox("Success", "Successfully deleted", Alert.AlertType.INFORMATION);
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    DbConnection.closeConnection(connection,ps,rs);
                }

            }

            private void selectTable(TableView<PlacementTableModel> tableview, int index) {
                tableview.getSelectionModel().select(index);
            }

        };

        colAction.setCellFactory(cellFactory);
    }

    private void getAllStudent() {
        if (null != placementlist) {
            placementlist.clear();
        }
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DbConnection.getConnection();
            String query = """
                  
                   SELECT * FROM PLACEMENT_TABLE;
                    
                    """;

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
            int student_id = rs.getInt("student_id");
            String student_name = rs.getString("student_name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String session = rs.getString("session");
            String course = rs.getString("course");
            String company_name = rs.getString("company_name");
            String job_city = rs.getString("job_city");
            String gender = rs.getString("gender");
           String createDate = rs.getString("create_Date");

                PlacementTableModel placementTableModel = new PlacementTableModel(student_id,
                        student_name, email, phone, session, course, company_name, job_city, gender,createDate );

                placementlist.add(placementTableModel);
            }
            tableview.setItems(placementlist);

            colId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            colSession.setCellValueFactory(new PropertyValueFactory<>("session"));
            colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
            colCompanyName.setCellValueFactory(new PropertyValueFactory<>("company_name"));
            colJobCity.setCellValueFactory(new PropertyValueFactory<>("job_city"));
            colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

            setOptionalCell();

        }catch (SQLException e){
            throw new RuntimeException(e);

        }finally {
            DbConnection.closeConnection(connection,ps,rs);
        }
    }

    public void addplacemantstudentbt(ActionEvent actionEvent) {
        new CustomFxmlDialog().Show("addStudentPlacement.fxml");
    }
}
