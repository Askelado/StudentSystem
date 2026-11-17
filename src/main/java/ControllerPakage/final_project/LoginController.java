//Login page

package ControllerPakage.final_project;

import Models.HelperClass;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class LoginController {
    // the tag means its connected to fxml file and these are what they are to
    @FXML
    private TextField usernametxt;
    @FXML
    private PasswordField passwordtxt;
    @FXML
    private Label errorMsg;


    /* -runs when login button clicked to get info  and move to dashboard
       -if dashboard fxml not found it crashs
    */
    @FXML
    void loginbtn(ActionEvent event) throws Exception {

        String user = usernametxt.getText();
        String pass = passwordtxt.getText();


        /* first check the user and pass both must match the one typed here if not error message will occur
        for now its admin 7777 we can change it later if needed
        */
        if (user.equals("admin") && pass.equals("7777")) {

            // load screen dashboard
          HelperClass.switchScene(event,"DashBoard.fxml");

        } else {

            errorMsg.setText("wrong username or password");
        }
    }


    /* when you press this button, you will get alert screen with the login info
       it shows an alert in case the user forgets the password and username
     */
    @FXML
    void forgotpass(ActionEvent event) {
        HelperClass.alert(Alert.AlertType.INFORMATION, "username admin" + "\n" + "password: 7777", ButtonType.OK,"Forgot Password");
    }

}