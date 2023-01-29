package com.project.david;
import java.sql.Statement;
import java.time.LocalDate;
import com.project.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.dbhandler.PostgresConnect;

public class DataSingleton {
    PostgresConnect pgConnect = new PostgresConnect();
    private static final DataSingleton instance = new DataSingleton();
    private ObservableList<Student> studentList = FXCollections.observableArrayList();
    
    private void show(){
        String sql = "SELECT * FROM students";
        try (Connection connection = pgConnect.getConnection();Statement instruccion = connection.createStatement();ResultSet rs = instruccion.executeQuery(sql);){
            while (rs.next()) {
                String ci= rs.getString("ci");
                String first_name= rs.getString("first_name");
                String last_name= rs.getString("last_name");
                String email= rs.getString("email");
                LocalDate birthdate= rs.getDate("birthdate").toLocalDate();
                String phone= rs.getString("phone");
                int level= rs.getInt("level");
                studentList.add(new Student(ci, first_name, last_name, birthdate, email, phone, level));
              }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        
    }

    
    private DataSingleton () { 
        this.show();

    }
    /**
     * 
     * @return
     */
    public static DataSingleton getInstance() { 
        return instance; 
    }

    public ObservableList<Student> getStudents () {
        return this.studentList;
    }

    public void addStudent (Student student) {
        this.studentList.add(student);
    }
    
    public void deleteStudent (Student student) {
        studentList.remove(student);
        
    }
}
