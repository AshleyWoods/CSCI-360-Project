package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ConfirmFormSaveController {

    private Main main;
    @FXML
    private Button MenuButton;
    @FXML
    private Button BallotButton;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleMainMenu(){

       Stage popUp = (Stage) MenuButton.getScene().getWindow();
       popUp.close();

       main.showLogin();
    }

    @FXML
    public void handleBallot(){
        //send voter straight to first ballot
        Stage popUp = (Stage) BallotButton.getScene().getWindow();
        popUp.close();

        //main.showFirstBallot() <-- Not currently implemented
    }

}
