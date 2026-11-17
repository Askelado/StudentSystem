module org.example.final_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires kotlin.stdlib;
    exports ControllerPakage.final_project;
    opens ControllerPakage.final_project to javafx.fxml;
    exports AppPakage.final_project;
    opens AppPakage.final_project to javafx.fxml;
    exports Models;
    opens Models to javafx.fxml;

}