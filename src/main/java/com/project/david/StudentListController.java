package com.project.david;

import java.io.IOException;
import java.time.LocalDate;
import com.project.dbhandler.PostgresConnect;
import com.project.models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class StudentListController {
    PostgresConnect pgConnect = new PostgresConnect();
    @FXML private TableView studentsTableView;
    @FXML private TableColumn idCol;
    @FXML private TableColumn firstNameCol;
    @FXML private TableColumn lastNameCol;
    @FXML private TableColumn emailCol;
    @FXML private TableColumn ageCol;
    @FXML private TableColumn dateCol;
    @FXML private TableColumn phoneCol;
    @FXML private TableColumn levelCol;
    @FXML private TextField txtStudentID;

    @FXML
    public void initialize() {
        
        // TODO Auto-generated method stub
        this.idCol.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        this.dateCol.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("birthdate"));
        this.phoneCol.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        this.levelCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("level"));
        this.studentsTableView.setItems(Student.show());
        
    }

    @FXML
    private void displayStudentForm() throws IOException {
        App.setRoot("studentForm");
        
    }

    @FXML
    private void closeStudentForm() throws IOException {
        System.exit(0);
    }

    @FXML
    private void deleteStudent(){
        Student student=(Student)studentsTableView.getSelectionModel().getSelectedItem();
        if(student!=null){
            String studentID=student.getId();
            student.delete(studentID, student);
            this.studentsTableView.setItems(Student.show());
        }
        
    }

     

    
}
