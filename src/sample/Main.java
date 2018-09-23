package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        primaryStage.setTitle("SC Electronic Voting");
        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }

    //Go to the voter registration page when the 'Register to Vote' button is clicked
    public void showVoterRegistration(){
        /*try {
            //I don't know how to do this

        }catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
