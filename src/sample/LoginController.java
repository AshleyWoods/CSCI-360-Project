package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;

public class LoginController {

    private Main main;
    @FXML
    private ComboBox<String> loginChoice;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegisterClick(){
        main.showVoterRegistration();
    }

    @FXML
    private void handleContinueClick(){
        String choice = loginChoice.getValue();
        //THIS LINE CAN THROW A NULL POINTER EXCEPTION IF THE USER DOES NOT PICK AN OPTION, HOW TO FIX?
        if (choice.equals("Driver's Licence")){
            //take them to the drivers licence login
            showDriverLogin();
        }
        else if (choice.equals("Social Security Number")){
            //take them to the ssn login
            showSSNLogin();
        }
        else if (choice.equals("Voter Registration Number")){
            //take them to the vrn login
            showVRNLogin();
        }
        else {
            //take them to the admin login
            showAdminLogin();
        }

    }

    private void showDriverLogin() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("DriverLogin.fxml"));
            AnchorPane DriverLogin = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            //cannot reference on-static method from a static method
           // Main.setCenter(DriverLogin);

            // this controller will also control all login pages

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSSNLogin() {}

    private void showVRNLogin() {}

    private void showAdminLogin() {}
}
