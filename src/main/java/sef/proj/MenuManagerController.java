package sef.proj;


import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuManagerController implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private VBox pnItemsManage = null;
    @FXML
    private Button btnViewSchedule;

    @FXML
    private Button btnCreateSchedule;

    @FXML
    private Button btnManageSchedules;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlManageSchedule;

    @FXML
    private Pane pnlCreateSchedule;

    @FXML
    private Pane pnlOverview;

    @FXML
    private JFXButton viewEmployees;

    @FXML
    private JFXButton btnCreate;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pnlCreateSchedule.setVisible(false);
        pnlManageSchedule.setVisible(false);

        Node[] nodes = new Node[10];
        Node[] nodes_2 = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getClassLoader().getResource("sef/proj/Schedules.fxml"));
                nodes_2[i] = FXMLLoader.load(getClass().getClassLoader().getResource("sef/proj/SchedulesManage.fxml"));
                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);

                nodes_2[i].setOnMouseEntered(event -> {
                    nodes_2[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes_2[i].setOnMouseExited(event -> {
                    nodes_2[j].setStyle("-fx-background-color : #02030A");
                });
                pnItemsManage.getChildren().add(nodes_2[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @FXML
    private void setViewEmployees(MouseEvent event) {

        if(event.getSource() == viewEmployees) {
            PopupEmployees popupEmployees = new PopupEmployees();
            try {
                popupEmployees.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void btnCreateSchedule(MouseEvent event) {

    }
    public void handleClicks(ActionEvent actionEvent)  {
        if (actionEvent.getSource() == btnManageSchedules) {

            pnlManageSchedule.setVisible(true);
            pnlManageSchedule.setStyle("-fx-background-color : #FFFFFF");
            pnlManageSchedule.toFront();
        }

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