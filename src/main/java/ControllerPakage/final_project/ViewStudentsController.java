package ControllerPakage.final_project;

import Models.HelperClass;
import Models.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewStudentsController implements Initializable {

    // this variable will Connect the TextArea with the hash values
    @FXML
    private TextArea textArea;

    //This method will initialize and remake the values everytime the class is loaded
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Student.getHash().values().forEach(s-> {//use foreach to print with append
        textArea.appendText(s.getId()+"\t \t \t"+s.getName()+"\n");

        }
        );

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        HelperClass.switchScene(event,"DashBoard.fxml");// call a method to switch between scenes
    }
}
