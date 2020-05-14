package sef.proj;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnViewSchedule;

    @FXML
    private Button btnCreateSchedule;

    @FXML
    private Button btnManageSchedules;


    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnManageSchedules) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }

        if (actionEvent.getSource() == btnViewSchedule) {
            pnlOverview.setStyle("-fx-background-color : #FFFFFF");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource() == btnCreateSchedule)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }

        if(actionEvent.getSource()== btnSignout)
        {
            Stage stage = (Stage) btnSignout.getScene().getWindow();
            stage.close();
        }
    }
}