package com.project.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import com.project.dbhandler.PostgresConnect;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Student extends Person {
    private static ObservableList<Student> studentList = FXCollections.observableArrayList();
    private int level;

    /**
     * Generates the Staff Constructor.
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param email
     * @param phoneNumber
     * @param level
     */

     public Student (String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, int level) {
        super(id, firstName, lastName, birthDate, email, phoneNumber);
        this.level = level;
     }

    /**
     * Get the Student's level as integer.
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the Student's level as integer.
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    
    @Override
    public void print() {
        super.print();
        System.out.println("Level: "+this.level);
    }

    @Override
    public String getFullName() { 
        return super.getFullName();
    }

    public SimpleStringProperty idProperty(){
        return new SimpleStringProperty(this.getId());
    }

    public SimpleStringProperty firstNameProperty(){
        return new SimpleStringProperty(this.getFirstName());
    }

    public SimpleStringProperty lastNameProperty(){
        return new SimpleStringProperty(this.getLastName());
    }

    public SimpleStringProperty emailProperty(){
        return new SimpleStringProperty(this.getEmail());
    }
    
    public SimpleIntegerProperty ageProperty(){
        return new SimpleIntegerProperty(this.getAge());
    }
    public SimpleObjectProperty birthdateProperty(){
        return new SimpleObjectProperty(this.getBirthDate());
    }

    public SimpleStringProperty phoneProperty(){
        return new SimpleStringProperty(this.getPhoneNumber());
    }
    public SimpleIntegerProperty levelProperty(){
        return new SimpleIntegerProperty(this.getLevel());
    }

    public void save() {
        final String sql = "INSERT INTO students" + 
        " (ci,first_name,last_name,email,birthdate,phone,level) VALUES " + 
        " (?, ?, ?, ?, ?, ?, ?);";
        PostgresConnect pgConnect = new PostgresConnect();
        Connection connection = pgConnect.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, this.getId());
            preparedStatement.setString(2, this.getFirstName());
            preparedStatement.setString(3, this.getLastName());
            preparedStatement.setString(4, this.getEmail());
            preparedStatement.setDate(5, Date.valueOf(getBirthDate()));
            preparedStatement.setString(6, this.getPhoneNumber());
            preparedStatement.setLong(7, this.getLevel());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static ObservableList<Student> show(){
        String sql = "SELECT * FROM students";
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        PostgresConnect pgConnect = new PostgresConnect();
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
              return studentList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void delete(String studentID, Student student){
        PostgresConnect pgConnection = new PostgresConnect();
        String sql = "delete from students where ci = ?"; 
            
        try {
            Connection connection = pgConnection.getConnection();
            PreparedStatement instruccion = connection.prepareStatement(sql);
            instruccion.setString(1, studentID); 
            instruccion.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

