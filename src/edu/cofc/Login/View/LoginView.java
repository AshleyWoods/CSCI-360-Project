package edu.cofc.Login.View;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Login.Controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class LoginView {
    private BorderPane rootLayout;
    private Main main;

    public LoginView(BorderPane boarderPane, Main m){
        rootLayout = boarderPane;
        main = m;
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
            controller.setMain(main);

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
            controller.setMain(main);

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
            controller.setMain(main);

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
            controller.setMain(main);
            //ADD CSS FILE
            AdminLogin.getStylesheets().add(Main.class.getClassLoader().getResource("edu/cofc/View/RootLayout/votingHomepage.css").toExternalForm());
            //END ADD CSS FILE


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
            controller.setMain(main, main.ElectionRunning);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

