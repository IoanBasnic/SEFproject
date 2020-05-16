package sef.proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Popup extends Application {





    public void start() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sef/proj/popup.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);


        primaryStage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}