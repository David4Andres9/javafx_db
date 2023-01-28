package com.project.david;
import java.sql.Statement;
import com.project.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.project.dbhandler.PostgresConnect;

public class DataSingleton {

    showData data= new showData();
    Statement stmt = null;
    private static final DataSingleton instance = new DataSingleton();
    final String sql = "SELECT * FROM students";
    private ObservableList<Student> studentList = FXCollections.observableArrayList(
        
    );
    public void show(){
        PostgresConnect pgConnect = new PostgresConnect();
        
        Connection connection = pgConnect.getConnection();
        try {
            Statement instruccion = connection.createStatement();
            ResultSet rs = instruccion.executeQuery(sql);
            while (rs.next()) {
                String CI= rs.getString("CI");
                String FIRST_NAME= rs.getString("FIRST_NAME");
                String LAST_NAME= rs.getString("LAST_NAME");
                String EMAIL= rs.getString("EMAIL");
                int AGE= rs.getInt("AGE");
                String PHONE= rs.getString("PHONE");
                int LEVEL= rs.getInt("LEVEL");
              }
        } catch (SQLException e) {
            System.out.println("Error "+e);

        }
        
    }
    private DataSingleton () { 


    }

    public static DataSingleton getInstance() { 
        return instance; 
    }

    public ObservableList<Student> getStudents () {
        return this.studentList;
    }

    public void addStudent (Student student) {
        this.studentList.add(student);
    }
}
