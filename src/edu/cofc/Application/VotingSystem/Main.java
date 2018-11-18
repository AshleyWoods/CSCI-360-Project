package edu.cofc.Application.VotingSystem;

import edu.cofc.Administration.Controller.AdminMenuController;
import edu.cofc.Administration.Controller.ElectionRunningPopUpController;
import edu.cofc.Administration.Controller.NoElectionPopUpController;
import edu.cofc.Administration.Controller.Tally.*;
import edu.cofc.Administration.Controller.endElectionPopUpController;
import edu.cofc.Administration.Controller.startElectionPopUpController;
import edu.cofc.Administration.view.AdminTallyView;
import edu.cofc.Application.Election;
import edu.cofc.Ballots.Controller.Ballot1Controller;
import edu.cofc.Ballots.Controller.FinalBallotController;
import edu.cofc.Ballots.Controller.SavePopUpController;
import edu.cofc.Login.Controller.*;
import edu.cofc.Registration.Controller.*;
import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Voter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.cofc.Registration.Controller.VoterRegistrationController.cancel;

public class Main extends Application {

    //This variable will be changed when an operator starts or ends an election
    public  boolean ElectionRunning = false;
    public static Election currentElection;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AdminTallyView adminTallyView;
    //this variable will be changed when an operator completes an official tally 
    public boolean officialTally = false;
    public static Voter activeVoter;
    public TextInterface textInterface = new TextInterface();
  
    
   

    @Override
    public void start(Stage primaryStage) throws Exception{
    

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SC Electronic Voting");
        
        this.ElectionRunning = false;
        //edu.cofc.Administration.Controller.AdminMenuController.officialTally = false;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("edu/cofc/View/RootLayout/RootLayout.fxml"));
        rootLayout = loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        //ADD CSS FILE
        scene.getStylesheets().add(Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
        //END ADD CSS FILE
        primaryStage.show();
        currentElection = new Election();

        adminTallyView = new AdminTallyView(rootLayout, this);

        showLogin();
    }

    public static Election getCurrentElection() {
        return currentElection;
    }

    public void showRecount() {
    	adminTallyView.showRecount();
    }


    public void showRegistrationInvestigation() {
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/registrationInvestigation.fxml"));
            AnchorPane page = loader.load();


            rootLayout.setCenter(page);

            registrationInvestigationController controller = loader.getController();
            controller.setMain(this);

    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    public void showDownloadOfficialTally() {
    	adminTallyView.showDownloadOfficialTally();
    }
    public void showDriverLogin () {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Login/View/DriverLogin.fxml"));
            AnchorPane DriverLogin = loader.load();

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
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Login/View/SSNLogin.fxml"));
            AnchorPane SSNLogin = loader.load();

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
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Login/View/VRNLogin.fxml"));
            AnchorPane VRNLogin = loader.load();

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
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Login/View/AdminLogin.fxml"));
            AnchorPane AdminLogin = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(AdminLogin);

            AdminLoginController controller = loader.getController();
            controller.setMain(this);
            //ADD CSS FILE
            AdminLogin.getStylesheets().add(Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   //Go to login screen

    public void showLogin(){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Login/View/LoginScreen.fxml"));
            AnchorPane LoginScreen =  loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(LoginScreen);
            rootLayout.getStyleClass().add("root");

            // Give the controller access to the main app.
            LoginController controller = loader.getController();
            controller.setMain(this, ElectionRunning);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAdminMenu(){
        adminTallyView.showAdminMenu();
    }

    public void showTally() {
       adminTallyView.showTally();
    }
    


    //Go to the voter registration page when the 'Register to Vote' button is clicked
    public void showVoterRegistration(){
        try{
        if (ElectionRunning) {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/NoRegistrationPopUp.fxml"));
            AnchorPane NoVoterRegistration = load.load();

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
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/VoterRegistration.fxml"));
            AnchorPane VoterRegistration =  loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(VoterRegistration);

            // Give the controller access to the main app.
            VoterRegistrationController controller = loader.getController();
            controller.setMain(this);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOfficialConfirmationPopUp() {
       adminTallyView.showOfficialConfirmationPopUp();
    }

    public void showUnofficialConfirmationPopUp() {
       adminTallyView.showUnofficialConfirmationPopUp();
    }

    public boolean showSubmissionConfirmationPopup () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/ConfirmFormSubmission.fxml"));
            AnchorPane page =  loader.load();


            Stage confirmSubmit = new Stage();
            confirmSubmit.setTitle("Confirm Form Submission");
            
            ConfirmFormSubmissionController controller = loader.getController();
            controller.setMain(this);

            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
            		+ "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
            		+ "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            confirmSubmit.setScene(new Scene(layout));

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
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Ballots/View/Ballot1.fxml"));
            AnchorPane page = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(page);

            // Give the controller access to the main app.
            Ballot1Controller controller = loader.getController();
            controller.setMain(this);
            
            //ADD CSS FILE
            rootLayout.getStylesheets().add
            (Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFinalBallot() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Ballots/View/FinalBallot.fxml"));
            AnchorPane page = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(page);

            // Give the controller access to the main app.
            FinalBallotController controller = loader.getController();
            controller.setMain(this);
            
            rootLayout.getStylesheets().add
            (Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSavePopUp () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Ballots/View/SavePopUp.fxml"));
            AnchorPane page = loader.load();


            Stage confirmSave = new Stage();
            confirmSave.setTitle("Form Saved");
            Scene confirmSaveScene = new Scene(page);
            confirmSave.setScene(confirmSaveScene);

            SavePopUpController controller = loader.getController();
            controller.setMain(this);
           
            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
            		+ "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
            		+ "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            confirmSave.setScene(new Scene(layout));
        

            


            confirmSave.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSaveConfirmationPopUp () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/ConfirmFormSave.fxml"));
            AnchorPane page = loader.load();


            Stage confirmSave = new Stage();
            confirmSave.setTitle("Form Saved");
            Scene confirmSaveScene = new Scene(page);
            confirmSave.setScene(confirmSaveScene);
            
           
            ConfirmFormSaveController controller = loader.getController();
            controller.setMain(this);
           
            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
            		+ "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
            		+ "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            confirmSave.setScene(new Scene(layout));
        
      
            
      


            confirmSave.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showNoOfficialTallyPopUp() {
        adminTallyView.showNoOfficialTallyPopUp();
    }

    public void showNoElectionPopUp() {
      adminTallyView.showNoElectionPopUp();
    }

    public void showElectionRunningPopUp() {
       adminTallyView.showElectionRunningPopUp();
    }

    public void endElectionPopUp() {
        adminTallyView.endElectionPopUp();
    }

    public void showOfficialTallyNeededPopUp() {
        adminTallyView.showOfficialTallyNeededPopUp();
    }

    public void showRegistrationStatusPositivePopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/registrationStatusPositivePopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Registration Status");


            registrationStatusPositivePopUpController controller = loader.getController();
            controller.setMain(this);
            
            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
            		+ "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
            		+ "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            popUp.setScene(new Scene(layout));
        
            popUp.showAndWait();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegistrationStatusNegativePopUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Registration/View/registrationStatusNegativePopUp.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Registration Status");


            registrationStatusNegativePopUpController controller = loader.getController();
            controller.setMain(this);
            
            HBox layout = new HBox(400);
            layout.setStyle("-fx-background-color: aliceblue; -fx-padding: 10;"
            		+ "-fx-font-family: TeX Gyre Adventor; -fx-font-size: 18px; -fx-font-weight:bold; "
            		+ "-fx-alignment: center;");

            layout.getChildren().addAll(page);
            popUp.setScene(new Scene(layout));
        
            popUp.showAndWait();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startElectionPopUp() {
        adminTallyView.startElectionPopUp();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
