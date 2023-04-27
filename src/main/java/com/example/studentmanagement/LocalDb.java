package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LocalDb {
    public static ObservableList<String> getGenderList(){
        return FXCollections.observableArrayList("Male" , "Female" , "Other");
    }
    public static ObservableList<String> getCourseList(){
        return FXCollections.observableArrayList("BCA" , "BBM" , "BSC IT");
    }
    public static ObservableList<String> getStudentGender(){
        return FXCollections.observableArrayList("Male", "Female", " other");
    }

}