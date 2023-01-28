package com.project.david;

import java.io.IOException;
import java.time.LocalDate;

import com.project.models.Student;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentListController {
    DataSingleton data  = DataSingleton.getInstance();

    private ObservableList<Student> studentData;

    @FXML private TableView studentsTableView;
    @FXML private TableColumn idCol;
    @FXML private TableColumn firstNameCol;
    @FXML private TableColumn lastNameCol;
    @FXML private TableColumn emailCol;
    @FXML private TableColumn ageCol;
    @FXML private TableColumn dateCol;
    @FXML private TableColumn phoneCol;
    @FXML private TableColumn levelCol;

    @FXML
    public void initialize() {
        // TODO Auto-generated method stub
        this.idCol.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        this.dateCol.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("birthdate"));
        //this.ageCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
        this.phoneCol.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        this.levelCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("level"));
        this.studentData = data.getStudents();
        this.studentsTableView.setItems(this.studentData);
        /*this.studentsTableView.setItems(data.getStudents());*/
    }

    @FXML
    private void displayStudentForm() throws IOException {
        App.setRoot("studentForm");
    }

    @FXML
    private void closeStudentForm() throws IOException {
        System.exit(0);
    }
}
