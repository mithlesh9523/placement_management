package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class localDb {
    public class LocalDb {
        public ObservableList<String> getGenderList(){
            return FXCollections.observableArrayList("Male" , "Female" , "Other");
        }
    }

}
