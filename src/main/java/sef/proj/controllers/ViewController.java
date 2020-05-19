package sef.proj.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sef.proj.services.TaskService;
import sef.proj.services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {


    @FXML
    private Label description;

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
            TaskService.loadUsersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        description.setText(TaskService.getDescription(1));
    }
}