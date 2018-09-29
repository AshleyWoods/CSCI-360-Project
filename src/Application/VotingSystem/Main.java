package Application.VotingSystem;

import Domain.Ballots.Ballot1Controller;
import Domain.Login.*;
import Domain.Registration.ConfirmFormSaveController;
import Domain.Registration.ConfirmFormSubmissionController;
import Domain.Registration.NoRegistrationPopUpController;
import Domain.Registration.VoterRegistrationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static Domain.Registration.VoterRegistrationController.cancel;

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
        loader.setLocation(getClass().getClassLoader().getResource("UI/RootLayout/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        showLogin();
    }

    public void showDriverLogin () {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Login/DriverLogin.fxml"));
            AnchorPane DriverLogin = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(DriverLogin);

            DriverLoginController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showSSNLogin () {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Login/SSNLogin.fxml"));
            AnchorPane SSNLogin = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(SSNLogin);

            SSNLoginController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showVRNLogin () {
       try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Login/VRNLogin.fxml"));
            AnchorPane VRNLogin = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(VRNLogin);

            VRNLoginController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showAdminLogin () {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Login/AdminLogin.fxml"));
            AnchorPane AdminLogin = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(AdminLogin);

            AdminLoginController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   //Go to login screen

    public void showLogin(){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Login/LoginScreen.fxml"));
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
            load.setLocation(Main.class.getClassLoader().getResource("UI/Registration/NoRegistrationPopUp.fxml"));
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
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Registration/VoterRegistration.fxml"));
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

    public boolean showSubmissionConfirmationPopup () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Registration/ConfirmFormSubmission.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage confirmSubmit = new Stage();
            confirmSubmit.setTitle("Confirm Form Submission");
            Scene confirmSubmitScene = new Scene(page);
            confirmSubmit.setScene(confirmSubmitScene);

            ConfirmFormSubmissionController controller = loader.getController();
            controller.setMain(this);

            confirmSubmit.showAndWait();

            return cancel;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showBallot() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Ballots/Ballot1.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(page);

            // Give the controller access to the main app.
            Ballot1Controller controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSaveConfirmationPopUp () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("UI/Registration/ConfirmFormSave.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage confirmSave = new Stage();
            confirmSave.setTitle("Form Saved");
            Scene confirmSaveScene = new Scene(page);
            confirmSave.setScene(confirmSaveScene);

            ConfirmFormSaveController controller = loader.getController();
            controller.setMain(this);

            confirmSave.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
