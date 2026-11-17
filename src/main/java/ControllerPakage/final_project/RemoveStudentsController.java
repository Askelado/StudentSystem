//Remove Students page
//Bonus page
package ControllerPakage.final_project;

import Models.HelperClass;
import Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RemoveStudentsController {

    // fxml variables declaration
    @FXML
    private TextField ID;

    @FXML
    void backToDashBourd(ActionEvent event) throws IOException {
        HelperClass.switchScene(event,"DashBoard.fxml");// call a method to switch between scenes
    }

    @FXML
    void onEnteringStudent(ActionEvent event) {
        // nothing to use here, but it is mandatory for the method it self to be written
    }

    //remove button
    @FXML
    void onRemoving(ActionEvent event) {
        //if the id is valid ,the student will be removed
        if(Student.getHash().values().stream().anyMatch(s-> s.getId()==Integer.parseInt(ID.getText()))) {
            Student.removeFromHash(Integer.valueOf(ID.getText()));
            HelperClass.alert(Alert.AlertType.CONFIRMATION, "The student is removed", ButtonType.OK, "remove");
        }
        else {
            HelperClass.alert(Alert.AlertType.ERROR, "The ID is wrong \n Please enter a valid ID", ButtonType.OK, "ERROR!");
        }
    }
}
