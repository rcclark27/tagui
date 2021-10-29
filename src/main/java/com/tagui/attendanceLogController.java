package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class attendanceLogController implements Initializable
{

    @FXML VBox hereTodayVBox;
    @FXML VBox perfectAttendance;
    @FXML VBox missingAttendance;

    @Override
    public void initialize(URL location, ResourceBundle arg1)
    {
        hereTodayVBox.setAlignment(Pos.BASELINE_CENTER);
        perfectAttendance.setAlignment(Pos.BASELINE_CENTER);
        missingAttendance.setAlignment(Pos.BASELINE_CENTER);

        // This is temporary for now, but how to add in new labels under a VBox
        Label label1 = new Label("Student 1");
        Label label2 = new Label("Student 2");
        Label label3 = new Label("Student 3");

        hereTodayVBox.getChildren().add(label1);
        hereTodayVBox.getChildren().add(label2);
        hereTodayVBox.getChildren().add(label3);

        Label label4 = new Label("Student 1");
        Label label5 = new Label("Student 2");
        Label label6 = new Label("Student 3");

        perfectAttendance.getChildren().add(label4);
        perfectAttendance.getChildren().add(label5);
        perfectAttendance.getChildren().add(label6);

        Label label7 = new Label("Student 1");
        Label label8 = new Label("Student 2");
        Label label9 = new Label("Student 3");

        missingAttendance.getChildren().add(label7);
        missingAttendance.getChildren().add(label8);
        missingAttendance.getChildren().add(label9);

    }

    public void logAttendance(ActionEvent event) throws IOException
    {
        Parent popUpParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logattendance.fxml")));
        Scene popUpScene = new Scene(popUpParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(popUpScene);
        window.show();
    }

    public void backButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

}
