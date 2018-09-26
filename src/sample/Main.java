package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    //This variable will be changed when an operator starts or ends an election
    private boolean ElectionRunning = false;
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SC Electronic Voting");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        showLogin();
    }

    public void setCenter(Node scene) {
        rootLayout.setCenter(scene);
    }

   //Go to login screen

    public void showLogin(){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("LoginScreen.fxml"));
            AnchorPane LoginScreen = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(LoginScreen);

            // Give the controller access to the main app.
            LoginController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Go to the voter registration page when the 'Register to Vote' button is clicked
    public void showVoterRegistration(){
        try{
        if (ElectionRunning) {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(Main.class.getResource("NoRegistrationPopUp.fxml"));
            AnchorPane NoVoterRegistration = (AnchorPane) load.load();

            Stage errorAlert = new Stage();
            errorAlert.setTitle("Invalid Action");
            Scene errorAlertScene = new Scene(NoVoterRegistration);
            errorAlert.setScene(errorAlertScene);

            NoRegistrationPopUpController controller = load.getController();
            controller.setMain(this);

            errorAlert.showAndWait();

            return;
        }

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("VoterRegistration.fxml"));
            AnchorPane VoterRegistration = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(VoterRegistration);

            // Give the controller access to the main app.
            VoterRegistrationController controller = loader.getController();
            controller.setMain(this);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
