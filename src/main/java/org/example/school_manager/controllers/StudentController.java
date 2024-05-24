package org.example.school_manager.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.school_manager.models.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public class StudentController {
   void erase(){
       firstnameTextField.setText("");
       lastnameTextField.setText("");
       stateTextField.setText("");
       classroomTextField.setText("");
       dateOfBirthDatePicker.cancelEdit();
       placeOfBirthTextField.setText("");
   }


    @FXML
    private Label errorMessageLabel;

    @FXML
    private Label registrationMessageLabel;
    @FXML
    private Button closeButton;
    @FXML
    private TextField classroomTextField;
    @FXML
    private TextField stateTextField;
    @FXML
    private DatePicker dateOfBirthDatePicker;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField placeOfBirthTextField;

    @FXML
    private Button registerButton;
    @FXML
    void closeButtonOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void registerButtonOnAction(ActionEvent event) throws SQLException {


        if (firstnameTextField.getText().isEmpty() || lastnameTextField.getText().isEmpty()
                || placeOfBirthTextField.getText().isEmpty()  || dateOfBirthDatePicker.getValue() == null
        || classroomTextField.getText().isEmpty() || stateTextField.getText().isEmpty() ){
            errorMessageLabel.setText("Les champs sont obligatoires !");


        }else {
            LocalDate dateOfBirth = dateOfBirthDatePicker.getValue();
            String firstName = firstnameTextField.getText().trim();
            String lastName = lastnameTextField.getText().trim();
            int state = Integer.parseInt(stateTextField.getText().trim());
            String classroom = classroomTextField.getText().trim();
            String placeOfBirth = placeOfBirthTextField.getText().trim();

            Student student = new Student();

            student.setFirstname(firstName);
            student.setState(state);
            student.setSchoolGrade(Integer.parseInt(classroom));
            student.setLastname(lastName);
            student.setPlaceOfBirth(placeOfBirth);
            student.setDateOfBirth(dateOfBirth);

            student.add(student);
            registrationMessageLabel.setText("L’élève a été enregistré avec succès !");
            erase();
        }

    }





}
