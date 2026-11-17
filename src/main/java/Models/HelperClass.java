//model helperclass for the repetitive methods and to use the abstraction principle

package Models;

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
        Locale.setDefault(Locale.US);//sit the language
        FXMLLoader fxmlLoader = new FXMLLoader(HelperClass.class.getResource("/ControllerPakage/final_project/".concat(fxml)));//load the scene
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);//sit the window
        stage.setTitle("Student System");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();

    }

    //method switch scenes
    public static void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelperClass.class.getResource("/ControllerPakage/final_project/".concat(fxmlFile)));
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());//get the main window
        Scene scener = (((Node)event.getSource()).getScene()); //get the main scene
        scener.setRoot(fxmlLoader.load());//change the root of the main scene
        stage.setScene(scener);//set the scene
        stage.show();

    }
    //alert method
    public static void alert(Alert.AlertType msg,String text,ButtonType button,String title){
        Alert obj = new Alert(msg,text,button);
        obj.setHeaderText(title);
        obj.show();
    }

    public static void printDataInFile() throws IOException {
        Path path = Path.of("src/main/java/ControllerPakage/final_project/Students.txt");//get the file path
        //use printwriter class to save records in file
        PrintWriter print = new PrintWriter(Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING),true);
        //print values in the file by using stream
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

    //method to load data from the file into the hashmap
    public static void saveDataInHash() throws IOException {
        Path path =Path.of("src/main/java/ControllerPakage/final_project/Students.txt");
        Scanner scan = new Scanner(Files.newInputStream(path)); //scanner to read data

        while (scan.hasNextLine()) //check if the next line is null or not
      {
          //use regular expression to read from the file
               int id =Integer.parseInt(scan.findInLine(".{5}").trim());
               String name= scan.findInLine(".{20}").trim();
               String  major=scan.findInLine(".{20}").trim();
               double grade=Double.parseDouble(scan.findInLine(".{12}").trim());
               String  letter=scan.findInLine(".{8}").trim();
               Student student = new Student(name,major,grade,letter);
               scan.nextLine(); //new line
        }
    }
}
