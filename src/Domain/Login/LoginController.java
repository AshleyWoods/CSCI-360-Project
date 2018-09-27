package Domain.Login;

import Application.VotingSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class LoginController {

    private Main main;
    @FXML
    private ComboBox loginChoice;


    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleRegisterClick(){
        main.showVoterRegistration();
    }

    @FXML
    public void handleContinueClick(){
        if (loginChoice.getValue() == null) {return;}
        //THIS LINE CAN THROW A NULL POINTER EXCEPTION IF THE USER DOES NOT PICK AN OPTION, HOW TO FIX?
        if (loginChoice.getValue().equals("Driver's Licence")){
            //take them to the drivers licence login
            main.showDriverLogin();
        }
        else if (loginChoice.getValue().equals("Social Security Number")){
            //take them to the ssn login
            main.showSSNLogin();
        }
        else if (loginChoice.getValue().equals("Voter Registration Number")){
            //take them to the vrn login
            main.showVRNLogin();
        }
        else {
            //take them to the admin login
            main.showAdminLogin();
        }

    }

}
