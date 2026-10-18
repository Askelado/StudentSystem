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

    // Connects the TextArea from the FXML Students.txt
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Student.getHash().values().forEach(s-> {
        textArea.appendText(s.getId()+"\t \t \t"+s.getName()+"\n");

        }
        );

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        HelperClass.switchScene(event,"DashBoard.fxml");
    }
}
