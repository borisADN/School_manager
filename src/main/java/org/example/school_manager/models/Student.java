package org.example.school_manager.models;

import org.example.school_manager.dbconfig.IDBConfig;
import org.example.school_manager.interfaces.StudentInterface;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class Student extends User implements StudentInterface {

private int id;
private String firstname;
private String lastname;
private LocalDate dateOfBirth;
private String placeOfBirth;
private int state = 0;
private String schoolGrade;

private Connection connection;


    public String getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(int schoolGrade) {
        this.schoolGrade = String.valueOf(schoolGrade);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }






    @Override
    public void add(Student student) throws SQLException {
        this.connection = IDBConfig.getConnection();
        if(connection != null){
            String req = "INSERT INTO student(firstname, lastname, dateOfBirth, placeOfBirth, state, schoolGrade) VALUES (?,?,?,?,?,?);";


            PreparedStatement prepareStatement = this.connection.prepareStatement(req);

            prepareStatement.setString(1, getFirstname());
            prepareStatement.setString(2, getLastname());
            prepareStatement.setDate(3, Date.valueOf(getDateOfBirth()));
            prepareStatement.setString(4, getPlaceOfBirth());
            prepareStatement.setInt(5, getState());
            prepareStatement.setString(6, getSchoolGrade());

            prepareStatement.execute();

            prepareStatement.close();

            this.connection.close();

        }

    }

    @Override
    public List<Student> read(int id) {
        return null;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Student student) {

    }


}
