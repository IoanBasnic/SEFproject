package sef.proj;


import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuEmployeeController implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnViewSchedule;

    @FXML
    private Button btnCreateSchedule;



    @FXML
    private Button btnSignout;

    @FXML
    private JFXButton btnCreate;

    @FXML
    private Pane pnlCreateSchedule;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TextField ScheduleName;

    @FXML
    private TextField ScheduleDate;

    @FXML
    private TextField ScheduleDescription;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pnlCreateSchedule.setVisible(false);
        try {
            TaskService.loadTaskFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getClassLoader().getResource("sef/proj/Schedules.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @FXML
    private void btnCreateSchedule(MouseEvent event) {
        if(event.getSource() == btnCreate) {
            try {

                TaskService.addTask(UserService.getGetName(), ScheduleName.getText(), ScheduleDate.getText(), ScheduleDescription.getText());
            } catch (UsernameAlreadyExistException e) {
                e.printStackTrace();
            } catch (TaskExistAlreadyException e) {
                e.printStackTrace();
            }
        }
    }
    public void handleClicks(ActionEvent actionEvent) {


        if (actionEvent.getSource() == btnViewSchedule) {

            pnlOverview.setStyle("-fx-background-color : #FFFFFF");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource() == btnCreateSchedule)
        {
            pnlCreateSchedule.setVisible(true);
            pnlCreateSchedule.setStyle("-fx-background-color : #FFFFFF");
            pnlCreateSchedule.toFront();
        }

        if(actionEvent.getSource() == btnSignout)
        {
            Stage stage = (Stage) btnSignout.getScene().getWindow();
            stage.close();
        }
    }
}