package ControllerPakage.final_project;

import Models.HelperClass;
import Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class ViewReportsController implements Initializable {

    @FXML
    private TableColumn<Student, String> Major;

    @FXML
    private TableColumn<Student, String> Gradeletter;

    @FXML
    private TableColumn<Student, Double> Gradenum;

    @FXML
    private TableColumn<Student, Integer> ID;

    @FXML
    private TableColumn<Student, String> Studentname;

    @FXML
    private TableView<Student> THEtable;


    @FXML
    void BackToDashbourd(ActionEvent event) throws IOException {
        HelperClass.switchScene(event,"DashBoard.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        ID.setStyle("-fx-text-fill: white;");
//        Studentname.setStyle("-fx-text-fill: white;");
//        Major.setStyle("-fx-text-fill: white;");
//        Gradenum.setStyle("-fx-text-fill: white;");
//        Gradeletter.setStyle("-fx-text-fill: white;");
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Studentname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Major.setCellValueFactory(new PropertyValueFactory<>("major"));
        Gradenum.setCellValueFactory(new PropertyValueFactory<>("gradeNum"));
        Gradeletter.setCellValueFactory(new PropertyValueFactory<>("gradeLetter"));
        THEtable.getItems().addAll(Student.getHash().values());

    }
}
