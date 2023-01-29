package com.project.david;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import com.project.dbhandler.PostgresConnect;
import com.project.models.Student;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class StudentListController {
    DataSingleton data  = DataSingleton.getInstance();
    PostgresConnect pgConnect = new PostgresConnect();
    @FXML private ObservableList<Student> studentData;
    @FXML private TableView studentsTableView;
    @FXML private TableView<Student> View;
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
    /**
     * Implements function to delete student selected
     */
    @FXML
    private void delete(){
        Student student=(Student)studentsTableView.getSelectionModel().getSelectedItem();
        if(student!=null){
            String studentID=student.getId();
            PostgresConnect pgConnection = new PostgresConnect();
            String sql = "delete from students where ci = ?"; 
            
            try {
                Connection connection = pgConnection.getConnection();
                PreparedStatement instruccion = connection.prepareStatement(sql);
                instruccion.setString(1, studentID); 
                instruccion.executeUpdate();
                DataSingleton.getInstance().deleteStudent(student);
                
                    
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    
}
