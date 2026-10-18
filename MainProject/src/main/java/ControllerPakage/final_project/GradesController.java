package ControllerPakage.final_project;

import Models.HelperClass;
import Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GradesController {

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtGrade;

    @FXML
    private void handleSaveGrade(ActionEvent event) {

        if(Student.getHash().containsKey(Integer.parseInt(txtStudentId.getText())) && (100 >= Double.parseDouble(txtGrade.getText())) && (0 < Double.parseDouble(txtGrade.getText()))) {
            Student.getHash().values().stream().filter(s -> s.getId() == Integer.parseInt(txtStudentId.getText())).findAny().ifPresent(s -> s.setGradeNum(Double.parseDouble(txtGrade.getText())));
            HelperClass.alert(Alert.AlertType.CONFIRMATION,"The grade is added successfully!", ButtonType.OK,"The grade");

        }
        else {
            HelperClass.alert(Alert.AlertType.ERROR, "invalid inputs! \n Please enter a valid ID", ButtonType.OK, "ERROR!");
        }
        }

    @FXML
    private void handleBackToDashboard(ActionEvent event) throws IOException {
        HelperClass.switchScene(event, "DashBoard.fxml");
        }

}

