
package sef.proj.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import sef.proj.Menu;


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
    private Label n3;
    @FXML
    private AnchorPane layer1;
    @FXML
    private Label not_important_1;
    @FXML
    private Label not_important_2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s1.setVisible(false);
        s2.setVisible(false);
        signup.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        btnsignin.setVisible(false);
        n1.setVisible(false);
        n2.setVisible(false);
        n3.setVisible(false);
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
        l1.setVisible(false);
        l2.setVisible(false);
        signin.setVisible(false);
        a1.setVisible(false);
        a2.setVisible(false);
        btnsignup_manager.setVisible(false);
        btnsignup_employee.setVisible(false);
        n1.setVisible(true);
        n2.setVisible(true);
        n3.setVisible(true);
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
        a1.setVisible(true);
        a2.setVisible(true);
        btnsignup_manager.setVisible(true);
        btnsignup_employee.setVisible(true);
        n1.setVisible(false);
        n2.setVisible(false);
        n3.setVisible(false);
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
    private void btnsignup(MouseEvent event) {
    }

    @FXML
    private void sign(MouseEvent event) {

    }

    private Menu enterDataFrame;

    @FXML
    private void click(ActionEvent event) {

        if (event.getSource() == btnsignin) {
            enterDataFrame = new Menu();
            try {
                enterDataFrame.start();
                Stage stage = (Stage) btnsignin.getScene().getWindow();
                stage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

