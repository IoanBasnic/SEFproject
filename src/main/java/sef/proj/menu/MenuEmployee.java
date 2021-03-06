package sef.proj.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuEmployee extends Application {
    private double x, y;




    public void start() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sef/proj/menuemployee.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}