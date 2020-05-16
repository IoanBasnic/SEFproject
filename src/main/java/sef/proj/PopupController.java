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

public class PopupController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private TextField old_pass;
    @FXML
    private TextField new_pass;

    @FXML
    private JFXButton btnChangePass;
    @FXML
    private void ChangePass(MouseEvent event) {
        if(event.getSource() == btnChangePass) {
            UserService.ChangePassword(user.getText(), old_pass.getText(), new_pass.getText());
            Stage stage = (Stage) btnChangePass.getScene().getWindow();
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
