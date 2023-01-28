package com.project.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.project.dbhandler.PostgresConnect;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Student extends Person {

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

    /**
     * Print the Student´s Complementary Information
     * @see JavaOPP.studentManagement.Person#print()
     */
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
    public SimpleStringProperty phoneProperty(){
        return new SimpleStringProperty(this.getPhoneNumber());
    }
    public SimpleIntegerProperty levelProperty(){
        return new SimpleIntegerProperty(this.getLevel());
    }

    public void save() {
        final String sql = "INSERT INTO students" + 
        " (ci,first_name,last_name,email,age,phone,level) VALUES " + 
        " (?, ?, ?, ?, ?, ?, ?);";
        PostgresConnect pgConnect = new PostgresConnect();
        Connection connection = pgConnect.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, this.getId());
            preparedStatement.setString(2, this.getFirstName());
            preparedStatement.setString(3, this.getLastName());
            preparedStatement.setString(4, this.getEmail());
            preparedStatement.setLong(5, this.getAge());
            preparedStatement.setString(6, this.getPhoneNumber());
            preparedStatement.setLong(7, this.getLevel());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
