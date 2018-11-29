package edu.cofc.Login.View;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.Login.Controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {
    private BorderPane rootLayout;
    private Main main;

    public LoginView(BorderPane boarderPane, Main m){
        rootLayout = boarderPane;
        main = m;
    }

    public void showInputInvalid(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("edu/cofc/Login/View/invalidInput.fxml"));
            AnchorPane page = loader.load();


            Stage popUp = new Stage();
            popUp.setTitle("Registration Status");


            InvalidInputController controller = loader.getController();
            controller.setMain(main);

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

