package sef.proj;

import javafx.fxml.FXML;
import  javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sef.proj.UsernameAlreadyExistException;
import sef.proj.UserService;

public class RegistrationController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField email;
    @FXML
    private TextField tag;
    @FXML
    private ChoiceBox role;


    @FXML
    public void initialize() {
        role.getItems().addAll("Employee","Manager");
    }
    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(),email.getText(),tag.getText(),phonenumber.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
