package com.project.models;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class Person {
    
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    
    /**
     * Define constructors for the Person Class.
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param email
     * @param phoneNumber
     */
    public Person (String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the Person's ID as String.
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Set the Person's ID as String.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the Person's First Name as String.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the Person's First Name as String.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the Person's Last Name as String.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the Person's Last Name as String.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the person's Birth Date as String.
     * @return
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set the Person's Birth Date as String.
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the Person's Email as String.
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the person's Email as String.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the person's Phone Number as String.
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the person's Phone Number as String.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the person's Full Name.
     */
    public String getFullName(){
        return this.getFirstName()+" "+this.getLastName();
    }
    
    /**
     * Get the Person's Age.
     * @return
     */
    public int getAge(){
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String bDate = dateFormat.format(this.getBirthDate());
        LocalDate bDay = LocalDate.parse(bDate, formatter);
        Period age = Period.between(bDay, LocalDate.now());
        return age.getYears();*/
        LocalDate now = LocalDate.now();
        return Period.between(this.birthDate, now).getYears();
    }

    /**
     * Print the Person's Information.
     */
    public void print(){;      
        String id = this.getId();
        String fullname = this.getFullName();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(this.getBirthDate());
        int age = this.getAge();
        String mail = this.getEmail();
        String phone = this.getPhoneNumber();

        System.out.println("\n");
        System.out.println("***** Person Information *****");
        System.out.println("------- "+fullname+" -------");
        System.out.println("ID: "+id);
        System.out.println("Birth Date: "+date);
        System.out.println("Age: "+age+" años.");
        System.out.println("Email: "+mail);
        System.out.println("Phone Number: "+phone);
    }
}
