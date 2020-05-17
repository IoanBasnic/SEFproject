

package sef.proj;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;



/**
 *
 * @author JISOO
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane layersignup;
    @FXML
    private AnchorPane layer2;
    @FXML
    private JFXButton signin;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private JFXButton signup;
    @FXML
    private Label a2;
    @FXML
    private Label b2;
    @FXML
    private Label a1;
    @FXML
    private Label b1;
    @FXML
    private JFXButton btnsignup_manager;
    @FXML
    private JFXButton btnsignup_employee;
    @FXML
    private JFXButton btnsignin;
    @FXML
    private JFXButton btnforgot;
    @FXML
    private TextField reg_user;
    @FXML
    private TextField reg_email;
    @FXML
    private TextField reg_password;
    @FXML
    private TextField reg_tag;
    @FXML
    private TextField reg_phone;
    @FXML
    private TextField n1;
    @FXML
    private TextField n2;

    @FXML
    private AnchorPane layer1;
    @FXML
    private Label not_important_1;
    @FXML
    private Label not_important_2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            UserService.loadUsersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        s1.setVisible(false);
        s2.setVisible(false);
        signup.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        btnsignin.setVisible(false);
        btnforgot.setVisible(false);
        n1.setVisible(false);
        n2.setVisible(false);

        reg_user.setVisible(true);
        reg_email.setVisible(true);
        reg_password.setVisible(true);
        reg_tag.setVisible(true);
        reg_phone.setVisible(true);
    }

    @FXML
    private void btn(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(491);
        slide.play();

        layer1.setTranslateX(-309);
        btnsignin.setVisible(true);
        b1.setVisible(true);
        b2.setVisible(true);

        s1.setVisible(true);
        s2.setVisible(true);
        signup.setVisible(true);
        btnforgot.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        signin.setVisible(false);
        a1.setVisible(false);
        a2.setVisible(false);
        btnsignup_manager.setVisible(false);
        btnsignup_employee.setVisible(false);
        n1.setVisible(true);
        n2.setVisible(true);

        reg_user.setVisible(false);
        reg_email.setVisible(false);
        reg_password.setVisible(false);
        reg_tag.setVisible(false);
        reg_phone.setVisible(false);
        not_important_1.setVisible(false);
        not_important_2.setVisible(false);
        slide.setOnFinished((e->{


        }));
    }

    @FXML
    private void btn2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(0);
        slide.play();

        layer1.setTranslateX(0);
        btnsignin.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        s1.setVisible(false);
        s2.setVisible(false);
        signup.setVisible(false);
        l1.setVisible(true);
        l2.setVisible(true);
        signin.setVisible(true);
        btnforgot.setVisible(false);
        a1.setVisible(true);
        a2.setVisible(true);
        btnsignup_manager.setVisible(true);
        btnsignup_employee.setVisible(true);
        n1.setVisible(false);
        n2.setVisible(false);

        reg_user.setVisible(true);
        reg_email.setVisible(true);
        reg_password.setVisible(true);
        reg_tag.setVisible(true);
        reg_phone.setVisible(true);
        not_important_1.setVisible(true);
        not_important_2.setVisible(true);
        slide.setOnFinished((e->{


        }));
    }
    @FXML
    private void btnForgot(MouseEvent event) {
        if(event.getSource() == btnforgot) {
            Popup popup = new Popup();
            try {
                popup.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void btnsignup(MouseEvent event) {
        if(event.getSource() == btnsignup_manager) {

            try {
                UserService.addUser(reg_user.getText(), reg_password.getText(), reg_email.getText(), reg_tag.getText(), reg_phone.getText(), "Manager");
            } catch (UsernameAlreadyExistException e) {
                e.printStackTrace();
            }

        }

        if(event.getSource() == btnsignup_employee) {

            try {
                UserService.addUser(reg_user.getText(), reg_password.getText(), reg_email.getText(), reg_tag.getText(), reg_phone.getText(), "Employee");
            } catch (UsernameAlreadyExistException e) {
                e.printStackTrace();
            }

        }
    }

    private Menu enterDataFrame;
    private MenuEmployee enterDataFrame2;
    @FXML
    private void sign(MouseEvent event) throws Exception {
        if (event.getSource() == btnsignin) {
            enterDataFrame = new Menu();
            enterDataFrame2 = new MenuEmployee();


            if(UserService.CheckUser(n1.getText(), n2.getText()).equals("ItsManager")) {
                enterDataFrame.start();
                Stage stage = (Stage) btnsignin.getScene().getWindow();
                stage.close();
            }

            if(UserService.CheckUser(n1.getText(), n2.getText()).equals("ItsEmployee")) {
                enterDataFrame2.start();
                Stage stage = (Stage) btnsignin.getScene().getWindow();
                stage.close();
            }
        }
    }

    @FXML
    private void click(ActionEvent event) throws Exception {

        if (event.getSource() == btnsignin) {
            enterDataFrame = new Menu();
            enterDataFrame2 = new MenuEmployee();

            try {

                if(n1.getText().equals("manager-test")) {
                    enterDataFrame.start();
                    Stage stage = (Stage) btnsignin.getScene().getWindow();
                    stage.close();
                }

                if(n1.getText().equals("employee-test")) {
                    enterDataFrame2.start();
                    Stage stage_employee = (Stage) btnsignin.getScene().getWindow();
                    stage_employee.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
