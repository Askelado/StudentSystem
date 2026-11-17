//Add Grades page

package ControllerPakage.final_project;

//import statements
import Models.HelperClass;
import Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.io.IOException;

public class GradesController {

    // fxml variables declaration
    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtGrade;

    //this button is for saving grades into the hashmap
    @FXML
    private void handleSaveGrade(ActionEvent event) {
        //this statement check if the entered id is valid and the entered grade is valid grade too
        if(Student.getHash().containsKey(Integer.parseInt(txtStudentId.getText())) && (100 >= Double.parseDouble(txtGrade.getText())) && (0 < Double.parseDouble(txtGrade.getText()))) {
            //if the id exists then save the grade in the student object
            Student.getHash().values().stream().filter(s -> s.getId() == Integer.parseInt(txtStudentId.getText())).findAny().ifPresent(s -> s.setGradeNum(Double.parseDouble(txtGrade.getText())));
            HelperClass.alert(Alert.AlertType.CONFIRMATION,"The grade is added successfully!", ButtonType.OK,"The grade");

        }// if the entered id is not valid or the entered grade is not a valid grade
        else {
            HelperClass.alert(Alert.AlertType.ERROR, "invalid inputs! \n Please enter a valid Inputs", ButtonType.OK, "ERROR!");
        }
        }

    @FXML
    private void handleBackToDashboard(ActionEvent event) throws IOException {
        HelperClass.switchScene(event, "DashBoard.fxml");// call a method to switch between scenes
        }

}

