//DashBourd page

package ControllerPakage.final_project;

//import statements
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

//import static method
import static Models.HelperClass.switchScene;

public class DashBoardController implements Initializable {

    // fxml variables declaration and initializing
    @FXML
    private TableColumn<Student, String> colName;

    @FXML
    private TableColumn<Student, Integer> colID;

    @FXML
    private TableColumn<Student, Double> colGrade;

    @FXML private Label lblTotalStudents, lblAverageGrade, lblPassRate;

    @FXML private TableView<Student> tableRecentStudents;//the tableview itself

    //This method will initialize and remake the values everytime the class is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //set the columns main variables from class Student
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGrade.setCellValueFactory(new PropertyValueFactory<>("gradeNum"));

        //save the values from hash into the columns
        //only the last 3 students will be used in the table
        tableRecentStudents.getItems().add(Student.getHash().get(Student.idCounter-1));
        tableRecentStudents.getItems().add(Student.getHash().get(Student.idCounter-2));
        tableRecentStudents.getItems().add(Student.getHash().get(Student.idCounter-3));
        loadStatistics();//load other methods that needs to be initialized
    }

    //set the main labels that will be viewed in the page
    private void loadStatistics() {

        double percentageResult;
        String counter =String.valueOf((long) Student.getHash().size()); //student counter
        String average =String.format(Locale.US,"%05.2f",Student.getAverageGrade()); //student's grades average from class student

        //calculating the passed students percentage
        if(Integer.parseInt(counter)!=0) {// check if there is students or not in the system
            // this statement will count how many students succeed
            String passRate = String.valueOf(Student.getHash().values().stream().map(s -> s.getGradeNum()).filter(s -> s >= 60).count());
            // change the values into numbers types
            double numCounter = Double.parseDouble(counter); //the double for the decimals
            int numPassRate = Integer.parseInt(passRate);
            percentageResult = numPassRate / numCounter * 100.0;

        }
        else {
        percentageResult=0.0;
        }
        lblTotalStudents.setText(counter);
        lblAverageGrade.setText(average);
        //locale is for the language ,using the format for how many digits in the decimals
        lblPassRate.setText(String.format(Locale.US,"%05.2f",percentageResult)+"%");
    }

    //switch between buttons by using the method switchscene
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
    void goToRemoveStudents(ActionEvent event) throws IOException {
        switchScene(event, "RemoveStudents.fxml");
    }

    //this button will save the data from hashmap into the file
    @FXML
    void onSavingDate(ActionEvent event) throws IOException {
        HelperClass.printDataInFile();
        HelperClass.alert(Alert.AlertType.CONFIRMATION,"The Data Saved Successfully!",ButtonType.CLOSE,"The data");
    }
}