package sef.proj;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopupEmployeesController implements Initializable {


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
    }
}