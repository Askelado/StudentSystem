package Models;

import AppPakage.final_project.AddStudents;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Locale;
import java.util.Scanner;

public class HelperClass {

    public static void startStage(Stage stage, String fxml) throws IOException {
        Locale.setDefault(Locale.US);
        FXMLLoader fxmlLoader = new FXMLLoader(HelperClass.class.getResource("/ControllerPakage/final_project/".concat(fxml)));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Student System");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();

    }

    public static void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelperClass.class.getResource("/ControllerPakage/final_project/".concat(fxmlFile)));
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scener = (((Node)event.getSource()).getScene());
        scener.setRoot(fxmlLoader.load());
        stage.setScene(scener);
        stage.show();

    }
    public static void alert(Alert.AlertType msg,String text,ButtonType button,String title){
        Alert obj = new Alert(msg,text,button);
        obj.setHeaderText(title);
        obj.show();
    }

    public static void printDataInFile() throws IOException {
        Path path = Path.of("src/main/java/ControllerPakage/final_project/Students.txt");
        PrintWriter print = new PrintWriter(Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING),true);
        Student.getHash().values().stream().forEach(s->{
                    print.printf(Locale.US, "%-5d%20s%20s%12f%8s\n"
                            ,s.getId()
                            ,s.getName()
                            ,s.getMajor()
                            ,s.getGradeNum()
                            ,s.getGradeLetter());
                }
        );
    }

    public static void saveDataInHash() throws IOException {
        Path path =Path.of("src/main/java/ControllerPakage/final_project/Students.txt");
        Scanner scan = new Scanner(Files.newInputStream(path));

        while (scan.hasNextLine())
      {
               int id =Integer.parseInt(scan.findInLine(".{5}").trim());
               String name= scan.findInLine(".{20}").trim();
               String  major=scan.findInLine(".{20}").trim();
               double grade=Double.parseDouble(scan.findInLine(".{12}").trim());
               String  letter=scan.findInLine(".{8}").trim();
               Student student = new Student(name,major,grade,letter);
               scan.nextLine();
        }
    }
}
