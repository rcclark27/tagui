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

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class attendanceLogController implements Initializable
{

    @FXML VBox hereTodayVBox;
    @FXML VBox perfectAttendance;
    @FXML VBox missingAttendance;
    @FXML Label here1, here2, here3, here4, here5, here6, here7, here8, here9, here10, here11, here12, here13, here14, here15;
    //@FXML Label[] here = [here1, here2, here3, here4, here5, here6, here7, here8, here9, here10, here11, here12, here13, here14, here15,]

    @Override
    public void initialize(URL location, ResourceBundle arg1)
    {

        List<String> students = HomePage.values;

        hereTodayVBox.setAlignment(Pos.BASELINE_CENTER);
        perfectAttendance.setAlignment(Pos.BASELINE_CENTER);
        missingAttendance.setAlignment(Pos.BASELINE_CENTER);

        here1.setText(students.get(0));
        here2.setText(students.get(1));
        here3.setText(students.get(2));
        here4.setText(students.get(3));
        here5.setText(students.get(4));
        here6.setText(students.get(5));
        here7.setText(students.get(6));
        here8.setText(students.get(7));
        here9.setText(students.get(8));
        here10.setText(students.get(9));
        here11.setText(students.get(10));
        here12.setText(students.get(11));
        here13.setText(students.get(12));
        here14.setText(students.get(13));
        here15.setText(students.get(14));

//        if(1 < size){
//            here1.setText();
//        }

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
