package ControllerPakage.final_project;

import Models.HelperClass;
import Models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static Models.HelperClass.switchScene;

public class DashBoardController implements Initializable {


    @FXML
    private TableColumn<Student, String> colName;

    @FXML
    private TableColumn<Student, Integer> colID;

    @FXML
    private TableColumn<Student, Double> colGrade;

    @FXML private Label lblTotalStudents, lblAverageGrade, lblPassRate;
    @FXML private TableView<Student> tableRecentStudents;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGrade.setCellValueFactory(new PropertyValueFactory<>("gradeNum"));
        tableRecentStudents.getItems().add(Student.getHash().get(Student.idCounter-1));
        tableRecentStudents.getItems().add(Student.getHash().get(Student.idCounter-2));
        tableRecentStudents.getItems().add(Student.getHash().get(Student.idCounter-3));
        loadStatistics();
    }

    private void loadStatistics() {

        double result;
        String counter =String.valueOf((long) Student.getHash().size());
        String average =String.format(Locale.US,"%05.2f",Student.getAverageGrade());
        if(Integer.parseInt(counter)!=0) {
            String passRate = String.valueOf(Student.getHash().values().stream().map(s -> s.getGradeNum()).filter(s -> s >= 60).count());
            double numCounter = Double.parseDouble(counter);
            int numPassRate = Integer.parseInt(passRate);
            result = numPassRate / numCounter * 100.0;

        }
        else {
        result=0.0;
        }
        lblTotalStudents.setText(counter);
        lblAverageGrade.setText(average);
        lblPassRate.setText(String.format(Locale.US,"%05.2f",result)+"%");
    }


    @FXML
    void goToAddStudent(ActionEvent event) throws IOException {
        switchScene(event, "AddStudents.fxml");
    }

    @FXML
    void goToAddGrades(ActionEvent event) throws IOException {
        switchScene(event, "AddGrades.fxml");
    }

    @FXML
    void goToViewStudents(ActionEvent event) throws IOException {
        switchScene(event, "ViewStudents.fxml");
    }

    @FXML
    void handleLogout(ActionEvent event) throws IOException {
        switchScene(event, "Login.fxml");
    }

    @FXML
    void goToShowReports(ActionEvent event) throws IOException {
        switchScene(event, "ViewReports.fxml");
    }

    @FXML
    void onSavingDate(ActionEvent event) throws IOException {
        HelperClass.printDataInFile();
        HelperClass.alert(Alert.AlertType.CONFIRMATION,"The Data Saved Successfully!",ButtonType.CLOSE,"The data");
    }

    @FXML
    void goToRemoveStudents(ActionEvent event) throws IOException {
        switchScene(event, "RemoveStudents.fxml");
    }
}