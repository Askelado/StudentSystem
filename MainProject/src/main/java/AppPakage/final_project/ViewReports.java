package AppPakage.final_project;

import Models.HelperClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewReports extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HelperClass.startStage( stage,"ViewReports.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}