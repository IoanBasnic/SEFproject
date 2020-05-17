package sef.proj.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sef.proj.services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopupEmployeesController implements Initializable {

    @FXML
    private VBox EmployeesItem = null;
    @FXML
    private JFXButton btnExit;
    @FXML
    private void Exit(MouseEvent event) {
        if(event.getSource() == btnExit) {

            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            UserService.loadUsersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getClassLoader().getResource("sef/proj/ViewEmployees.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                EmployeesItem.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}