package AppPakage.final_project;

import Models.HelperClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoveStudents extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        HelperClass.startStage( stage,"RemoveStudents.fxml");
    }
}
