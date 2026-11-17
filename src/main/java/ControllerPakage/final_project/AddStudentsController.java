// Add student page

package ControllerPakage.final_project;

// import statements
import Models.HelperClass;
import Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.io.IOException;

public class AddStudentsController {

    // fxml variables declaration
    @FXML
    private TextField major;

    @FXML
    private TextField studentName;

    // methods declaration
    @FXML
    void onMajor(ActionEvent event) {
    // nothing to use here, but it is mandatory for the method it self to be written
    }

    @FXML
    void StudentNameControll(ActionEvent event) {
        // nothing to use here, but it is mandatory for the method it self to be written
    }

    // button method to save records into the hashmap
    @FXML
    void SaveRecords(ActionEvent Button) {
        // make the student object that it will be saved into the hashmap
        Student obj =new Student(studentName.getText(), major.getText(),0.0," ");// gradenum and gradeletter as a default value
        HelperClass.alert(Alert.AlertType.CONFIRMATION,"The Student is Added Successfully", ButtonType.OK,"Student");// call alert method
    }

    // back to dashbourd button
    @FXML
    void BackToDashbourd(ActionEvent event) throws IOException {
        HelperClass.switchScene(event,"DashBoard.fxml");// call a method to switch between scenes
    }
}