package ControllerPakage.final_project;
import Models.HelperClass;
import Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.io.IOException;

public class AddStudentsController {

    @FXML
    private TextField major;

    @FXML
    private TextField studentName;

    @FXML
    void onMajor(ActionEvent event) {

    }

    @FXML
    void StudentNameControll(ActionEvent event) {

    }

    @FXML
    void SaveRecords(ActionEvent Button) {
        Student obj =new Student(studentName.getText(), major.getText(),0.0," ");
        HelperClass.alert(Alert.AlertType.CONFIRMATION,"The Student is Added Successfully", ButtonType.OK,"Student");
    }

    @FXML
    void BackToDashbourd(ActionEvent event) throws IOException {
        HelperClass.switchScene(event,"DashBoard.fxml");
    }
}